package com.arkgon.heartsync.sync

import java.security.MessageDigest

data class SyncEnvelope(
    val nodeId: String,
    val lamportClock: Long,
    val timestampEpochMs: Long,
    val payloadJson: String,
    val sha256Digest: String
)

class DeterministicStateSync(private val localNodeId: String) {
    private var clock: Long = 0L
    private val stateMap = mutableMapOf<String, SyncEnvelope>()

    fun createEnvelope(key: String, payloadJson: String, nowMs: Long): SyncEnvelope {
        clock += 1
        val digest = MessageDigest.getInstance("SHA-256")
            .digest("$localNodeId:$clock:$payloadJson".toByteArray())
            .joinToString("") { "%02x".format(it) }
        val env = SyncEnvelope(localNodeId, clock, nowMs, payloadJson, digest)
        stateMap[key] = env
        return env
    }

    fun mergeRemote(key: String, remote: SyncEnvelope): Boolean {
        clock = maxOf(clock, remote.lamportClock) + 1
        val current = stateMap[key]
        if (current == null || remote.lamportClock > current.lamportClock ||
            (remote.lamportClock == current.lamportClock && remote.timestampEpochMs >= current.timestampEpochMs)) {
            stateMap[key] = remote
            return true
        }
        return false
    }
}
