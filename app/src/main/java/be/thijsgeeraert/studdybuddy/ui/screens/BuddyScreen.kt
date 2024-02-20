package be.thijsgeeraert.studdybuddy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.thijsgeeraert.studdybuddy.R
import be.thijsgeeraert.studdybuddy.data.User
import be.thijsgeeraert.studdybuddy.data.Vak

data class Buddy(
    val name: String,
    val rating: Int,
    val field: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuddyScreen(buddies: List<User>) {
    // Replace with actual icons
    val userIcon: Painter = painterResource(id = R.drawable.noun_mentor_1112698)
    val starIcon: Painter = painterResource(id = R.drawable.noun_star_5947137)

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
                text = stringResource(id = R.string.buddys),
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // List of buddies
        for (buddy in buddies) {
            BuddyItem(
                userIcon = userIcon,
                name = buddy.voornaam,
                rating = buddy.rating,
                field = buddy.vakken,
                starIcon = starIcon
            )
        }
    }
}

@Composable
fun BuddyItem(
    userIcon: Painter,
    name: String,
    rating: Int,
    field: List<Vak>,
    starIcon: Painter
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = userIcon,
                contentDescription = stringResource(id = R.string.user_icon_description),
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = starIcon,
                        contentDescription = stringResource(id = R.string.star_icon_description),
                        modifier = Modifier.size(24.dp)
                    )
                    Text(text = " $rating", fontSize = 16.sp)

                }
                Text(text = field, fontSize = 16.sp)

            }
        }
    }
}


