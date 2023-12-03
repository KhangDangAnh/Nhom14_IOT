package com.example.iot_application.Home

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.annotations.Nullable

class RealTimeViewModel : ViewModel() {
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