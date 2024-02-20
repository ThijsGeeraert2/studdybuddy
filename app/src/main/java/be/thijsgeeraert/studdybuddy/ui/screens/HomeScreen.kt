package be.thijsgeeraert.studdybuddy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.thijsgeeraert.studdybuddy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onFindBuddyClick: () -> Unit = {},
    onFindMentorClick: () -> Unit = {},
    onBecomeMentorClick: () -> Unit = {}
) {
    // Replace these with the actual drawable resource IDs for your icons
    val buddyIcon: Painter = painterResource(id = R.drawable.noun_mentor_1112698)
    val mentorIcon: Painter = painterResource(id = R.drawable.noun_mentor_1112698)
    val becomeMentorIcon: Painter = painterResource(id = R.drawable.noun_mentor_1112698)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header block

        Spacer(modifier = Modifier.height(60.dp))

        // Button for "Zoek een Buddy"
        OptionButton(
            icon = buddyIcon,
            text = stringResource(id = R.string.find_buddy),
            onClick = onFindBuddyClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button for "Zoek een mentor"
        OptionButton(
            icon = mentorIcon,
            text = stringResource(id = R.string.find_mentor),
            onClick = onFindMentorClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button for "Wordt een mentor"
        OptionButton(
            icon = becomeMentorIcon,
            text = stringResource(id = R.string.become_mentor),
            onClick = onBecomeMentorClick
        )
    }
}

@Composable
fun OptionButton(
    icon: Painter,
    text: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = icon,
                contentDescription = null, // Provide proper content description for accessibility
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = text,
                style = MaterialTheme.typography.headlineSmall
            )
        }
    }
}
