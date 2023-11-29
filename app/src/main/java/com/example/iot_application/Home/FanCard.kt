package com.example.iot_application.Home

import android.graphics.drawable.Icon
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.iot_application.R

@Composable
fun FanCard(RoomName: String) {
    var checked by remember { mutableStateOf(false) }
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Card(modifier = Modifier.height(130.dp)) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        )
        {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(painter = painterResource(id = R.drawable.baseline_weekend_24), contentDescription = "")
                Text(RoomName, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    },
                    thumbContent = {
                        if (checked) {
                            Icon(
                                painter = painterResource(id = R.drawable.sharp_wind_power_24),
                                contentDescription = "",
                                tint = Color.Cyan
                            )
                        } else
                        {
                            Icon(
                                painter = painterResource(id = R.drawable.sharp_wind_power_24),
                                contentDescription = "",
                                tint = Color.Gray
                            )
                        }
                    }
                )
            }
        }
    }
}