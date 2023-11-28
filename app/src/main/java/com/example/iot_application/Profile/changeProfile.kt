package com.example.iot_application.Profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun changeProfile(){
    var change_hoTen by remember { mutableStateOf(" ") }
    var change_ngaySinh by remember {mutableStateOf(" ")}
    var change_gioiTinh by remember {mutableStateOf(" ")}
    var change_sdt by remember {mutableStateOf(" ")}
    var change_email by remember {mutableStateOf(" ")}
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 10.dp, start = 5.dp, end = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Họ và tên")}
            )
        }
        Row {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Ngày sinh")}
                )
        }
        Row {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Giới tính")}
                )
        }
        Row {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Số điện thoại")}
            )
        }
        Row {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Email")}
            )
        }
        Row {
            Button(
                onClick = { /*Lưu tất cả thông tin đã thay đổi trong TextField*/}
            ) {
                Text(text = "Lưu")
            }
        }
    }
}