package com.mohamed.mostafa.cryptocurrencies.android.presentation.events.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.mohamed.mostafa.cryptocurrencies.android.presentation.components.HtmlText
import com.mohamed.mostafa.cryptocurrencies.features.events.domain.models.Event


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
        Column {
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

            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    event.title ?: "",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.weight(1f)
                )
                if (event.organizer != null) {
                    Text(
                        String.format("By %s", event.organizer ?: ""),
                        style = MaterialTheme.typography.body2
                    )
                }
            }

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

@Composable
fun LoadingEventItem() {

    val infiniteTransition = rememberInfiniteTransition()

    val alpha by infiniteTransition.animateFloat(
        initialValue = .5f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1000
                0.7f at 500
            },
            repeatMode = RepeatMode.Reverse
        )
    )

    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(Color.LightGray.copy(alpha = alpha))
            )

            Spacer(Modifier.height(10.dp))

            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(10.dp)
                        .background(Color.LightGray.copy(alpha = alpha))
                )
                Box(
                    modifier = Modifier
                        .height(10.dp)
                        .background(Color.LightGray.copy(alpha = alpha))
                )
            }

            Spacer(Modifier.height(10.dp))
        }
    }
}