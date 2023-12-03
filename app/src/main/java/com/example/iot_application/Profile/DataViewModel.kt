package com.example.iot_application.Profile

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class DataViewModel(): ViewModel(){
    val state = mutableStateOf(User())

    init{
        getData()
    }
    private fun getData(){
        viewModelScope.launch {
            state.value = getDataFromFireStore()
        }
    }
}
suspend fun getDataFromFireStore():User{
    val db = FirebaseFirestore.getInstance()
    var user = User()

    try{
        db.collection("users").get().await().map {
            val result = it.toObject(User::class.java)
            user = result
        }
    }catch (e: FirebaseFirestoreException){
        Log.d("Lỗi", "getDataFromStore: $e")
    }
    return user
}