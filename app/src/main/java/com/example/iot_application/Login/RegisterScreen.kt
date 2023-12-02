package com.example.iot_application.Login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.sharp.Done
import androidx.compose.material.icons.sharp.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.iot_application.Profile.AccountViewModel
import com.example.iot_application.R
import com.example.iot_application.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    navController: NavController,

    ) {
    var viewModel : AccountViewModel = viewModel(
        modelClass = AccountViewModel::class.java
    )
    var state = viewModel.state
    var openDialog by remember { mutableStateOf(false) }
    Scaffold(
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .background(color = Color.White)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        //Thay Background
                        painterResource(id = R.drawable.background),
                        contentScale = ContentScale.FillBounds
                    )
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {

                    Row(
                        Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Đăng kí tài khoản",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            fontSize = 25.sp
                        )
                    }
                    OutlinedTextField(
                        value = state.hoTen,
                        onValueChange = viewModel::onChangeHoTen,
                        label = {
                            Text(text = "FullName", textAlign = TextAlign.Center)
                        },
                        shape = CircleShape,
                        leadingIcon = {
                            Icon(imageVector = Icons.Rounded.Person, contentDescription = null)
                        }
                    )

                    OutlinedTextField(
                        value = state.sdt,
                        onValueChange = viewModel::onChangeSDT,
                        label = {
                            Text(text = "Phone", textAlign = TextAlign.Center)
                        },
                        shape = CircleShape,
                        leadingIcon = {
                            Image(imageVector = Icons.Rounded.Phone, contentDescription = null)
                        }
                    )
                    OutlinedTextField(
                        value = state.email,
                        onValueChange = viewModel::onChangeEmail,
                        label = {
                            Text(text = "Email", textAlign = TextAlign.Center)
                        },
                        shape = CircleShape,
                        leadingIcon = {
                            Icon(imageVector = Icons.Rounded.Email, contentDescription = null)
                        }
                    )
                    OutlinedTextField(
                        value = state.password,
                        onValueChange = viewModel::onChangePassword,
                        keyboardOptions =   KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        label = {
                            Text(text = "Password", textAlign = TextAlign.Center)
                        },
                        shape = CircleShape,
                        leadingIcon = {
                            Icon(imageVector = Icons.Sharp.Lock, contentDescription = null)
                        }
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Button(
                        shape = RoundedCornerShape(25),
                        modifier = Modifier.size(width = 150.dp, height = 40.dp),
                        onClick = {
                            if(state.email.isNullOrEmpty() || state.password.isNullOrEmpty() || state.sdt.isNullOrEmpty() || state.hoTen.isNullOrEmpty())
                            {
                                openDialog = true
                            }
                            else {
                                viewModel.addUser()
                                if (state.success) {
                                    navController.navigate(Screens.Login.route) {
                                        launchSingleTop = true
                                    }
                                }
                            }
                        }) {
                        Text("Đăng kí")
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ){
                        TextButton(
                            onClick = {
                                navController.navigate(Screens.Login.route)
                            }) {
                            Text("Quay lại đăng nhập", color = Color.Blue)
                        }
                    }
                }
            }
        }
    }
    if (openDialog) {
        DialogSample(
            onDiss = {
                openDialog = false
            },
            onConfirm = {
                openDialog = false
            },
            title = "Yêu cầu nhập đầy đủ",
        )
    }
}
