package be.thijsgeeraert.studdybuddy

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import be.thijsgeeraert.studdybuddy.data.MockUp.getUsers
import be.thijsgeeraert.studdybuddy.ui.screens.BuddyDetailScreen
import be.thijsgeeraert.studdybuddy.ui.screens.BuddyScreen
import be.thijsgeeraert.studdybuddy.ui.screens.HomeScreen
import be.thijsgeeraert.studdybuddy.ui.screens.InboxScreen
import be.thijsgeeraert.studdybuddy.ui.screens.LoginScreen
import be.thijsgeeraert.studdybuddy.ui.screens.MentorScreen
import be.thijsgeeraert.studdybuddy.ui.screens.Message
import be.thijsgeeraert.studdybuddy.ui.screens.RegisterScreen
import be.thijsgeeraert.studdybuddy.ui.screens.VakScreen
import be.thijsgeeraert.studdybuddy.ui.theme.GoodRed

@Composable
fun StuddyBuddyApp() {
    StuddyBuddyNavigation()
}

enum class StuddyBuddyScreen(val displayName: Int) {
    LoginScreen(displayName = R.string.login_screen),
    RegisterScreen(displayName = R.string.register_screen),
    HomeScreen(displayName = R.string.home_screen),
    BuddyScreen(displayName = R.string.buddy_screen),
    BuddyDetailScreen(displayName = R.string.buddy_detail_screen),
    VakScreen(displayName = R.string.vak_screen),
    BijlesScreen(displayName = R.string.bijles_screen),
    ChatScreen(displayName = R.string.Chat)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StuddyBuddyNavigation() {
    val navController = rememberNavController()

    //navigatie
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = StuddyBuddyScreen.valueOf(
        backStackEntry?.destination?.route ?: StuddyBuddyScreen.LoginScreen.name
    )

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold {
        MarsTopAppBar(
            currentScreen = currentScreen,
            canNavigateBack = navController.previousBackStackEntry != null,
            scrollBehavior = scrollBehavior
        )


        val padding = it
        NavHost(navController = navController, startDestination = StuddyBuddyScreen.LoginScreen.name) {
            composable(StuddyBuddyScreen.LoginScreen.name) {
                LoginScreen(onConfirmClick = { navController.navigate(StuddyBuddyScreen.HomeScreen.name)}, onRegisterClick = { navController.navigate(StuddyBuddyScreen.RegisterScreen.name)})
            }
            composable(StuddyBuddyScreen.RegisterScreen.name) {
                RegisterScreen(onRegisterClick = { navController.navigate(StuddyBuddyScreen.HomeScreen.name)})
            }
            composable(StuddyBuddyScreen.HomeScreen.name) {
                HomeScreen(onFindBuddyClick = {navController.navigate(StuddyBuddyScreen.BuddyScreen.name)}, onFindMentorClick = {navController.navigate(StuddyBuddyScreen.BijlesScreen.name)})
            }
            composable(StuddyBuddyScreen.BuddyScreen.name) {
                BuddyScreen(getUsers(), onclickDetail = { navController.navigate(StuddyBuddyScreen.BuddyDetailScreen.name)})
            }
            composable(StuddyBuddyScreen.BuddyDetailScreen.name) {
                BuddyDetailScreen()
            }
            composable(StuddyBuddyScreen.VakScreen.name) {
                VakScreen()
            }
            composable(StuddyBuddyScreen.BijlesScreen.name) {
                MentorScreen(getUsers(), onclickDetail = { navController.navigate(StuddyBuddyScreen.BuddyDetailScreen.name)}, onChatClicked = { navController.navigate(StuddyBuddyScreen.ChatScreen.name)})
            }
            composable(StuddyBuddyScreen.ChatScreen.name){
                val messages = listOf(
                    Message("Eduard Vandamme", "Problem Solving", "Heeft 5 afbeeldingen verstuurd"),
                    Message("Dieter Vancollie", "Full Stack Dev", "Kan je me helpen bij opdracht 10?"),
                    // ... Add other messages here
                )

                InboxScreen(messages)
            }
        }
    }
}

//topbar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarsTopAppBar(
    currentScreen: StuddyBuddyScreen,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = GoodRed, titleContentColor = Color.White, actionIconContentColor = Color.White, navigationIconContentColor = Color.White),
        title = {
            Text(
                text = stringResource(currentScreen.displayName),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        modifier = modifier,
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back_button)
                    )
                }
            }
        }
    )
}