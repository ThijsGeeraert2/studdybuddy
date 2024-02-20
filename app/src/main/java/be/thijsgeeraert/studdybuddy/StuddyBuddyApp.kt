package be.thijsgeeraert.studdybuddy

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import be.thijsgeeraert.studdybuddy.ui.screens.BijlesScreen
import be.thijsgeeraert.studdybuddy.ui.screens.BuddyDetailScreen
import be.thijsgeeraert.studdybuddy.ui.screens.BuddyScreen
import be.thijsgeeraert.studdybuddy.ui.screens.HomeScreen
import be.thijsgeeraert.studdybuddy.ui.screens.LoginScreen
import be.thijsgeeraert.studdybuddy.ui.screens.RegisterScreen
import be.thijsgeeraert.studdybuddy.ui.screens.VakScreen

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
    BijlesScreen(displayName = R.string.bijles_screen)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StuddyBuddyNavigation() {
    val navController = rememberNavController()
    Scaffold {
        val padding = it
        NavHost(navController = navController, startDestination = StuddyBuddyScreen.LoginScreen.name) {
            composable(StuddyBuddyScreen.LoginScreen.name) {
                LoginScreen()
            }
            composable(StuddyBuddyScreen.RegisterScreen.name) {
                RegisterScreen()
            }
            composable(StuddyBuddyScreen.HomeScreen.name) {
                HomeScreen()
            }
            composable(StuddyBuddyScreen.BuddyScreen.name) {
                BuddyScreen()
            }
            composable(StuddyBuddyScreen.BuddyDetailScreen.name) {
                BuddyDetailScreen()
            }
            composable(StuddyBuddyScreen.VakScreen.name) {
                VakScreen()
            }
            composable(StuddyBuddyScreen.BijlesScreen.name) {
                BijlesScreen()
            }
        }
    }
}