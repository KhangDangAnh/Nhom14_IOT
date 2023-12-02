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

    fun setValueLedKhach(value: Int) {
        database = FirebaseDatabase.getInstance().getReference("Led")
        database.child("LED_Khach").setValue(value)
    }

    fun setValueLedNgu1(value: Int) {
        database = FirebaseDatabase.getInstance().getReference("Led")
        database.child("LED_Ngu1").setValue(value)
    }

    fun setValueLedNgu2(value: Int) {
        database = FirebaseDatabase.getInstance().getReference("Led")
        database.child("LED_Ngu2").setValue(value)
    }

    fun setValueLedWC(value: Int) {
        database = FirebaseDatabase.getInstance().getReference("Led")
        database.child("LED_Wc").setValue(value)
    }

    fun getLED_BepValue() {
        val database = FirebaseDatabase.getInstance()
        val ledBepRef = database.getReference("LED_Bep")

        ledBepRef.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val ledBepValue = dataSnapshot.getValue(Int::class.java)
                println("LED_Bep value is $ledBepValue")
            }

            override fun onCancelled(databaseError: DatabaseError) {
                println("Failed to read value from database")
            }
        })
    }
}
data class Devices(
    val check : Boolean = false
)