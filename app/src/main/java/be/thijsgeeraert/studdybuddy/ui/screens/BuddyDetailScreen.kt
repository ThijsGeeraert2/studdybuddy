package be.thijsgeeraert.studdybuddy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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

@Preview(showBackground = true)
@Composable
fun PreviewBuddyDetailScreen() {
    BuddyDetailScreen()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BuddyDetailScreen() {
    // Replace with actual drawable and string resources
    val userIcon: Painter = painterResource(id = R.drawable.noun_mentor_1112698)
    val starIcon: Painter = painterResource(id = R.drawable.noun_star_5947137)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Eduard Vandamme",
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = userIcon,
            contentDescription = stringResource(id = R.string.user_icon_description),
            modifier = Modifier
                .size(120.dp)
                .border(2.dp, Color.Black, CircleShape)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = starIcon,
                contentDescription = stringResource(id = R.string.star_icon_description),
                modifier = Modifier.size(24.dp)
            )
            Text(text = "10", fontSize = 24.sp)
        }

        Text(text = "2 Software Dev", fontSize = 18.sp)
        Text(text = "2004", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO: Implement click action */ },
            colors = ButtonDefaults.buttonColors(Color.Red),
            shape = RoundedCornerShape(50),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.subjects_buddy),
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = { /* TODO: Implement click action */ },
            colors = ButtonDefaults.buttonColors(Color.Red),
            shape = RoundedCornerShape(50),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.subjects_mentor),
                color = Color.White,
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.Red, RoundedCornerShape(8.dp)),
            elevation = CardDefaults.cardElevation(0.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.about_me),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Red
                )
                Text(
                    text = "Als student zoek ik constant naar manieren om samen te leren en te groeien.",
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = { /* TODO: Implement click action */ },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(Color.Red),
                    shape = RoundedCornerShape(50)
                ) {
                    Text(
                        text = stringResource(id = R.string.contact),
                        color = Color.White,
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}
