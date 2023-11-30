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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChangePassword(navController: NavHostController){
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 10.dp, start = 5.dp, end = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            Arrangement.Center
        ){
            Text(text = "ĐỔI MẬT KHẨU")
        }
        Row {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Email") }
            )
        }
        Row {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Mật khẩu cũ") }
            )
        }
        Row {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Mật khẩu mới") }
            )
        }
        Row {
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp),
                value = "",
                onValueChange = {},
                placeholder = { Text(text = "Xác thực mật khẩu mới") }
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