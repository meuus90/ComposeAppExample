package com.example.composeapp.ui.fragment.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.ui.navigation.NavigationScreen
import com.example.composeapp.ui.theme.ComposeAppTheme

@Composable
fun FirstFragment(navController: NavController) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.LightGray)
                .padding(16.dp)
        ) {
            Text(text = "Hello world.")
            Button(onClick = {
                navController.navigate(NavigationScreen.SCREEN_2.name)
            }) {
                Text(text = "Continue")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAppTheme {
        val navController = rememberNavController()
        FirstFragment(navController)
    }
}