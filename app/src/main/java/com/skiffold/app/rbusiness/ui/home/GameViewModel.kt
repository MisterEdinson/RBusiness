package com.skiffold.app.rbusiness.ui.home

import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skiffold.app.rbusiness.ui.utils.DataGame
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(): ViewModel() {

    var job = MutableLiveData(0)
    var balance = MutableLiveData(5)
    var experience = MutableLiveData(5)
    var status = MutableLiveData(0)
    var house = MutableLiveData(0)
    var car = MutableLiveData(0)
    var autoritet = MutableLiveData(0)
    var deposit = MutableLiveData(0)
    var credit = MutableLiveData(0)
    var educations = mutableListOf<DataGame.JobModel>()

    var dataSelectedJobs = DataGame.DATA_JOBS
    var dataSelectedEducation = DataGame.DATA_EDUCATION
    var dataProducts = DataGame.DATA_PRODUCT
    var dataShop = DataGame.DATA_SHOP
    var dataMafia = DataGame.DATA_MAFIA

    private var startTime = 0L
    private var elapsedTime = 0L
    private var running = false
    private val handler = Handler(Looper.getMainLooper())
    private val updateInterval = 1000L
    @RequiresApi(Build.VERSION_CODES.O)
    private var currentDate: LocalDate = LocalDate.of(2024, 9, 24)
    @RequiresApi(Build.VERSION_CODES.O)
    private var lastMonth: Int = currentDate.monthValue

    private val _currentDateLiveData = MutableLiveData<String>()
    val currentDateLiveData: LiveData<String> get() = _currentDateLiveData

    private val updateTask = object : Runnable {
        @RequiresApi(Build.VERSION_CODES.O)
        override fun run() {
            if (running) {
                elapsedTime = System.currentTimeMillis() - startTime
                handler.postDelayed(this, updateInterval)
                currentDate = currentDate.plusDays(1)
                if (currentDate.monthValue != lastMonth) {
                    onNewMonthStart()
                    lastMonth = currentDate.monthValue
                }
                val formattedDate = currentDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
                _currentDateLiveData.postValue(formattedDate)
            }
        }
    }
    // начало месяца
    private fun onNewMonthStart(){
        job.value?.let { balance.value = balance.value?.plus(dataSelectedJobs[it].money) }
        job.value?.let { experience.value = experience.value?.plus(dataSelectedJobs[it].experience) }
        educations.forEach {
            balance.value = balance.value?.minus(it.money)
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