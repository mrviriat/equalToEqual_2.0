package com.example.equaltoequal_20.drawerNav.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Card (modifier = Modifier.fillMaxWidth().height(300.dp).padding(10.dp)) {}
        Text(text = "Тут будут все проекты",  style = MaterialTheme.typography.headlineMedium)
        Text(
            text = "This place will soon have a design",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}