package com.arkgon.heartsync.ui

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class HeartSyncDashboardActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = TextView(this).apply {
            text = "HeartSync v1.0 — AES-256-GCM Hardware Vault & Deterministic CRDT Sync Ready"
            textSize = 16f
            setPadding(48, 48, 48, 48)
        }
        setContentView(view)
    }
}
