package com.example.iot_application.Room

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class RoomViewModel:ViewModel() {
    private lateinit var database: DatabaseReference
    fun setValueLed(value: Int,led:String) {
        database = FirebaseDatabase.getInstance().getReference("Led")
        database.child(led).setValue(value)
    }
    fun setValueTemp(value: Int) {
        database = FirebaseDatabase.getInstance().getReference("Temp")
        database.child("temp").setValue(value)
    }
}
