package com.example.testappmaxix.ui.Screens

import androidx.lifecycle.ViewModel
import com.example.testappmaxix.data.DefaultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class AgeState(var age:String="")
@HiltViewModel
class SaveAgeViewModel  @Inject constructor(private val defaultRepository: DefaultRepository):
    ViewModel() {

    private val _ageStateFlow = MutableStateFlow(AgeState())


    val ageStateFlow: StateFlow<AgeState> = _ageStateFlow

    fun updateNameState(age: String) {
        _ageStateFlow.value = AgeState(age)

    }

    fun SaveAge()= defaultRepository.saveAge(ageStateFlow.value.age)
}