package com.example.iot_application.Login

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
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
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
import androidx.navigation.NavHostController
import com.example.iot_application.Profile.AccountViewModel
import com.example.iot_application.Screens
import com.example.iot_application.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavHostController,
) {
    var viewModel: AccountViewModel = viewModel(
        modelClass = AccountViewModel::class.java
    )
    var state = viewModel.state
    var openDialog by remember { mutableStateOf(false) }
    Scaffold {
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
                        // Thay Background
                        painterResource(id = R.drawable.background),
                        contentScale = ContentScale.FillBounds,

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
                            text = "Đăng Nhập",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.Black,
                            fontSize = 25.sp
                        )
                    }

                    OutlinedTextField(
                        value = state.email,
                        onValueChange = viewModel::onChangeEmail,
                        label = {
                            Text(text = "Email", textAlign = TextAlign.Center)
                        },
                        shape = CircleShape,
                        leadingIcon = {
                            Icon(imageVector = Icons.Rounded.Person, contentDescription = null)
                        }
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    OutlinedTextField(
                        value = state.password,

                        onValueChange = viewModel::onChangePassword,
=======
                        onValueChange = viewModel::onChangePasword,

                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Password
                        ),
                        visualTransformation = PasswordVisualTransformation(),
                        label = {
                            Text(text = "Password", textAlign = TextAlign.Center)
                        },
                        shape = CircleShape,
                        leadingIcon = {
                            Icon(imageVector = Icons.Rounded.Lock, contentDescription = null)

                        }
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Button(
                            shape = RoundedCornerShape(25),
                            modifier = Modifier.size(width = 150.dp, height = 40.dp),
                            onClick = {
                                if (state.email.isNullOrEmpty() || state.password.isNullOrEmpty()) {
                                    openDialog = true
                                } else {
                                    viewModel.SignIn()
                                    if (state.success) {
                                        navController.navigate(Screens.Home.route)
                                    }
                                }
                            }) {
                            Text("Đăng Nhập")
                        }
                    }
                    Spacer(modifier = Modifier.padding(5.dp))
                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier.padding(horizontal = 60.dp),
                        thickness = 2.dp
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround

                    ) {
                        Button(
                            shape = RoundedCornerShape(25),
                            modifier = Modifier.size(width = 150.dp, height = 40.dp),
                            onClick = {
                                navController.navigate(Screens.Register.route)
                            }) {
                            Text("Đăng kí")
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


=======
}

@Composable
fun DialogSample(
    title: String = "",
    content: String = "",
    onDiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDiss,
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "Xác Nhận")
            }
        },
        title = { Text(text = title) },
        text = { Text(text = content) }
    )
}

@Composable
fun DialogSample(
    title: String = "",
    content: String = "",
    onDiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDiss,
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = "Xác Nhận")
            }
        },
        title = { Text(text = title) },
        text = { Text(text = content) }
    )
}