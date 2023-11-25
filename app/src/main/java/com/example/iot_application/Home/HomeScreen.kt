package com.example.iot_application.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = "Home",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp
                )
            })
        }
    ) {
    Column(modifier = Modifier
        .padding(it)
        .fillMaxSize())
    {
        TabContent()
    }
    }
}