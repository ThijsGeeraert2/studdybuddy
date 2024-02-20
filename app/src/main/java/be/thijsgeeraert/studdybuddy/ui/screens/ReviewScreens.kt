package be.thijsgeeraert.studdybuddy.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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

data class Review(
    val reviewerName: String,
    val rating: Int,
    val comment: String
)

@Composable
fun ReviewsScreen(reviews: List<Review>) {
    // Replace with actual drawable resources
    val userIcon: Painter = painterResource(id = R.drawable.user)
    val starIcon: Painter = painterResource(id = R.drawable.ster)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
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
                text = stringResource(id = R.string.reviews),
                fontSize = 24.sp,
                color = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // List of reviews
        reviews.forEach { review ->
            ReviewItem(
                userIcon = userIcon,
                reviewerName = review.reviewerName,
                rating = review.rating,
                comment = review.comment,
                starIcon = starIcon
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ReviewItem(
    userIcon: Painter,
    reviewerName: String,
    rating: Int,
    comment: String,
    starIcon: Painter
) {
    Card(
        modifier = Modifier.fillMaxWidth()
            .padding(vertical = 4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = userIcon,
                    contentDescription = stringResource(id = R.string.user_icon_description),
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column {
                    Text(text = reviewerName, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        repeat(rating) {
                            Image(
                                painter = starIcon,
                                contentDescription = stringResource(id = R.string.star_icon_description),
                                modifier = Modifier.size(24.dp)
                            )
                        }
                        // Assuming a max rating of 5, we add the empty stars
                        repeat(5 - rating) {
                            Image(
                                painter = starIcon,
                                contentDescription = stringResource(id = R.string.star_icon_description_empty), // Add this to strings.xml
                                modifier = Modifier.size(24.dp),
                                colorFilter = androidx.compose.ui.graphics.ColorFilter.tint(Color.LightGray)
                            )
                        }
                    }
                    Text(text = comment, fontSize = 16.sp)
                }
            }
        }
    }}

// Sample data for preview
@Preview(showBackground = true)
@Composable
fun PreviewReviewsScreen() {
    ReviewsScreen(
        reviews = listOf(
            Review("Maxime Theys", 4, "Reageert snel!"),
            Review("Maxime Theys", 3, "Reageert snel!"),
// Add more reviews
        )
    )
}