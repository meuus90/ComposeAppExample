package com.example.composeapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.ui.navigation.NavigationScreen
import com.example.composeapp.ui.theme.ComposeAppTheme
import com.example.composeapp.ui.view.first.FirstFragment
import com.example.composeapp.ui.view.second.SecondFragment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAppTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = NavigationScreen.SCREEN_1.name) {
                    composable(NavigationScreen.SCREEN_1.name) {
                        FirstFragment(navController)
                    }

                    composable(NavigationScreen.SCREEN_2.name) {
                        SecondFragment(navController)
                    }
                }
            }
        }
    }
}