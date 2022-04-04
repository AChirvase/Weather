package com.alex.weather.feature.homefeed

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alex.weather.R

@Composable
fun HomeFeedScreen(
    viewModel: HomeFeedViewModel
) {
    val state by viewModel.state.collectAsState()

    Column {
        Toolbar()
        when {
            state.isLoading -> ContentWithProgress()
            state.data.isNotEmpty() -> HomeFeedContent(
                state.data,
                onItemClick = { index -> viewModel.onItemClick(index) }
            )
        }
    }
}

@Composable
private fun HomeFeedContent(
    weatherEventList: List<HomeFeedItem>,
    onItemClick: (String) -> Unit,
) {
    Box {
        LazyColumn(content = {
            itemsIndexed(weatherEventList) { _, item ->
                when (item) {
                    is HomeFeedItem.EventWeatherItem -> {
                        TodoListItem(item = item, onItemClick)
                    }
                }
            }
        })
    }
}

@Composable
private fun TodoListItem(
    item: HomeFeedItem.EventWeatherItem,
    onItemClick: (String) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .clickable { onItemClick(item.id) },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = item.event,
            modifier = Modifier.padding(start = 16.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp
            )
        )
    }
}


@Composable
private fun Toolbar() {
    Row(
        modifier = Modifier
            .height(56.dp)
            .background(color = Color.Blue)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp),
            text = stringResource(id = R.string.home_feed_title),
            color = Color.White,
            fontSize = 18.sp,
            style = TextStyle(textAlign = TextAlign.Center, fontWeight = FontWeight.Bold),
            textAlign = TextAlign.Start,
        )
    }
}


@Composable
private fun ContentWithProgress() {
    Surface(color = Color.LightGray) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}