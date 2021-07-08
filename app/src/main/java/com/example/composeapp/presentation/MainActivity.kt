package com.example.composeapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.presentation.navigation.NavigationScreen
import com.example.composeapp.presentation.theme.ComposeAppTheme
import com.example.composeapp.presentation.view.first.FirstFragment
import com.example.composeapp.presentation.view.second.SecondFragment
import com.example.composeapp.presentation.viewmodel.PuppyViewModel
import com.example.composeapp.presentation.viewmodel.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val sharedViewModel: SharedViewModel by viewModels()
            val viewModel: PuppyViewModel by viewModels()

            ComposeAppTheme {
                val navController = rememberNavController()

                NavHost(navController, startDestination = NavigationScreen.SCREEN_1.name) {
                    composable(NavigationScreen.SCREEN_1.name) {
                        FirstFragment(navController, sharedViewModel, viewModel)
                    }

                    composable(NavigationScreen.SCREEN_2.name) {
                        SecondFragment(navController, sharedViewModel, viewModel)
                    }
                }
            }
        }
    }
}