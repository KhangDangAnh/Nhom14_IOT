package com.example.iot_application


import android.os.Build.VERSION.SDK_INT
import android.util.Size
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.example.iot_application.Room.RoomViewModel

@Composable
fun NewFanCard() {
    var valuechecked by remember {
        mutableStateOf(false)
    }
    var viewModel: RoomViewModel = viewModel(
        modelClass = RoomViewModel::class.java
    )
    var state = viewModel.state
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
                if(valuechecked){
                    GifImage()
                }else{
                    Icon(painter = painterResource(id = R.drawable.fanvip1), contentDescription = "", Modifier.clip(
                        CircleShape).size(120.dp))
                }
                Text(text = "Fan", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Switch(
                    checked = state.giatriquat,
                    onCheckedChange = {viewModel::onChangeValueQuat},
                    thumbContent = {
                        if(state.giatriquat){
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
@Composable
fun GifImage(
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(context).data(data = R.drawable.fanvip).apply(block = {
                }).build(), imageLoader = imageLoader
            ),
            contentDescription = null,
            modifier = modifier.clip(CircleShape),
        )
}
