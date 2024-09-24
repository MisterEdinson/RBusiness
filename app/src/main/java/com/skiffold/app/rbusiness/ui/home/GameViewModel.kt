package com.skiffold.app.rbusiness.ui.home

import android.os.Build
import android.os.Handler
import android.os.Looper
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(): ViewModel() {
    private var startTime = 0L
    private var elapsedTime = 0L
    private var running = false
    private val handler = Handler(Looper.getMainLooper())
    private val updateInterval = 1000L
    @RequiresApi(Build.VERSION_CODES.O)
    private var currentDate: LocalDate = LocalDate.of(2024, 9, 24)

    private val _currentDateLiveData = MutableLiveData<String>()
    val currentDateLiveData: LiveData<String> get() = _currentDateLiveData
    val balance = MutableLiveData(5)
    val experience = MutableLiveData(0)

    private val updateTask = object : Runnable {
        @RequiresApi(Build.VERSION_CODES.O)
        override fun run() {
            if (running) {
                elapsedTime = System.currentTimeMillis() - startTime
                handler.postDelayed(this, updateInterval)
                currentDate = currentDate.plusDays(1)
                val formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                _currentDateLiveData.postValue(formattedDate)
            }
        }
    }

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
        currentDate = LocalDate.of(2024, 9, 24) // Сбрасываем дату
        _currentDateLiveData.postValue(currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")))
    }

    override fun onCleared() {
        super.onCleared()
        handler.removeCallbacks(updateTask)
    }
}