package com.example.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.ui.theme.colorBg

@Composable
fun App() {
    Column(
        modifier = Modifier
            .background(color = colorBg)
            .fillMaxSize()
    ) {
        HomeBar()
        HomeContent()
    }
}