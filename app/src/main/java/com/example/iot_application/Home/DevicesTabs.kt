package com.example.iot_application.Home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.iot_application.R

typealias MyTabsFunction = @Composable () -> Unit
sealed class DevicesTabs_item(
    var title : String,
    var screen : MyFunction,
    var icon : Int
){
    object Light :DevicesTabs_item("Light",{ LightScreen()}, R.drawable.baseline_lightbulb_24)
    object Thermostat :DevicesTabs_item("Temperature",{Temperature_Screen()}, R.drawable.baseline_device_thermostat_24)
    object Fan :DevicesTabs_item("Fan",{ Fan_Screen() }, R.drawable.sharp_wind_power_24)
}
