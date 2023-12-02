package com.example.iot_application.Profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.EmailAuthCredential
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth

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
    fun onChangePassword(newvalue: String){
        state = state.copy(password = newvalue)
    }
}
fun ChangePassword(currentPassword: String, newPassword: String, confirmPassword: String){
    if(newPassword != confirmPassword){

    }

    val user = FirebaseAuth.getInstance().currentUser
    val credential = EmailAuthProvider.getCredential(user?.email!!, currentPassword)

    user.reauthenticate(credential)
        .addOnCompleteListener { authTask ->
            if(authTask.isSuccessful){
                user.updatePassword(newPassword)
                    .addOnCompleteListener { updateTask ->
                        if(updateTask.isSuccessful){
                            //thong bao thanh cong
                        } else{
                            //that bai
                        }
                    }
            } else{
                //Thoong bao loi xac thuc
            }
        }
}
data class User(
    val hoTen: String = "",
    val ngaySinh: String = "",
    val gioiTinh: String = "",
    val sdt: String = "",
    val email: String = "",
    var password: String = "",
    val success: Boolean = false,
)
