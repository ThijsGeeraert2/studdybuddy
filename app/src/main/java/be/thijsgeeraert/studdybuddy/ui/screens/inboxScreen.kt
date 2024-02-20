package be.thijsgeeraert.studdybuddy.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.thijsgeeraert.studdybuddy.R

data class Message(
    val sender: String,
    val subject: String,
    val content: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InboxScreen(messages: List<Message>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        // List of messages
        messages.forEach { message ->
            InboxItem(
                sender = message.sender,
                subject = message.subject,
                content = message.content
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun InboxItem(
    sender: String,
    subject: String,
    content: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(text = "$sender - $subject", fontSize = 18.sp, fontWeight = FontWeight.Bold)
            Text(text = content, fontSize = 16.sp)
        }
    }
}

@Composable
fun MainScreen() {
    // Dummy list of messages for demonstration purposes
    val messages = listOf(
        Message("Eduard Vandamme", "Problem Solving", "Heeft 5 afbeeldingen verstuurd"),
        Message("Dieter Vancollie", "Full Stack Dev", "Kan je me helpen bij opdracht 10?"),
        // ... Add other messages here
    )

    // Inbox screen
    InboxScreen(messages = messages)
}

@Preview
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
