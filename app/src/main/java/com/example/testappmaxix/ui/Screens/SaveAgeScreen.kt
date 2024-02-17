package com.example.testappmaxix.ui.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun saveAge(
    viewModel: SaveAgeViewModel = hiltViewModel<SaveAgeViewModel>(),
    modifier: Modifier = Modifier,
    onNext: () -> Unit
) {
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        val UiState = viewModel.ageStateFlow.collectAsState()
        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = UiState.value.age,
                onValueChange = { viewModel.updateNameState(it) },
                label = { Text(text = "Age") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true
            )

            Button(
                enabled = UiState.value.age.isNotEmpty(),
                onClick = {
                    viewModel.SaveAge()
                    onNext()
                },
                modifier = modifier.padding(10.dp),
                shape = CircleShape,


            ) {
                Text(text = "Save Age")
            }
        }

    }
}
