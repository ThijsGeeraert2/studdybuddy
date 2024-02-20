package be.thijsgeeraert.studdybuddy.data

object MockUp {
    fun getUsers(): List<User> {
        return listOf(
            User(
                "Jan",
                "Jansen",
                listOf(Vak("Wiskunde", 2023)),
                listOf(Vak("Natuurkunde", 2024), Vak("Geschiedenis", 2023)),
                emptyList()
            ),
            User(
                "Kees",
                "Klaassen",
                listOf(Vak("Nederlands", 2)),
                listOf(Vak("Biologie", 1), Vak("Engels", 1)),
                listOf(
                    User(
                        "Jan",
                        "Jansen",
                        listOf(Vak("Wiskunde", 1)),
                        listOf(Vak("Natuurkunde", 3), Vak("Geschiedenis", 1)),
                        emptyList()
                    )
                ) // Kees zoekt Jan als buddy
            )
        )
    }
    fun getVakken(): List<Vak> {
        return listOf(
            Vak("Wiskunde", 2),
            Vak("Natuurkunde", 1),
            Vak("Geschiedenis", 3),
            Vak("Biologie", 2),
            Vak("Engels", 1)
        )
    }
}

data class User(
    val voornaam: String,
    val achternaam: String,
    val isMentorVoor: List<Vak>,
    val vakken: List<Vak>,
    val zoekBuddy: List<User>
)

data class Vak (
    val naam: String,
    val jaar: Int
)
