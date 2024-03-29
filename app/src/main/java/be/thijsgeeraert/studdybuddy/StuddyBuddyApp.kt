package be.thijsgeeraert.studdybuddy

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import be.thijsgeeraert.studdybuddy.data.MockUp.getMessages
import be.thijsgeeraert.studdybuddy.data.MockUp.getUsers
import be.thijsgeeraert.studdybuddy.ui.screens.BuddyDetailScreen
import be.thijsgeeraert.studdybuddy.ui.screens.BuddyScreen
import be.thijsgeeraert.studdybuddy.ui.screens.HomeScreen
import be.thijsgeeraert.studdybuddy.ui.screens.InboxScreen
import be.thijsgeeraert.studdybuddy.ui.screens.LoginScreen
import be.thijsgeeraert.studdybuddy.ui.screens.MentorScreen
import be.thijsgeeraert.studdybuddy.ui.screens.RegisterScreen
import be.thijsgeeraert.studdybuddy.ui.screens.VakkenScreen
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
    InboxScreen(displayName = R.string.Chat)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StuddyBuddyNavigation() {
    val navController = rememberNavController()

    //navigatie
    val backStackEntry by navController.currentBackStackEntryAsState()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = navBackStackEntry?.destination?.route ?: StuddyBuddyScreen.LoginScreen.name
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MarsTopAppBar(
                currentScreenTitle = stringResource(id = StuddyBuddyScreen.valueOf(currentScreen.replace("/{id_key}", "")).displayName),
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.popBackStack() },
                scrollBehavior = scrollBehavior
            )
        },
        bottomBar = {
            StuddyBuddyBottomBar(currentScreen = currentScreen, onItemClick = { navController.navigate(it)})
        }
    ) {
        val padding = it
        NavHost(navController = navController, startDestination = StuddyBuddyScreen.LoginScreen.name) {
            composable(StuddyBuddyScreen.LoginScreen.name) {
                LoginScreen(onConfirmClick = { navController.navigate(StuddyBuddyScreen.HomeScreen.name)}, onRegisterClick = { navController.navigate(StuddyBuddyScreen.RegisterScreen.name)})
            }
            composable(StuddyBuddyScreen.RegisterScreen.name) {
                RegisterScreen(onRegisterClick = { navController.navigate(StuddyBuddyScreen.HomeScreen.name)} )
            }
            composable(StuddyBuddyScreen.HomeScreen.name) {
                HomeScreen(onFindBuddyClick = {navController.navigate(StuddyBuddyScreen.BuddyScreen.name)}, onFindMentorClick = {navController.navigate(StuddyBuddyScreen.BijlesScreen.name)})
            }
            composable(StuddyBuddyScreen.BuddyScreen.name) {
                BuddyScreen(getUsers(), onclickDetail = { navController.navigate(StuddyBuddyScreen.BuddyDetailScreen.name + "/$it")}, onFilterClicked = { navController.navigate(StuddyBuddyScreen.VakScreen.name)} ,onChatClicked = {navController.navigate(StuddyBuddyScreen.InboxScreen.name)})
            }
            composable(
                route = StuddyBuddyScreen.BuddyDetailScreen.name + "/{id_key}",
                arguments = listOf(navArgument("id_key") { type = NavType.IntType })
            ) {
                val userId = navBackStackEntry?.arguments?.getInt("id_key")
                BuddyDetailScreen(userId ?: 0)
            }
            composable(StuddyBuddyScreen.VakScreen.name) {
                VakkenScreen(onGoNext = { navController.navigate(StuddyBuddyScreen.BuddyScreen.name)})
            }
            composable(StuddyBuddyScreen.BijlesScreen.name) {
                MentorScreen(getUsers().filter { u -> u.isMentorVoor.isNotEmpty() }, onclickDetail = { navController.navigate(StuddyBuddyScreen.BuddyDetailScreen.name + "/$it")}, onFilterClicked = { navController.navigate(StuddyBuddyScreen.VakScreen.name)} ,onChatClicked = {navController.navigate(StuddyBuddyScreen.InboxScreen.name)})
            }
            composable(StuddyBuddyScreen.InboxScreen.name) {
                InboxScreen(getMessages())
            }
        }
    }
}

//topbar
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarsTopAppBar(
    currentScreenTitle: String,
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
                text = currentScreenTitle,
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

@Composable
fun StuddyBuddyBottomBar(
    currentScreen: String,
    onItemClick: (route: String) -> Unit,
    modifier: Modifier = Modifier
) {
    AnimatedVisibility(visible = currentScreen != StuddyBuddyScreen.LoginScreen.name) {
        NavigationBar {
            val homeTitle = StuddyBuddyScreen.HomeScreen.name
            NavigationBarItem(
                selected = homeTitle == currentScreen,
                onClick = {
                    if (currentScreen != StuddyBuddyScreen.HomeScreen.name) {
                        onItemClick(StuddyBuddyScreen.HomeScreen.name)
                    }
                          },
                icon = {
                    if (homeTitle == currentScreen) {
                        Icon(
                            imageVector = Icons.Filled.Home,
                            contentDescription = homeTitle
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Outlined.Home,
                            contentDescription = homeTitle
                        )
                    }
                }
            )
            val inboxTitle = StuddyBuddyScreen.InboxScreen.name
            NavigationBarItem(
                selected = inboxTitle == currentScreen,
                onClick = {
                    if (currentScreen != StuddyBuddyScreen.InboxScreen.name) {
                        onItemClick(StuddyBuddyScreen.InboxScreen.name)
                    }
                          },
                icon = {
                    if (inboxTitle == StuddyBuddyScreen.InboxScreen.name) {
                        Icon(
                            imageVector = Icons.Filled.Email,
                            contentDescription = inboxTitle
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Outlined.MailOutline,
                            contentDescription = inboxTitle
                        )
                    }
                }
            )
        }
    }
}