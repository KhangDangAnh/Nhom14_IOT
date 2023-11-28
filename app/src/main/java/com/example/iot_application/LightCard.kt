package com.example.iot_application

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

@Composable
fun LightCardBySliderPosition() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    Card(modifier = Modifier
        .height(150.dp)
        .padding(top = 5.dp, bottom = 5.dp)) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                if(sliderPosition>0.1){
                    Icon(painter = painterResource(id = R.drawable.iconlight), contentDescription = "", Modifier.size(120.dp), tint = Color.Yellow)
                }else{
                    Icon(painter = painterResource(id = R.drawable.iconlight), contentDescription = "", Modifier.size(120.dp))
                }
                Text(text = "Light", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(start = 5.dp)) {
                    Text(text = sliderPosition.toString())
                    Slider(value = sliderPosition, onValueChange ={sliderPosition=it})
                }
            }
        }
    }
}

@Composable
fun LightCardByButton() {
    var checked by remember {
        mutableStateOf(false)
    }
    Card(modifier = Modifier
        .height(150.dp)
        .padding(top = 5.dp, bottom = 5.dp)) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                if(checked){
                    Icon(painter = painterResource(id = R.drawable.iconlight), contentDescription = "", Modifier.size(120.dp), tint = Color.Yellow)
                }else{
                    Icon(painter = painterResource(id = R.drawable.iconlight), contentDescription = "", Modifier.size(120.dp))
                }
                Text(text = "Light", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Switch(
                    checked = checked,
                    onCheckedChange = {checked=it},
                    thumbContent = {
                        if(checked){
                            Icon(painter = painterResource(id = R.drawable.light),
                                contentDescription = "",
                                tint = Color.Yellow)
                        }
                        else{
                            Icon(painter = painterResource(id = R.drawable.light),
                                contentDescription = "",
                                tint = Color.Gray)
                        }
                    })
            }
        }
    }
}
