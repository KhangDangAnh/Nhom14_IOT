package com.example.iot_application.Profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
=======
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

class AccountViewModel : ViewModel(){
    var state by mutableStateOf(User())
        private set
    fun onChangeHoTen(newvalue: String) {
        state = state.copy(hoTen = newvalue)
    }
    fun onChangeNgaySinh(newvalue: String) {
        state = state.copy(ngaySinh = newvalue)
    }
    fun onChangeGioiTinh(newvalue: String) {
        state = state.copy(gioiTinh = newvalue)
    }
    fun onChangeSDT(newvalue: String) {
        state = state.copy(sdt = newvalue)
    }
    fun onChangeEmail(newvalue: String) {
        state = state.copy(email = newvalue)
    }
    fun onChangePasword(newPassword: String) {
        state = state.copy(email = newPassword)
    }
    fun addUser() {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(state.email, state.password)
            .addOnCompleteListener {
                if (!it.isSuccessful) {
                    state = state.copy(success = false)
                } else {
                    val user = User(
                        state.hoTen,
                        state.sdt,
                        state.email,
                        state.password
                    )
                    Firebase.firestore.collection("users").add(user)
                    state = state.copy(success = true)
                }
            }
    }

    fun SignIn() {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(state.email, state.password)
            .addOnCompleteListener {
                state = state.copy(success = it.isSuccessful)
            }
    }
}

data class User(
    val hoTen: String = "",
    val ngaySinh: String = "",
    val gioiTinh: String = "",
    val sdt: String = "",
    val email: String = "",
    val success: Boolean = false,
=======
    var image: String = "",
    var hoTen: String = "",
    var ngaySinh: String = "",
    var gioiTinh: String = "",
    var sdt: String = "",
    var email: String = "",
    var password:String="",
    var success:Boolean= false
)
