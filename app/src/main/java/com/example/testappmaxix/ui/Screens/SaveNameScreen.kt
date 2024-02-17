package com.example.testappmaxix.ui.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun saveName(
    viewModel: SaveNameViewModel = hiltViewModel<SaveNameViewModel>(),
    modifier: Modifier = Modifier,
    onNext: () -> Unit
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        val UiState = viewModel.nameStateFlow.collectAsState()
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = UiState.value.name,
                onValueChange = { viewModel.updateNameState(it) },
                label = { Text(text = "Name") }, singleLine = true
            )

            Button(
                enabled = UiState.value.name.isNotEmpty(),
                onClick = {
                    viewModel.SaveName()
                    onNext()
                },
                modifier = modifier.padding(10.dp),
                shape = CircleShape,

                ) {
                Text(text = "Save Name")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun prew() {
    saveName {}
}