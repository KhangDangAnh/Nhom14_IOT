package com.example.iot_application.Home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Devices_TabContent() {
    val tabs = listOf<DevicesTabs_item>(
        DevicesTabs_item.Light,
        DevicesTabs_item.Thermostat,
        DevicesTabs_item.Fan
    )
    val pagerState = com.google.accompanist.pager.rememberPagerState()
    Column(modifier = Modifier.fillMaxSize()) {
        DevicesTabs(tabs, pagerState)
        DevicesTabs_content(tabs, pagerState)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DevicesTabs_content(tabs: List<DevicesTabs_item>, pagerState: com.google.accompanist.pager.PagerState) {
    HorizontalPager(count = tabs.size, state = pagerState) { page ->
        tabs[page].screen()
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun DevicesTabs(tabs: List<DevicesTabs_item>, pagerState: com.google.accompanist.pager.PagerState) {
    val scope = rememberCoroutineScope()
    TabRow(
        selectedTabIndex = pagerState.currentPage,
        containerColor = MaterialTheme.colorScheme.background,
        indicator = { tabPositions ->
            Modifier.pagerTabIndicatorOffset(
                pagerState = pagerState,
                tabPositions = tabPositions as List<androidx.compose.material.TabPosition>
            )
        }) {
        tabs.forEachIndexed { index, tabsItem ->
            LeadingIconTab(
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
                text = {
                    Text(text = tabsItem.title)
                },
                icon = { Icon(painter = painterResource(id =tabsItem.icon), contentDescription = "") })
        }
    }
}
