package com.example.iot_application.Profile

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class AccountViewModel {
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
}

data class User(
    var image: String = "",
    var hoTen: String = "",
    var ngaySinh: String = "",
    var gioiTinh: String = "",
    var sdt: String = "",
    var email: String = ""
)
