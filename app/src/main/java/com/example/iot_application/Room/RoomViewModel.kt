package com.example.iot_application.Room

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class RoomViewModel:ViewModel() {
    var state by mutableStateOf(RoomState())
        private set

    fun onChangeValueDen(newvalue:Boolean){
        state = state.copy(giatriden = newvalue)
    }
    fun onChangeValueQuat(newvalue:Boolean){
        state = state.copy(giatriquat = newvalue)
    }
    fun onChangeValueDenSlider(newvalue:Float){
        state = state.copy(giatridenSlider = newvalue)
    }
}
data class RoomState(
    val giatriden:Boolean = false,
    val giatriquat: Boolean = false,
    val giatridenSlider: Float = 0f,
)