package com.example.iot_application.Room


import android.os.Build
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.iot_application.R
import com.google.firebase.Firebase
import com.google.firebase.database.database

@OptIn(ExperimentalMaterial3Api::class)
@Composable
public fun BedRoom1(navController: NavHostController) {
    var LedSlider by remember {
        mutableStateOf(0f)
    }
    var Fan by remember {
        mutableStateOf(false)
    }
    val database = Firebase.database
    val bed1 = bedroom1(2,"BEDROOM1",LedSlider,Fan)

    val fanchecked = database.getReference("Fan")
    val ledchecked = database.getReference("Brightness Level")
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color(12, 27, 50), titleContentColor = Color.White),
                title = {
                    Text(text = "Bed Room 1",fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                },
                navigationIcon = { IconButton(onClick = {navController.popBackStack()},Modifier.size(20.dp)) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)
                }}
            )
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize(),
        ) {
            //Den bang slider
            Card(modifier = Modifier
                .height(150.dp)
                .padding(10.dp),
                border = BorderStroke(1.dp,Color.Gray)
            ) {
                Column(modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally)
                {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        if(LedSlider>0.1){
                            Icon(painter = painterResource(id = R.drawable.iconlight), contentDescription = "", Modifier.size(120.dp), tint = Color.Yellow)
                        }else{
                            Icon(painter = painterResource(id = R.drawable.iconlight), contentDescription = "", Modifier.size(120.dp))
                        }
                        Text(text = "Light", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(start = 5.dp)) {
                            Text(text = LedSlider.toString())
                            Slider(
                                value = LedSlider,
                                onValueChange ={
                                    LedSlider=it
                                    if (LedSlider<0.1){
                                        ledchecked.setValue("0%")
                                    }
                                    if (LedSlider>0.332){
                                        ledchecked.setValue("muc do 1")
                                    }
                                    if (LedSlider>0.665){
                                        ledchecked.setValue("muc do 2")
                                    }
                                    if (LedSlider>0.987){
                                        ledchecked.setValue("muc do 3")
                                    }
                            },
                            colors = SliderDefaults.colors(
                                thumbColor = MaterialTheme.colorScheme.secondary,
                                activeTrackColor = MaterialTheme.colorScheme.secondary,
                                inactiveTrackColor = MaterialTheme.colorScheme.primary,
                            ),
                            steps = 2,
                            )
                        }
                    }
                }
            }
            //Quat
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
                        if(Fan){
                            com.example.iot_application.GifImage()
                        }else{
                            Icon(painter = painterResource(id = R.drawable.fanvip1), contentDescription = "", Modifier.clip(
                                CircleShape).size(120.dp))
                        }
                        Text(text = "Fan", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Switch(
                            checked = Fan,
                            onCheckedChange = {
                                Fan=it
                                if (Fan){
                                    fanchecked.setValue(1)
                                }else{
                                    fanchecked.setValue(0)
                                }
                            },
                            thumbContent = {
                                if(Fan){
                                    Icon(painter = painterResource(id = R.drawable.fan),
                                        contentDescription = "",
                                        tint = Color.Yellow)
                                }
                                else{
                                    Icon(painter = painterResource(id = R.drawable.fan),
                                        contentDescription = "",
                                        tint = Color.Gray)
                                }
                            })
                    }
                }
            }
        }
    }
}
data class bedroom1(
    val id:Int,
    val name:String="BEDROOM1",
    val ledSlider:Float,
    val fan:Boolean
)
