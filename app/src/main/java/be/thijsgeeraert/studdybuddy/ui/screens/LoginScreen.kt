package be.thijsgeeraert.studdybuddy.ui.screens

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.thijsgeeraert.studdybuddy.ui.theme.StuddybuddyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage(
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
            text = stringResource(id = R.string.login),
            fontSize = 24.sp,
            color = Color.Red,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(32.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(stringResource(id = R.string.username)) },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(stringResource(id = R.string.password)) },
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
            ) {
                Text(text = stringResource(id = R.string.confirm))
            }

            Button(
                onClick = onCancelClick,
                modifier = Modifier.weight(1f),
            ) {
                Text(text = stringResource(id = R.string.cancel))
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        ClickableText(
            text = AnnotatedString(stringResource(id = R.string.register)),
            onClick = { onRegisterClick() },
            style = TextStyle(color = Color.Blue, textDecoration = TextDecoration.Underline)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PhotosGridScreenPreview() {
    StuddybuddyTheme {
        LoginPage()
    }
}
