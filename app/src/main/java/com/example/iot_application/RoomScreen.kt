package com.example.iot_application

import android.provider.MediaStore.Audio.Radio
import android.widget.Toast
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoomScreen() {
    var RoomName by remember {
        mutableStateOf("Room")
    }
    var option by remember {
        mutableStateOf(0)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.largeTopAppBarColors(containerColor = Color.Red, titleContentColor = Color.White),
                title = {
                    Text(text = RoomName,fontWeight = FontWeight.Bold)
                },
                navigationIcon = { IconButton(onClick = { }) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
                }}
            )
        }
    ) {
        Column(modifier = Modifier
            .padding(it)
            .fillMaxWidth()
            .fillMaxHeight(),
           ) {
            Spacer(modifier = Modifier.padding(10.dp))
            BongDen()
            Spacer(modifier = Modifier.padding(10.dp))
            CanhQuat()
        }
    }
}

@Composable
fun BongDen() {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(230.dp)
        .background(color = Color.Gray)
        .border(width = 2.dp, color = Color.Blue, shape = RoundedCornerShape(20.dp))) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.bongden),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center) {
                RadioButton()
                ProgressBar()
            }
        }
    }
}

@Composable
fun CanhQuat() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(color = Color.Gray)
            .border(width = 2.dp, color = Color.Blue, shape = RoundedCornerShape(20.dp))
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.canhquat),
                contentDescription = null,
                Modifier
                    .size(150.dp)
                    .clip(CircleShape)
            )
            RadioButton()
        }
    }
}

@Composable
fun RadioButton() {
    val radioOptions = listOf("Bật", "Tắt")
    var selectedOption by remember { mutableStateOf(radioOptions[0]) }
    Column(modifier = Modifier.fillMaxWidth()) {
        radioOptions.forEach { option ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .selectable(
                        selected = selectedOption == option,
                        onClick = {
                            selectedOption == option
                        }
                    )
                    .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = selectedOption==option,
                    onClick = {
                        selectedOption==option
                    }
                )
                Text(
                    text = option,
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                )
            }
        }
    }
}
@Composable
fun ProgressBar() {
    val context = LocalContext.current
    var progressCount: Int by remember {
        mutableStateOf(0)
    }
    var progress by remember {
        mutableStateOf(0f)
    }
    when(progressCount){
        0-> progress =0f
        1-> progress =0.1f
        2-> progress =0.2f
        3-> progress =0.3f
        4-> progress =0.4f
        5-> progress =0.5f
        6-> progress =0.6f
        7-> progress =0.7f
        8-> progress =0.8f
        9-> progress =0.9f
        10-> progress =1.0f
    }
    val size by animateFloatAsState(
        targetValue = progress,
        tween(
            durationMillis = 1000,
            delayMillis = 200,
            easing = LinearOutSlowInEasing
        )
    )
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Tăng giảm độ sáng")
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .widthIn(min = 30.dp)
            .fillMaxWidth(size),
            horizontalArrangement = Arrangement.Center) {
            Text(text = "$progress")
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(17.dp)) {
            Box(modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(9.dp))
                .background(color = Color.Cyan))
            Box(modifier = Modifier
                .fillMaxWidth(size)
                .fillMaxHeight()
                .clip(RoundedCornerShape(9.dp))
                .background(color = Color.White)
                .animateContentSize())
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically){
            Button(
                onClick = { if(progressCount>0){
                    progressCount-=2
                }else{
                    Toast.makeText(context,"Ban khong the giam them",Toast.LENGTH_SHORT).show()
                }
                }
            ) {
                Text(text = "Giam")
            }
            Button(
                onClick = {
                    if(progressCount<10){
                        progressCount+=2;
                }else{
                    Toast.makeText(context,"Ban khong the tang them",Toast.LENGTH_SHORT).show()
                    }
                }
            ) {
                Text(text = "Tang")
            }
        }
    }
//    LaunchedEffect(key1 = true){
//        progress=0.7f
//    }
}

@Preview
@Composable
fun SSS() {
    RoomScreen()
}
