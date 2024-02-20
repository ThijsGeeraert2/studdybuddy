package be.thijsgeeraert.studdybuddy.ui.screens

import androidx.compose.foundation.background
import be.thijsgeeraert.studdybuddy.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onConfirmClick: (String, String) -> Unit = { _, _ -> },
    onCancelClick: () -> Unit = {},
    onRegisterClick: () -> Unit = {}
) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.welcome), // Change the string to "welcome"
            fontSize = 24.sp,
            color = Color.White, // Change text color to white
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red) // Add a red background
                .padding(16.dp) // Add padding around the text
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(stringResource(id = R.string.username)) }, // Change the string to "gebruikersnaam"
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(stringResource(id = R.string.password)) }, // Change the string to "wachtwoord"
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = { onConfirmClick(username, password) },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(Color.Red) // Set the confirm button to red
            ) {
                Text(text = stringResource(id = R.string.go_on)) // Change the string to "Ga verder"
            }

            Button(
                onClick = onCancelClick,
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(Color.Gray) // Set the cancel button to gray
            ) {
                Text(text = stringResource(id = R.string.cancel)) // Keep the string as "annuleren"
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // This would be the additional button shown in your screenshot, presumably for another action
        Button(
            onClick = { /* Handle click action */ },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp), // Match the height of the button in the screenshot
            colors = ButtonDefaults.buttonColors(Color.Red) // Set the button to red
        ) {
            // The text of this button is not visible in the screenshot. Replace 'R.string.additional_action' with the correct string resource id.
            Text(text = stringResource(id = R.string.additional_action), color = Color.White)
        }
    }
}