package com.example.iot_application.Profile

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.EmailAuthCredential
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class AccountViewModel : ViewModel() {
    var state by mutableStateOf(AccountState())
        private set

    fun onChangeHoTen(newHoten: String) {
        state = state.copy(hoTen = newHoten)
    }

    fun onChangeSDT(newSDT: String) {
        state = state.copy(sdt = newSDT)
    }

    fun onChangeEmail(newEmail: String) {
        state = state.copy(email = newEmail)
    }

    fun onChangePassword(newPassword: String) {
        state = state.copy(password = newPassword)
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

data class AccountState(
    var hoTen: String = "",
    var sdt: String = "",
    var email: String = "",
    var password: String = "",
    var success: Boolean = false,
)
