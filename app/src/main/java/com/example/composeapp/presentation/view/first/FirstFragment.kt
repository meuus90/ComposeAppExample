package com.example.composeapp.presentation.view.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.SampleData
import com.example.composeapp.presentation.navigation.NavigationScreen
import com.example.composeapp.presentation.theme.ComposeAppTheme
import com.example.composeapp.presentation.viewmodel.puppy.SharedPuppyViewModel
import javax.inject.Inject

@Inject
internal lateinit var sharedPuppyViewModel: SharedPuppyViewModel

@Composable
fun FirstFragment(navController: NavController) {
    val puppies = remember { SampleData.puppyList }

    MaterialTheme {
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(Color.White)
        ) {
            items(
                items = puppies,
                itemContent = {
                    PuppyListItem(puppy = it) { puppy ->
//                        navController.currentBackStackEntry
//                            ?.arguments?.putParcelable("puppy", puppy)
                        sharedPuppyViewModel.share(puppy)
                        navController.navigate(NavigationScreen.SCREEN_2.name)
                    }
                }
            )
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