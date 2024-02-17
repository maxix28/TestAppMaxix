package com.example.testappmaxix.ui.Screens

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.testappmaxix.data.DefaultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
data class NameState(var name:String="")
@HiltViewModel
class SaveNameViewModel  @Inject constructor(private val defaultRepository: DefaultRepository):ViewModel() {

    private val _nameStateFlow = MutableStateFlow(NameState())


    val nameStateFlow: StateFlow<NameState> = _nameStateFlow

    fun updateNameState(name: String) {
        _nameStateFlow.value = NameState(name)

    }

    fun SaveName()= defaultRepository.saveName(nameStateFlow.value.name)
}