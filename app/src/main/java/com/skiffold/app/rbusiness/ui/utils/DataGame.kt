package com.skiffold.app.rbusiness.ui.utils

class DataGame {
    companion object{
        val DATA_JOBS = listOf(
            JobModel("Нет", 0, 0, true),
            JobModel("Дворник", 150, 10, false),
            JobModel("Сторож", 250, 300, false),
            JobModel("Швейцар", 150, 10, false),
            JobModel("Продавец на рынке", 150, 10, false),
            JobModel("Кассир в магазине", 150, 10, false),
            JobModel("Бухгалтер", 150, 10, false),
            JobModel("Главный бухгалтер", 150, 10, false),
            JobModel("Зам.Директора", 150, 10, false),
            JobModel("Директор", 150, 10, false),
            JobModel("Депутат", 150, 10, false)
        )
    }

    data class JobModel(
        var name: String,
        var money: Int,
        var experience: Int,
        var selected: Boolean
    )
}