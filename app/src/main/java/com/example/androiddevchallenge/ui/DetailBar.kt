package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.theme.colorDarkGray
import com.example.androiddevchallenge.utils.showToast
import com.example.androiddevchallenge.viewmodel.CatViewModel

@Composable
fun DetailBar(onBackPress: () -> Unit, viewModel: CatViewModel = viewModel()) {
    val cat = viewModel.cat.observeAsState()
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .requiredHeight(56.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(24.dp)
                .align(Alignment.CenterStart)
                .clickable {
                    onBackPress()
                }
        )
        Text(
            text = cat.value?.name.orEmpty(),
            fontWeight = FontWeight(700),
            fontSize = 22.sp,
            color = colorDarkGray,
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )
        Image(
            painter = painterResource(id = cat.value?.guardians?.avatar ?: R.drawable.ic_avatar),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
                .size(35.dp)
                .clickable {
                    context.showToast("It is user of cat")
                }
        )
    }
}