package com.example.composeapp.presentation.view.first

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.composeapp.SampleData
import com.example.composeapp.datasource.model.Params
import com.example.composeapp.datasource.model.Puppy
import com.example.composeapp.presentation.navigation.NavigationScreen
import com.example.composeapp.presentation.theme.ComposeAppTheme
import com.example.composeapp.presentation.viewmodel.PuppyViewModel
import com.example.composeapp.presentation.viewmodel.SharedViewModel


@Composable
fun FirstFragment(
    navController: NavController,
    sharedViewModel: SharedViewModel,
    viewModel: PuppyViewModel = viewModel(PuppyViewModel::class.java)
) {
    val puppyList = remember { mutableStateOf(listOf<Puppy>()) }

    viewModel.getPuppies(Params()) { l ->
        puppyList.value = l
    }

    FirstView(puppyList.value) { puppy ->
        sharedViewModel.share(puppy.id)
        navController.navigate(NavigationScreen.SCREEN_2.name)
    }
}


@Composable
private fun FirstView(
    puppies: List<Puppy>,
    onItemClicked: (puppy: Puppy) -> Unit
) {
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
                        onItemClicked(puppy)
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
        val puppies = remember { SampleData.puppyList }
        FirstView(puppies) {}
    }
}