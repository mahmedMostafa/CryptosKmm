package com.mohamed.mostafa.cryptocurrencies.android.presentation.events.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.mohamed.mostafa.cryptocurrencies.android.presentation.components.HtmlText
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.Event


@Composable
fun EventsList(
    isLoading: Boolean,
    events: List<Event>,
) {
    //only show the events when not loading!
    if (!isLoading) {
        LazyColumn(
            contentPadding = PaddingValues(all = 10.dp) //this is clipToPadding false
        ) {
            items(events) { event ->
                EventItem(event = event)
            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun EventItem(event: Event) {

    val isExpanded = remember { mutableStateOf(event.isExpanded) }

    Card(
        modifier = Modifier
            .padding(12.dp)
            .clickable {
                isExpanded.value = !isExpanded.value
                event.isExpanded = !event.isExpanded
            },
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(

        ) {
            Image(
                painter = rememberImagePainter(
                    data = event.screenshot,
                    builder = {
                        crossfade(true)
                    }
                ),
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Spacer(Modifier.height(10.dp))

            Text(
                event.title ?: "",
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(horizontal = 10.dp)
            )

            Spacer(Modifier.height(10.dp))

            AnimatedVisibility(visible = isExpanded.value) {
                Column {
                    HtmlText(
                        html = event.description ?: "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp, end = 10.dp, bottom = 10.dp)
                    )
                }
            }
        }
    }
}