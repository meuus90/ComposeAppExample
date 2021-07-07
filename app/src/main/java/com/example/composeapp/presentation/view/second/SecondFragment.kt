package com.example.composeapp.presentation.view.second

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeapp.SampleData
import com.example.composeapp.datasource.model.Puppy
import com.example.composeapp.presentation.theme.ComposeAppTheme
import com.example.composeapp.presentation.viewmodel.puppy.SharedPuppyViewModel
import javax.inject.Inject

@Inject
internal lateinit var sharedPuppyViewModel: SharedPuppyViewModel

@Composable
fun SecondFragment(navController: NavController) {
    val puppy = remember { mutableStateOf<Puppy?>(null) }
    sharedPuppyViewModel.shared {
        puppy.value = it
    }
    puppy.value?.let {
        SecondView(navController, it)
    }

//    val puppy = navController.previousBackStackEntry
//        ?.arguments?.getParcelable<Puppy>("puppy")
//
//    puppy?.let { SecondView(navController, it) }
}

@Composable
private fun SecondView(navController: NavController, puppy: Puppy) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PuppyImage(puppy)
        Text(
            text = puppy.title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
        )
        Text(
            text = puppy.description, style = MaterialTheme.typography.body1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 4.dp)
        )
        Spacer(modifier = Modifier.weight(1F))
        Button(
            onClick = {
//                navController.navigate(NavigationScreen.SCREEN_1.name)
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text(text = "Exit")
        }
    }
}

@Composable
private fun PuppyImage(puppy: Puppy) {
    Image(
        painter = painterResource(id = puppy.puppyImageId),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeAppTheme {
        val navController = rememberNavController()
        SecondView(navController, SampleData.puppyList[0])
    }
}