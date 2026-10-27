# HeartSync v1.0 — Native Android Encrypted Companion & State Sync Engine

Native Kotlin/Android companion application engineered with hardware-backed `AES-256-GCM` local vault storage, deterministic vector-clock state synchronization, and low-latency haptic telemetry.

## Core Modules

- **`VaultCipherEngine.kt`**: Hardware-backed Android Keystore key generation (`KeyProperties.KEY_ALGORITHM_AES`), `AES/GCM/NoPadding` 128-bit authentication tag encryption, and zero-knowledge local persistence.
- **`DeterministicStateSync.kt`**: Monotonic Lamport & vector-clock conflict resolution (`CRDT` LWW-Element-Set) with offline mutation queue replay and SHA-256 payload deduplication.
- **`HeartSyncDashboardActivity.kt`**: Jetpack Compose / Material 3 real-time companion status surface and low-latency tactile waveform controller.
