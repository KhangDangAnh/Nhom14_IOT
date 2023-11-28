package com.example.iot_application.Profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material.icons.rounded.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun screenFrofile(name: String) {
    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 10.dp, start = 5.dp, end = 5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Tên",
                        textAlign = TextAlign.Start
                    )
                    Row {
                        Text(
                            text = name,
                            textAlign = TextAlign.Start
                        )
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                }
            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Ngày sinh",
                        textAlign = TextAlign.Start
                    )
                    Row {
                        Text(
                            text = name,
                            textAlign = TextAlign.Start
                        )
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                }

            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Giới tính",
                        textAlign = TextAlign.Start
                    )
                    Row {
                        Text(
                            text = name,
                            textAlign = TextAlign.Start
                        )
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                }

            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Số điện thoại",
                        textAlign = TextAlign.Start
                    )
                    Row {
                        Text(
                            text = name,
                            textAlign = TextAlign.Start
                        )
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                }

            }
        }
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
        ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(5.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Email",
                        textAlign = TextAlign.Start
                    )
                    Row {
                        Text(
                            text = name,
                            textAlign = TextAlign.Start
                        )
                        Icon(
                            imageVector = Icons.Rounded.KeyboardArrowRight,
                            contentDescription = null
                        )
                    }
                }

            }
        }
        Row (
            Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Button(
                onClick = {},
            ) {
                Text(text = "Đăng xuất")
            }
            Button(
                onClick = {},
            ) {
                Text(text = "Đổi mật khẩu")
            }
        }
    }
}