package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.ui.theme.colorBase
import com.example.androiddevchallenge.ui.theme.colorTextLight
import com.example.androiddevchallenge.utils.showToast
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.colorDarkGray
import com.example.androiddevchallenge.viewmodel.CatViewModel

@Composable
fun DetailContent(viewModel: CatViewModel = viewModel()) {
    val cat = viewModel.cat.observeAsState()
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxSize()
    ) {
        Column(Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = cat.value?.pictures?.getOrNull(0) ?: 0),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 10.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            cat.value?.apply {
                Content(name = gender, icon = R.drawable.ic_gener)
                Content(name = location, icon = R.drawable.ic_location)
                Content(name = age, icon = R.drawable.ic_age)
                Content(name = foodBrands, icon = R.drawable.ic_food)
                Content(name = if (sterilization) "已绝育" else "未绝育", icon = R.drawable.ic_sex)
                Content(name = character, icon = R.drawable.ic_character)
                Content(name = vaccines, icon = R.drawable.ic_medicine)
                Content(name = litter, icon = R.drawable.ic_litter)
                if (requestWindowScreens) {
                    Content(name = "须有纱窗", icon = R.drawable.ic_window)
                }
            }
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_cat_foot),
            contentDescription = null,
            modifier = Modifier
                .padding(bottom = 50.dp)
                .size(70.dp)
                .clip(CircleShape)
                .background(colorBase)
                .padding(10.dp)
                .align(Alignment.BottomCenter)
                .clickable {
                    context.showToast("I want to adopt him!")
                },
            tint = colorTextLight
        )
    }
}

@Composable
fun Content(name: String, icon: Int) {
    Row(
        Modifier
            .wrapContentSize()
            .padding(start = 16.dp, bottom = 7.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier
                .size(16.dp)
        )
        Text(
            text = name,
            modifier = Modifier
                .wrapContentSize()
                .padding(start = 10.dp),
            fontSize = 16.sp,
            color = colorDarkGray
        )
    }
}