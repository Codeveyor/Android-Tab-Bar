package com.example.androidtabbar

object DataSource {
    val users = listOf<User>(
        User("Esperanza", "Spalding", null, "Contrabass"),
        User("Suzi", "Quatro", null, "Fender Precision 4 string"),
        User("Carol", "Kaye", null, "Fender Precision 4 string"),
        User("Kim", "Gordon", null, "Gibson 4 string"),
        User("Antonella", "Mazza", null, "Warwick Streamer 4 string"),
        User("Tal", "Wilkenfeld", null, "Sadowsky 4 string"),
        User("Divinity", "Roxx", null, "Warwick Streamer 5 string"),
        User("Mohini", "Dey", null, "Mayones 5 string"),
        User("Kinga", "Glyk", null, "Fender Jazz Bass 4 string"),
        User("Rhonda", "Smith", null, "PRS 4 string"),
        User("Victor", "Wooten", null, "Fodera 4 string"),
        User("Brian", "Bromberg", null, "Contrabass"),
        User("Steve", "Bailey", null, "Fodera 4 string"),
        User("Marcus", "Miller", null, "Fender Jazz Bass 4 string"),
        User("Stanley", "Clarke", null, "Alembic 4 string"),
        User("Jaco", "Pastorius", null, "Fender Jazz Bass fretless"),
        User("John", "Patitucci", null, "Contrabass"),
        User("Avishai", "Cohen", null, "Contrabass"),
        User("Richard", "Bona", null, "Fodera 5 string"),
        User("Alex", "Golub", null, "Chapman Stick")
    )
}

data class User(
    val firstName: String,
    val lastName: String,
    val avatar: String? = null,
    val instrument: String
)
