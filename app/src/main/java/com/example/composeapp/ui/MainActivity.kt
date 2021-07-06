package com.example.composeapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.ui.fragment.first.FirstFragment
import com.example.composeapp.ui.fragment.second.SecondFragment
import com.example.composeapp.ui.navigation.NavigationScreen
import com.example.composeapp.ui.theme.ComposeAppTheme

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