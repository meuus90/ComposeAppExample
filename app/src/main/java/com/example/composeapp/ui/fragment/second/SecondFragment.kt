package com.example.composeapp.ui.fragment.second

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.ui.navigation.NavigationScreen
import com.example.composeapp.ui.theme.ComposeAppTheme

@Composable
fun SecondFragment(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.LightGray)
    ) {
        Text(text = "Hello world.")
        Button(onClick = {
            navController.navigate(NavigationScreen.SCREEN_1.name)
        }) {
            Text(text = "Continue")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAppTheme {
        val navController = rememberNavController()
        SecondFragment(navController)
    }
}