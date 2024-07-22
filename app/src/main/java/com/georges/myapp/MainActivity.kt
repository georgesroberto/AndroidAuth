package com.georges.myapp


import android.os.Bundle
import androidx.activity.ComponentActivity
import com.georges.myapp.ui.theme.MyAppTheme
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.navigation.compose.*
import androidx.navigation.compose.NavHost
import com.georges.myapp.data.UserDatabase
import com.georges.myapp.data.UserRepository
import com.georges.myapp.ui.components.UserViewModel
import com.georges.myapp.ui.screens.HomeScreen
import com.georges.myapp.ui.screens.LoginScreen
import com.georges.myapp.ui.screens.RegisterScreen
import com.georges.myapp.ui.screens.SplashScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppTheme  {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    val database = UserDatabase.getDatabase(applicationContext)
                    val userRepository = UserRepository(database.userDao())
                    val userViewModel = UserViewModel(userRepository)

                    NavHost(navController = navController, startDestination = "login") {
                        composable("splash") { SplashScreen(navController) }
                        composable("register") { RegisterScreen(navController, userViewModel) }
                        composable("login") { LoginScreen(navController, userViewModel) }
                        composable("home/{username}") { backStackEntry ->
                            val username = backStackEntry.arguments?.getString("username") ?: ""
                            HomeScreen(navController, username, userViewModel)
                        }
                    }
                }
            }
        }
    }
}
