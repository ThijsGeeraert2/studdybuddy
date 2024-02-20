package be.thijsgeeraert.studdybuddy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.thijsgeeraert.studdybuddy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    onRegisterClick: (String, String, String, String, String) -> Unit = { _, _, _, _, _ -> }
) {
    var name by remember { mutableStateOf("") }
    var familyName by remember { mutableStateOf("") }
    var school by remember { mutableStateOf("") }
    var subjects by remember { mutableStateOf("") }
    var direction by remember { mutableStateOf("") }

    // Logo painter, replace R.drawable.logo_vives with your actual logo resource
    //val logo: Painter = painterResource(id = R.drawable.logo_vives)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header block
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.register),
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Name input field
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(stringResource(id = R.string.name)) },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Family name input field
        OutlinedTextField(
            value = familyName,
            onValueChange = { familyName = it },
            label = { Text(stringResource(id = R.string.family_name)) },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // School input field
        OutlinedTextField(
            value = school,
            onValueChange = { school = it },
            label = { Text(stringResource(id = R.string.school)) },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Subject input field
        OutlinedTextField(
            value = subjects,
            onValueChange = { subjects = it },
            label = { Text(stringResource(id = R.string.subjects)) },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Direction input field
        OutlinedTextField(
            value = direction,
            onValueChange = { direction = it },
            label = { Text(stringResource(id = R.string.direction)) },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Registration button
        Button(
            onClick = { onRegisterClick(name, familyName, school, subjects, direction) },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(Color.Red)
        ) {
            Text(text = stringResource(id = R.string.go_further), fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Logo at the bottom of the screen

    }
}
