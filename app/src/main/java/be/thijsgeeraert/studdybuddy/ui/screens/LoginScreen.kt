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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.thijsgeeraert.studdybuddy.ui.theme.GoodGreen
import be.thijsgeeraert.studdybuddy.ui.theme.GoodGrey
import be.thijsgeeraert.studdybuddy.ui.theme.GoodRed
import be.thijsgeeraert.studdybuddy.ui.theme.StuddybuddyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    onConfirmClick: () -> Unit,
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
            modifier = Modifier.width(300.dp),
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            Button(
                onClick = { onConfirmClick() },
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(GoodRed) // Set the confirm button to red
            ) {
                Text(text = stringResource(id = R.string.go_on)) // Change the string to "Ga verder"
            }

            Button(
                onClick = onCancelClick,
                modifier = Modifier.weight(1f),
                colors = ButtonDefaults.buttonColors(GoodGrey) // Set the cancel button to gray
            ) {
                Text(text = stringResource(id = R.string.cancel)) // Keep the string as "annuleren"
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        // This would be the additional button shown in your screenshot, presumably for another action
        Button(
            onClick = { /* Handle click action */ },
            modifier = Modifier
                .width(300.dp)
                .height(48.dp), // Match the height of the button in the screenshot
            colors = ButtonDefaults.buttonColors(GoodGreen) // Set the button to red
        ) {
            // The text of this button is not visible in the screenshot. Replace 'R.string.additional_action' with the correct string resource id.
            Text(text = stringResource(id = R.string.additional_action), color = Color.Black)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PhotosGridScreenPreview() {
    StuddybuddyTheme {
        LoginScreen(onConfirmClick = {})
    }
}