package com.mohamed.mostafa.cryptocurrencies.android.presentation.events.components


import android.graphics.Color.TRANSPARENT
import android.graphics.Color.WHITE
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun EventTypes(types: List<String>, selectedType: String, onItemClicked: (String) -> Unit) {
    LazyRow(
//        modifier = Modifier.padding(18.dp)
    ) {
        items(types) { type ->
            EventTypeItem(
                title = type,
                onItemClicked = onItemClicked,
                isSelected = type == selectedType
            )
        }
    }
}


@Composable
fun EventTypeItem(title: String, isSelected: Boolean = false, onItemClicked: (String) -> Unit) {
    Text(
        title,
        style = MaterialTheme.typography.body1.copy(
            color = if (isSelected) Color(WHITE) else MaterialTheme.colors.primary,
        ),
        modifier = Modifier
            .padding(12.dp)
            .clickable {
                onItemClicked(title)
            }
            .border(
                2.dp,
                color = if (isSelected) Color(TRANSPARENT) else MaterialTheme.colors.primary,
                shape = RoundedCornerShape(8.dp),
            )
            .background(
                if (isSelected) MaterialTheme.colors.primary else Color(WHITE),
                shape = RoundedCornerShape(8.dp)
            )
            .padding(horizontal = 10.dp, vertical = 6.dp),
    )
}