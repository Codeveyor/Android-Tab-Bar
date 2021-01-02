package com.example.androidtabbar.dataSource

import com.example.androidtabbar.R

object DataSource {
    val users = listOf<User>(
        User("Esperanza", "Spalding", R.drawable.esperanza, "Contrabass"),
        User("Suzi", "Quatro", R.drawable.suzi, "Fender Precision 4 string"),
        User("Carol", "Kaye", R.drawable.carol, "Fender Precision 4 string"),
        User("Kim", "Gordon", R.drawable.kim, "Gibson 4 string"),
        User("Antonella", "Mazza", R.drawable.antonella, "Warwick Streamer 4 string"),
        User("Tal", "Wilkenfeld", R.drawable.tal, "Sadowsky 4 string"),
        User("Divinity", "Roxx", R.drawable.divinity, "Warwick Streamer 5 string"),
        User("Mohini", "Dey", R.drawable.mohini, "Mayones 5 string"),
        User("Kinga", "Glyk", R.drawable.kinga, "Fender Jazz Bass 4 string"),
        User("Rhonda", "Smith", R.drawable.rhonda, "PRS 4 string"),
        User("Victor", "Wooten", R.drawable.victor, "Fodera 4 string"),
        User("Brian", "Bromberg", R.drawable.brian, "Contrabass"),
        User("Steve", "Bailey", R.drawable.steve, "Fodera 4 string"),
        User("Marcus", "Miller", R.drawable.marcus, "Fender Jazz Bass 4 string"),
        User("Stanley", "Clarke", R.drawable.stanley, "Alembic 4 string"),
        User("Jaco", "Pastorius", R.drawable.jaco, "Fender Jazz Bass fretless"),
        User("John", "Patitucci", R.drawable.john, "Contrabass"),
        User("Avishai", "Cohen", R.drawable.avishai, "Contrabass"),
        User("Richard", "Bona", R.drawable.richard, "Fodera 5 string"),
        User("Alex", "Golub", R.drawable.alex, "Chapman Stick")
    )
}

data class User(
    val firstName: String,
    val lastName: String,
    val avatar: Int,
    val instrument: String
)
