package com.example.testappmaxix.ui.Screens

import androidx.lifecycle.ViewModel
import com.example.testappmaxix.data.DefaultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
data class InfoState(val name:String="", val age:String="")
@HiltViewModel
class InfoViewModel @Inject constructor( private val defaultRepository: DefaultRepository):ViewModel(){

    private val _infoStateFlow = MutableStateFlow(InfoState())
    val infoStateFlow: StateFlow<InfoState> = _infoStateFlow

    init {

        loadDataFromSharedPreferences()
    }

    private fun loadDataFromSharedPreferences() {
        val name = defaultRepository.getName()
        val age = defaultRepository.getAge()
        _infoStateFlow.value = InfoState(name, age)
    }
}