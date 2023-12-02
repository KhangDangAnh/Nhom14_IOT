package com.example.iot_application

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavHostController
import com.example.iot_application.R
import com.example.iot_application.Screens


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChartScreen(
    data: Map<Float, String>,
    max_value: Int,
    navController: NavHostController
) {
    val context = LocalContext.current
    // BarGraph Dimensions
    val barGraphHeight by remember { mutableStateOf(250.dp) }
    val barGraphWidth by remember { mutableStateOf(20.dp) }
    // Scale Dimensions
    val scaleYAxisWidth by remember { mutableStateOf(50.dp) }
    val scaleLineWidth by remember { mutableStateOf(2.dp) }
    Scaffold(
        bottomBar = {
            BottomAppBar(
                Modifier.clip(
                    RoundedCornerShape(20.dp),
                ),
                containerColor = Color.LightGray
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    androidx.compose.material.IconButton(onClick = { navController.navigate(Screens.Home.route) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_home_24),
                            contentDescription = "",
                            tint = Color.DarkGray
                        )
                    }
                    androidx.compose.material.IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_doorbell_24),
                            contentDescription = "",
                            tint = Color.DarkGray
                        )
                    }
                    androidx.compose.material.IconButton(onClick = { navController.navigate(Screens.Chart.route) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_bar_chart_24),
                            contentDescription = "",
                            tint = Color.DarkGray
                        )
                    }
                    androidx.compose.material.IconButton(onClick = { navController.navigate(Screens.Profile.route) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_account_circle_24),
                            contentDescription = "",
                            tint = Color.DarkGray
                        )
                    }
                }
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Nhiệt độ",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(12, 27, 50),
                    titleContentColor = Color.White

                ),
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = Color.White
                        )

                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "Biểu đồ nhiệt dộ",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Card(
                modifier = Modifier.background(Color(230, 230, 230))
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Top
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(barGraphHeight),
                        verticalAlignment = Alignment.Bottom,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        // scale Y-Axis
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(scaleYAxisWidth),//xac dinh chieu dai truc y
                            contentAlignment = Alignment.BottomCenter
                        ) {
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                Text(text = max_value.toString())
                                Spacer(modifier = Modifier.fillMaxHeight())
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                Text(text = (max_value * 0.75).toString())
                                Spacer(modifier = Modifier.fillMaxHeight(0.75f))
                            }

                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                Text(text = (max_value * 0.5).toString())
                                Spacer(modifier = Modifier.fillMaxHeight(0.5f))
                            }
                            Column(
                                modifier = Modifier.fillMaxHeight(),
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                Text(text = (max_value * 0.25).toString())
                                Spacer(modifier = Modifier.fillMaxHeight(0.25f))
                            }


                        }

                        // Y-Axis Line
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(scaleLineWidth)
                                .background(Color.Black)
                        )

                        // graph
                        data.keys.forEach {
                            Box(
                                modifier = Modifier
                                    .padding(start = barGraphWidth, bottom = 5.dp)

                                    .width(barGraphWidth)
                                    .fillMaxHeight(it / 100)
                                    .background(Color(3, 122, 252))
                                    .clickable {
                                        Toast
                                            .makeText(context, it.toString(), Toast.LENGTH_SHORT)
                                            .show()
                                    }
                            )
                        }

                    }

                    // X-Axis Line
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(scaleLineWidth)
                            .background(Color.Black)
                    )

                    // Scale X-Axis
                    Row(
                        modifier = Modifier
                            .padding(start = scaleYAxisWidth + barGraphWidth + scaleLineWidth)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(barGraphWidth)
                    ) {

                        data.values.forEach {
                            Text(
                                modifier = Modifier.width(barGraphWidth),
                                text = it,
                                textAlign = TextAlign.Center
                            )
                        }

                    }


                }

            }







            Text(
                text = "Thông tin chi tiết",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )
            Card(
                modifier = Modifier
                    .height(250.dp)
                    .fillMaxWidth()
                    .background(Color(230, 230, 230))


            ) {
                Column(
                    modifier = Modifier

                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var day = 2;


                    data.keys.forEach {
                        Row(
                            modifier = Modifier

                                .fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceEvenly
                        ) {
                            val theme by remember {
                                mutableStateOf(
                                    if (it <= 15)
                                        Color(3, 122, 252)
                                    else if (it <= 35)
                                        Color(5, 225, 119)
                                    else
                                        Color(241, 51, 39)

                                )
                            }
                            if (day < 8) {
                                Text(
                                    text = "Nhiệt độ thứ ${day}: ${it} °C",
                                    fontSize = 20.sp
                                )
                                Box(
                                    modifier = Modifier
                                        .width(18.dp)
                                        .height(18.dp)
                                        .clip(MaterialTheme.shapes.large)
                                        .background(theme)
                                )




                                day++;
                            } else {
                                Text(
                                    text = "Nhiệt độ CN: ${it} °C",
                                    fontSize = 20.sp
                                )
                                Box(
                                    modifier = Modifier
                                        .width(18.dp)
                                        .height(18.dp)
                                        .clip(MaterialTheme.shapes.large)
                                        .background(theme)
                                )

                                day = 2;


                            }

                        }


                    }
                }
            }
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .background(Color(230, 230, 230))
            ) {
                var avtemp = 0f;
                var step = 0;
                data.keys.forEach {
                    step++
                    avtemp += it
                }
                var result = String.format("%.2f", avtemp / step)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Text(
                        text = "Nhiệt độ trung bình:",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${result} °C",
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(241, 51, 39)
                    )
                }
            }
        }


    }
}
