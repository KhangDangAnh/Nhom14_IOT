package com.example.iot_application.Profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.firestore

class AccountViewModel : ViewModel(){
    var state by mutableStateOf(User())
        private set


    fun onChangeHoTen(newHoTen: String) {
        state = state.copy(hoTen = newHoTen)
    }
    fun onChangeNgaySinh(newNgaySinh: String) {
        state = state.copy(ngaySinh = newNgaySinh)
    }
    fun onChangeGioiTinh(newGioiTinh: String) {
        state = state.copy(gioiTinh = newGioiTinh)
    }
    fun onChangeSDT(newSDT: String) {
        state = state.copy(sdt = newSDT)
    }
    fun onChangeEmail(newEmail: String) {
        state = state.copy(email = newEmail)
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
    var image: String = "",
    var hoTen: String = "",
    var ngaySinh: String = "",
    var gioiTinh: String = "",
    var sdt: String = "",
    var email: String = "",
    var password:String="",
    var success:Boolean= false
)
