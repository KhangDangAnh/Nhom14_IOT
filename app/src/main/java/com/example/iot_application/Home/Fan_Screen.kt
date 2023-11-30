package com.example.iot_application.Home


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Fan_Screen()
{
    Column (Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceAround) {
        Text(text = "Electric Fans", fontSize = 30.sp, fontWeight = FontWeight.ExtraBold)
        LazyColumn(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            item {
                FanCard(RoomName = "Living Room")
            }
            item {
                FanCard(RoomName = "Bed Room 1")
            }
            item {
                FanCard(RoomName = "Bed Room 2")
            }
        }
    }
}