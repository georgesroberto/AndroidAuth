package com.georges.myapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.georges.myapp.ui.components.UserViewModel

@Composable
fun HomeScreen(
    navController: NavController,
    username: String,
    userViewModel: UserViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Hello, $username")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            userViewModel.logoutUser()
            navController.navigate("login") {
                popUpTo("login") { inclusive = true }
            }
        }) {
            Text("Logout")
        }
    }
}
