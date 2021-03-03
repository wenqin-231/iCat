package com.example.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.androiddevchallenge.ui.theme.colorBg

@Composable
fun Detail(onBackPress: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorBg)
    ) {
        DetailBar(onBackPress)
        DetailContent()
    }
}