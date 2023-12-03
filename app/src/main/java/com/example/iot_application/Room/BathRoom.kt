package com.example.iot_application.Room


import android.hardware.lights.Light
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
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
public fun BathRoom(navController: NavHostController) {

    var Led by remember {
        mutableStateOf(false)
    }
    val database = Firebase.database
    val BATHROOM = database.reference.child("ROOM")
    val bath = bathroom(5,"BATHROOM",Led)

    val checked = database.getReference("Led")
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color(12, 27, 50), titleContentColor = Color.White),
                title = {
                    Text(text = "Toilet",fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
                },
                navigationIcon = { IconButton(onClick = { navController.popBackStack()},Modifier.size(20.dp)) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null, tint = Color.White)
                }}
            )
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxSize(),
        ) {
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
                        if(Led){
                            Icon(painter = painterResource(id = R.drawable.iconlight), contentDescription = "", Modifier.size(120.dp), tint = Color.Yellow)
                        }else{
                            Icon(painter = painterResource(id = R.drawable.iconlight), contentDescription = "", Modifier.size(120.dp))
                        }
                        Text(text = "Light", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Switch(
                            checked = Led,
                            onCheckedChange = {
                                Led=it
                                if(Led==true){
                                    checked.setValue(1)
                                }else{
                                    checked.setValue(0)
                                }
                                              },
                            thumbContent = {
                                if(Led){
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
    }
}

data class bathroom(
    val id:Int,
    val name:String="BATHROOM",
    val led:Boolean
)