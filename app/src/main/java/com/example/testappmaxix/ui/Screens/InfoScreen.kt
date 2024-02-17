package com.example.testappmaxix.ui.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun InfoScreen(
    viewModel: InfoViewModel = hiltViewModel<InfoViewModel>(),
    modifier: Modifier = Modifier
) {
    val UiState = viewModel.infoStateFlow.collectAsState()


    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        val UiState = viewModel.infoStateFlow.collectAsState()
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(model = "https://avatars.githubusercontent.com/u/123401537?v=4",
                contentDescription = "My photo", modifier = modifier.padding(10.dp).clip(shape = CircleShape))

            Row(modifier = modifier.padding(10.dp), verticalAlignment = Alignment.Bottom) {
                androidx.compose.material.Text(text = "Name : " , color = Color.LightGray, fontSize = 15.sp)
                Text (text = UiState.value.name, fontSize = 20.sp)
            }
            Row (modifier = modifier.padding(10.dp), verticalAlignment = Alignment.Bottom){
                androidx.compose.material.Text(text = "Age : " , color = Color.LightGray, fontSize = 15.sp)
                Text (text = UiState.value.age, fontSize = 20.sp)
            }



        }
    }
}