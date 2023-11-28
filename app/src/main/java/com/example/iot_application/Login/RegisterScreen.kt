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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.sharp.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iot_application.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    // navController: NavController,

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
                            text = "Đăng kí tài khoản",
                            textAlign = TextAlign.Center,
                            fontWeight = FontWeight.ExtraBold,
                            modifier = Modifier.fillMaxWidth(),
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
                            Image(imageVector = Icons.Rounded.Email, contentDescription = null)
                        }
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(text = "Phone", textAlign = TextAlign.Center)
                        },
                        shape = CircleShape,
                        leadingIcon = {
                            Image(imageVector = Icons.Rounded.Phone, contentDescription = null)
                        }
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(text = "FullName", textAlign = TextAlign.Center)
                        },
                        shape = CircleShape,
                        leadingIcon = {
                            Image(imageVector = Icons.Rounded.Person, contentDescription = null)
                        }
                    )
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        label = {
                            Text(text = "Password", textAlign = TextAlign.Center)
                        },
                        shape = CircleShape,
                        leadingIcon = {
                            Image(imageVector = Icons.Sharp.Done, contentDescription = null)
                        }
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Button(
                        shape = RoundedCornerShape(25),
                        modifier = Modifier.size(width = 150.dp, height = 40.dp),

                        onClick = {

                        }) {
                        Text("Đăng kí")
                    }
                }
            }
        }
    }
}
