package be.thijsgeeraert.studdybuddy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import be.thijsgeeraert.studdybuddy.R
import be.thijsgeeraert.studdybuddy.data.MockUp.getUsers
import be.thijsgeeraert.studdybuddy.data.User
import be.thijsgeeraert.studdybuddy.data.Vak

// Assuming Vak has a property 'naam' which is a String

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MentorScreen(mentors: List<User>, onclickDetail: () -> Unit = {}, onFilterClicked: () -> Unit= {}, onChatClicked: () -> Unit  = {}) {
    // Replace with actual drawable and string resources
    val userIcon: Painter = painterResource(id = R.drawable.user)
    val starIcon: Painter = painterResource(id = R.drawable.noun_star_5947137)



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header block


        Spacer(modifier = Modifier.height(60.dp))

        CourseHeader(onFilterClicked, onChatClicked)

        // List of mentors
        mentors.forEach { mentor ->
            MentorItem(
                userIcon = userIcon,
                name = "${mentor.voornaam} ${mentor.achternaam}",
                rating = mentor.rating,
                field = mentor.vakken.joinToString(", ") { it.naam },
                starIcon = starIcon,
                onClick = onclickDetail
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun MentorItem(
    userIcon: Painter,
    name: String,
    rating: Int,
    field: String,
    starIcon: Painter,
    onClick: () -> Unit = {},

    ) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
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
            Column()
            {
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

@Composable
fun CourseHeader(
    onFilterClicked: () -> Unit = {},
    onChatClicked: () -> Unit = {}
) {
    // Replace with actual drawable resources
    val filterIcon: Painter = painterResource(id = R.drawable.filter) // Your filter icon
    val chatIcon: Painter = painterResource(id = R.drawable.chat) // Your chat icon
    val courseName = "Business Management 1" // Replace with a dynamic value if necessary

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Filter button
        IconButton(onClick = onFilterClicked) {
            Icon(
                painter = filterIcon,
                contentDescription = stringResource(id = R.string.cd_filter_icon),
                modifier = Modifier.size(24.dp) // You can adjust the size if needed
            )
        }

        Text(
            text = courseName,
            fontSize = 18.sp,
            modifier = Modifier.weight(1f).padding(horizontal = 8.dp)
        )


    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMentorScreen2() {
    MentorScreen(getUsers())
}

// Define your string and drawable resource IDs in your project
// R.string.mentors
// R.string.user_icon_description
// R.string.star_icon_description
// R.drawable.ic_user
// R.drawable.ic_star
