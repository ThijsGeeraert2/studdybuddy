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
fun BuddyScreen(buddies: List<User>, onclickDetail: () -> Unit = {}, onFilterClicked: () -> Unit= {}, onChatClicked: () -> Unit  = {}) {
    // Replace with actual icons
    val userIcon: Painter = painterResource(id = R.drawable.user)
    val starIcon: Painter = painterResource(id = R.drawable.ster)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header block

        Spacer(modifier = Modifier.height(60.dp))

        CourseHeader(onFilterClicked, onChatClicked)
        // List of buddies
        for (buddy in buddies) {
            BuddyItem(
                userIcon = userIcon,
                name = buddy.voornaam,
                rating = buddy.rating,
                field = buddy.vakken,
                starIcon = starIcon,
                onClick = onclickDetail
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
    onClick: () -> Unit = {},
    starIcon: Painter
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
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
                Text(text = field.map { n -> n.naam }.joinToString(", "), fontSize = 16.sp)

            }
        }
    }
}


