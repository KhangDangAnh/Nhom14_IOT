package com.example.iot_application.Room

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
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
import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.iot_application.Home.RealTimeViewModel
=======

import com.example.iot_application.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@Composable
fun NewLightCardBySliderPosition() {
//    var valueSlider by remember {
//        mutableStateOf(0f)
//    }
//    var viewModel:RoomViewModel = viewModel(
//        modelClass = RoomViewModel::class.java
//    )
//    var state : RealTimeViewModel = viewModel(
//        modelClass = RealTimeViewModel::class.java
//    )
//
//    Card(modifier = Modifier
//        .height(150.dp)
//        .padding(10.dp),
//        border = BorderStroke(1.dp,Color.Gray)
//    ) {
//        Column(modifier = Modifier.fillMaxSize(),
//            verticalArrangement = Arrangement.Center,
//            horizontalAlignment = Alignment.CenterHorizontally)
//        {
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                horizontalArrangement = Arrangement.SpaceAround,
//                verticalAlignment = Alignment.CenterVertically
//            ){
//                if(state.giatridenSlider>0.1){
//                    Icon(painter = painterResource(id = R.drawable.iconlight), contentDescription = "", Modifier.size(120.dp), tint = Color.Yellow)
//                }else{
//                    Icon(painter = painterResource(id = R.drawable.iconlight), contentDescription = "", Modifier.size(120.dp))
//                }
//                Text(text = "Light", fontSize = 20.sp, fontWeight = FontWeight.Bold)
//                Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(start = 5.dp)) {
//                    Text(text = state.giatridenSlider.toString())
//                    Slider(value = state.giatridenSlider, onValueChange ={viewModel::onChangeValueDenSlider})
//                }
//            }
//        }
//    }
}

@Composable
fun NewLightCardByButton(Led:String) {
    var avc by remember { mutableStateOf(0) }
    val database = FirebaseDatabase.getInstance().getReference("Led")
    val ledBepRef = database.child(Led)
    var checked by remember { mutableStateOf(false) }
    if (avc == 1) {
        checked = true
    } else {
        checked = false
    }
    ledBepRef.addValueEventListener(object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            val ledBepValue = dataSnapshot.getValue(Int::class.java)
            avc = ledBepValue.toString().toInt()
        }

        override fun onCancelled(databaseError: DatabaseError) {
        }
    })
    var state : RealTimeViewModel = viewModel(
        modelClass = RealTimeViewModel::class.java
    )
    Card(modifier = Modifier
        .height(150.dp)
        .padding(10.dp),
        border = BorderStroke(1.dp,Color.Gray)) {
        Column(modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                if(valuechecked){
                    Icon(painter = painterResource(id = R.drawable.iconlight), contentDescription = "", Modifier.size(120.dp), tint = Color.Yellow)
                }else{
                    Icon(painter = painterResource(id = R.drawable.iconlight), contentDescription = "", Modifier.size(120.dp))
                }
                Text(text = "Light", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Switch(

                    checked = checked,
                    onCheckedChange = {checked = it},

                    thumbContent = {
                        if(state.giatriden){
                            Icon(painter = painterResource(id = R.drawable.light),
                                contentDescription = "",
                                tint = Color.Yellow)
                            state.setValueLed(1,Led)
                        }
                        else{
                            Icon(painter = painterResource(id = R.drawable.light),
                                contentDescription = "",
                                tint = Color.Gray)
                            if(checked == false && avc == 1)
                            {
                                state.setValueLed(0,Led)
                            }
                        }
                    })
            }
        }
    }
}
