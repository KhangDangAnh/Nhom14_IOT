package com.example.iot_application.Home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.example.iot_application.R
import com.example.iot_application.Screens
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalFoundationApi::class)
@Composable
fun Tabs_Contents(navController: NavHostController) {
    val tabItems = listOf<TabItem>(
        TabItem(
            title = "Home",
            UnSelectIcon = R.drawable.outline_home_24,
            SelectIcon = R.drawable.baseline_home_24,
            Screen = { RoomList(navController) }
        ),
        TabItem(
            title = "Devices",
            UnSelectIcon = R.drawable.outline_devices_other_24,
            SelectIcon = R.drawable.baseline_devices_other_24,
            Screen = { DeviceScreen(navController) }
        )
    )
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val pagerState = rememberPagerState {
        tabItems.size
    }
    LaunchedEffect(selectedTabIndex)
    {
        pagerState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress)
    {
        if (!pagerState.isScrollInProgress)
            selectedTabIndex = pagerState.currentPage
    }
    Column(Modifier.fillMaxSize()) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabItems.forEachIndexed { index, tabItem ->
                Tab(selected = index == selectedTabIndex,
                    onClick = {
                        selectedTabIndex = index
                    },
                    text = { Text(text = tabItem.title) },
                    icon = {
                        Icon(
                            painter = if (index == selectedTabIndex) {
                                painterResource(id = tabItem.SelectIcon)
                            } else {
                                painterResource(id = tabItem.UnSelectIcon)
                            }, contentDescription = ""
                        )
                        /////
                    }
                )
            }
        }
        HorizontalPager(
            state = pagerState
        ) { page ->
            tabItems[page].Screen()
        }
    }
}

data class TabItem(
    val title: String,
    val UnSelectIcon: Int,
    val SelectIcon: Int,
    val Screen: MyFunction
)
typealias MyFunction = @Composable () -> Unit