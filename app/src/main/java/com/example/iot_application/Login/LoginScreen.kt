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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.iot_application.Screens
import com.example.iot_application.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavHostController,
) {
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
                        // Thay đổi BackGround (Nếu cần)
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
                            text = "Đăng Nhập",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
                            color = Color.Black,
                            fontSize = 25.sp
                        )
                    }

                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
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
                        value = "",
                        onValueChange = {},
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
                            navController.navigate(Screens.Home.route)
                            }) {
                            Text("Đăng Nhập")
                        }

                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        TextButton(
                            onClick = {

                                //Screen Quên mật khẩu

                            }) {
                            Text(
                                "Quên mật khẩu ?",
                                color = Color.Blue,
                                textDecoration = TextDecoration.Underline
                            )
                        }
                    }
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

                                //Screen Đăng kí

                            }
                        ) {
                            Text("Đăng kí")
                        }
                    }
                }
            }
        }
    }
}
