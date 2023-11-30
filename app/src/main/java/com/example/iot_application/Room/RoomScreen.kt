package com.example.iot_application.Room

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomScreen(navController: NavController,/*isFan:Boolean,isLightBySlider:Boolean,isLightbyButton:Boolean*/) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color(12, 27, 50), titleContentColor = Color.White),
                title = {
                    Text(text = "Room",fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                },
                navigationIcon = { IconButton(onClick = {navController.popBackStack() },Modifier.size(20.dp)) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)
                }}
            )
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize(),
           ) {
//            if(isFan==true){
//                FanCard()
//            }
//            if(isLightbyButton==true){
//                LightCardByButton()
//            }
//            if(isLightBySlider==true){
//                LightCardBySliderPosition()
//            }
            FanCard()
            LightCardByButton()
            LightCardBySliderPosition()
        }
    }
}
