package com.example.iot_application.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.iot_application.R
import com.example.iot_application.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomList(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    )
    {
        item {
            RoomCard(room_name = "Living Room", icon = R.drawable.baseline_weekend_24,{navController.navigate(Screens.LivingRoom.route)})
        }
        item {
            RoomCard(room_name = "Bed Room 1", icon = R.drawable.baseline_bed_24,{navController.navigate(Screens.BedRoom1.route)})
        }
        item {
            RoomCard(room_name = "Bed Room 2", icon = R.drawable.baseline_bed_24,{navController.navigate(Screens.BedRoom2.route)})
        }
        item {
            RoomCard(room_name = "Kitchen", icon = R.drawable.baseline_kitchen_24,{navController.navigate(Screens.KitchenRoom.route)})
        }
        item {
            RoomCard(room_name = "Bath Room", icon = R.drawable.baseline_bathtub_24,{navController.navigate(Screens.Toilet.route)})
        }
        item {
            androidx.compose.material3.Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp),
                border = BorderStroke(1.dp, Color.LightGray),
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    OutlinedTextField(
                        value = "",
                        onValueChange = {},
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_lock_open_24),
                                contentDescription = ""
                            )
                        },
                        label = { Text(text = "Door Password", fontWeight = FontWeight.Bold) }
                    )
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_key_24),
                            contentDescription = ""
                        )
                    }
                }
            }
        }
    }
}