package com.skiffold.app.rbusiness.ui.utils

class DataGame {
    companion object{
        val DATA_JOBS = listOf(
            JobModel("Нет", 0, 0, true),
            JobModel("Дворник", 150, 5, false),
            JobModel("Сторож", 250, 45, false),
            JobModel("Швейцар", 350, 500, false),
            JobModel("Продавец на рынке", 450, 805, false),
            JobModel("Кассир в магазине", 500, 999, false),
            JobModel("Бухгалтер", 600, 2000, false),
            JobModel("Главный бухгалтер", 1000, 5000, false),
            JobModel("Зам.Директора", 1500, 8000, false),
            JobModel("Директор", 2000, 12000, false),
            JobModel("Депутат", 5000, 20000, false)
        )

        val DATA_EDUCATION = listOf(
            JobModel("Вечерняя школа", 60, 30, false),
            JobModel("Курсы английского языка", 90, 60, false),
            JobModel("Курсы по менеджменту", 160, 80, false),
            JobModel("Лекции по бухгалтерскому учету", 170, 90, false),
            JobModel("Лекции по банковскому делу", 250, 150, false)
        )

        val DATA_PRODUCT = listOf(
            ProductModel("Сигареты Marlboro", 3, 1, 0, "шт", 1),
            ProductModel("Сигареты Parliament", 5, 2, 0, "шт", 1),
            ProductModel("Самогон", 6, 2, 0, "бут.", 1),
            ProductModel("Водка", 10, 4, 0, "бут.", 2),
            ProductModel("Виски", 50, 35, 0, "бут.", 5),
            ProductModel("Криптовалюта", 65000, 55000, 0, "шт", 200)
        )

        val DATA_SHOP = listOf(
            MarketModel(1, "Коммуналка", 15000, false, 100),
            MarketModel(1, "1-комнатная", 45000, false, 300),
            MarketModel(1, "2-комнатная", 55000, false, 300),
            MarketModel(1, "3-комнатная", 65000, false, 300),
            MarketModel(1, "4-комнатная", 75000, false, 300),
            MarketModel(1, "Аппартаменты", 165000, false, 1000),
            MarketModel(1, "VIP-Аппартаменты", 265000, false, 1200),
            MarketModel(2, "Дачный участок", 100000, false, 800),
            MarketModel(2, "Дачный домик", 150000, false, 1100),
            MarketModel(2, "Загородный дом", 200000, false, 1200),
            MarketModel(2, "Коттедж", 465000, false, 1500),
            MarketModel(2, "Вилла", 665000, false, 2000),
            MarketModel(2, "3-х этажная вилла", 900000, false, 3000),
            MarketModel(2, "Охраняемый обьект", 4500000, false, 5000),
        )

        val DATA_MAFIA = listOf(
            AvtoritetModel("Николай Петрович", "Охранник в супермаркете" , "Коршун",10, false, 5, 0),
            AvtoritetModel("Валерий Иванович", "Владелец магазина", "Кулак", 40, false, 300, 30),
            AvtoritetModel("Игорь Николаевич","Смотрящий на рынке", "Решала", 50, false, 500, 50),
            AvtoritetModel("Марат Генадьевич", "Главный в городе","Мара",50, false, 2000, 100),
            AvtoritetModel("Аркадий Филипович", "Генерал ФСБ","Аркан",50, false, 3000, 200),
            AvtoritetModel("Василий Васильевич", "Владелец всех дворцов параходов","ВВ",50, false, 10000, 1000),
        )

        val DATA_NEGATIVE = listOf(
            Message(0, "", "", 5, 1),
            Message(0, "", "", 100, 1),
            Message(0, "", "", 100,1),
            Message(0, "", "", 100,1),
        )

        val DATA_STATUS = listOf(
            StatusModel(0,"Бомж"),
            StatusModel(1,"Нищий"),
            StatusModel(2,"Бедный"),
            StatusModel(3,"Средний класс"),
            StatusModel(4,"Зажиточный"),
            StatusModel(5,"Выше среднего"),
            StatusModel(6,"Богатый"),
            StatusModel(7,"Очень богатый"),
            StatusModel(8,"Олигарх"),
            StatusModel(9,"Инопланетянин")
        )
    }

    data class JobModel(
        var name: String,
        var money: Int,
        var experience: Int,
        var selected: Boolean
    )

    data class ProductModel(
        var name: String,
        var moneyMax: Int,
        var moneyMin: Int,
        var countHave: Int,
        var unit: String,
        var experience: Int
    )

    data class MarketModel(
        var type: Int,
        var name: String,
        var money: Int,
        var countHave: Boolean,
        var experience: Int
    )

    data class AvtoritetModel(
        var name: String,
        var status: String,
        var nick: String,
        var moneyPercent: Int,
        var hiring: Boolean,
        var autoritet: Int,
        var experience: Int
    )

    data class Message(
        var id: Int,
        var image: String,
        var title: String,
        var money: Int,
        var moneyPercent: Int
    )
    data class StatusModel(
        val id: Int,
        val title: String
    )
}