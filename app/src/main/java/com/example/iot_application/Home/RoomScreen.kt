package com.example.iot_application.Home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
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
        item{
            Image(painter = painterResource(id = R.drawable.weather),
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier.aspectRatio(16f / 9f)
            )
        }
        item {
            RoomCard(room_name = "Phòng Khách", icon = R.drawable.baseline_weekend_24,{navController.navigate(Screens.RoomKhach.route)})
        }
        item {
            RoomCard(room_name = "Phòng Ngủ", icon = R.drawable.baseline_bed_24,{navController.navigate(Screens.RoomNgu1.route)})
        }
        item {
            RoomCard(room_name = "Phòng Ngủ", icon = R.drawable.baseline_bed_24,{navController.navigate(Screens.RoomNgu2.route)})
        }
        item {
            RoomCard(room_name = "Phòng Bếp", icon = R.drawable.baseline_kitchen_24,{navController.navigate(Screens.RoomBep.route)})
=======
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
            RoomCard(room_name = "Phòng Tắm", icon = R.drawable.baseline_bathtub_24,{navController.navigate(Screens.RoomTam.route)})
        }
    }
}