package com.skiffold.app.rbusiness.ui.utils

import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter
class Stopwatch {
    private var startTime = 0L
    private var elapsedTime = 0L
    private var running = false
    private val handler = Handler(Looper.getMainLooper())
    private val updateInterval = 1000L
    @RequiresApi(Build.VERSION_CODES.O)
    private var currentDate: LocalDate = LocalDate.of(2024, 9, 24) // Стартовая дата

    private val updateTask = object : Runnable {
        @RequiresApi(Build.VERSION_CODES.O)
        override fun run() {
            if (running) {
                elapsedTime = System.currentTimeMillis() - startTime
                handler.postDelayed(this, updateInterval)
                currentDate = currentDate.plusDays(1)
                val formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                onTick(formattedDate)
            }
        }
    }

    var onTick: (String) -> Unit = {}

    fun start() {
        if (!running) {
            startTime = System.currentTimeMillis() - elapsedTime
            running = true
            handler.post(updateTask)
        }
    }

    fun stop() {
        if (running) {
            running = false
            handler.removeCallbacks(updateTask)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun reset() {
        stop()
        elapsedTime = 0L
        currentDate = LocalDate.of(2024, 9, 24)
        onTick(currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
    }

    fun getElapsedTime(): Long {
        return elapsedTime / 1000
    }
}
