package be.thijsgeeraert.studdybuddy.data

object MockUp {

    data class Message(
        val sender: String,
        val subject: String,
        val recipient: String,
        val content: String,
        val timestamp: String // Assuming timestamp is a string for simplicity
    )

    fun getMessages(): List<Message> {
        return listOf(
            Message(
                sender = "Jan Jansen",
                subject = "Problem Solving",
                recipient = "Kees Klaassen",
                content = "Heb je hulp nodig met Wiskunde?",
                timestamp = "10:15 AM"
            ),
            Message(
                sender = "Kees Klaassen",
                subject = "Full Stack Dev",
                recipient = "Jan Jansen",
                content = "Ja, zou geweldig zijn! Wanneer ben je beschikbaar?",
                timestamp = "10:17 AM"
            ),
            // ... Add more messages here
            Message(
                sender = "Sarah Sanders",
                subject = "Analysis & design",
                recipient = "Emma Evans",
                content = "Ik heb je notities van de les ontvangen, bedankt!",
                timestamp = "1:45 PM"
            ),
            Message(
                sender = "Emma Evans",
                subject = "Android Development",

                recipient = "Sarah Sanders",
                content = "Geen probleem, altijd blij om te helpen!",
                timestamp = "1:47 PM"
            )
        )
    }


    fun getUsers(): List<User> {
        return listOf(
            User(
                "Jan",
                "Jansen",
                listOf(Vak("Wiskunde", 3)),
                listOf(Vak("Natuurkunde", 1), Vak("Geschiedenis", 2)),
                emptyList(),
                4
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
                        emptyList(),
                        5
                    )
                ), // Kees zoekt Jan als buddy
                2
            ),
            User(
                "Sarah",
                "Sanders",
                listOf(Vak("Geschiedenis", 1)),
                listOf(Vak("Natuurkunde", 3), Vak("Biologie", 3)),
                emptyList(),
                4
            ),
            User(
                "Emma",
                "Evans",
                listOf(Vak("Engels", 1)),
                listOf(Vak("Wiskunde", 1), Vak("Nederlands", 2)),
                listOf(
                    User(
                        "Kees",
                        "Klaassen",
                        listOf(Vak("Nederlands", 1)),
                        listOf(Vak("Biologie", 1), Vak("Engels", 2)),
                        listOf(
                            User(
                                "Jan",
                                "Jansen",
                                listOf(Vak("Wiskunde", 1)),
                                listOf(Vak("Natuurkunde", 2), Vak("Geschiedenis", 1)),
                                emptyList(),
                                2
                            )
                        ), // Kees zoekt Jan als buddy
                        3
                    )
                ), // Emma zoekt Kees als buddy
                3
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
    val zoekBuddy: List<User>,
    val rating: Int
)

data class Vak (
    val naam: String,
    val jaar: Int
)

data class Message(
    val sender: String,
    val subject: String,
    val content: String
)
