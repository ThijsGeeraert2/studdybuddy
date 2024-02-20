package be.thijsgeeraert.studdybuddy.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun VakkenScreen(onGoNext: () -> Unit = {}) {
    // Replace with actual string resources
    val subjects = listOf("android", "bpm", "nederlands")
    val categories = listOf("Toegepaste informatica", "Autotechnologie", "Ecotechnologie")
    var selectedCategory by remember { mutableStateOf("") }
    var selectedSubject by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Vakken",
            fontSize = 24.sp,
            color = Color.Red,
            modifier = Modifier.align(Alignment.Start)
        )

        Spacer(modifier = Modifier.height(16.dp))

        categories.forEach { category ->
            TextButton(
                onClick = { selectedCategory = if (selectedCategory == category) "" else category },
                colors = ButtonDefaults.textButtonColors(
                    containerColor = if (selectedCategory == category) Color.LightGray else Color.Transparent
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = category,
                    color = Color.Black,
                    fontSize = 18.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        subjects.forEach { subject ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = selectedSubject == subject,
                    onCheckedChange = { selectedSubject = if (selectedSubject == subject) "" else subject }
                )
                Text(text = subject, fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = onGoNext,
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(Color.Red)
            ) {
                Text(text = "Ga verder", color = Color.White)
            }
            Button(
                onClick = onGoNext,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "annuleren", color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewVakkenScreen() {
    VakkenScreen()
}