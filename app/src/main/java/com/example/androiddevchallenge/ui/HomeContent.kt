package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.DetailActivity
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.ui.theme.colorTextLight
import com.example.androiddevchallenge.viewmodel.CatViewModel

@Composable
fun HomeContent(catViewModel: CatViewModel = viewModel()) {
    val catLiveData = catViewModel.cats.observeAsState()
    val catList = catLiveData.value.orEmpty()
    LazyColumn(Modifier.fillMaxWidth()) {
        itemsIndexed(catList) { index, item ->
            ItemCat(item)
            if (index < catList.size - 1) {
                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                )
            }
        }
    }
}

@Composable
fun ItemCat(cat: Cat) {
    val context = LocalContext.current
    Box(
        Modifier
            .fillMaxWidth()
            .requiredHeight(300.dp)
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable {
                DetailActivity.start(context, cat.id)
            }
    ) {
        Image(
            painter = painterResource(cat.pictures.getOrNull(0) ?: 0),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .align(Alignment.BottomStart)
                .background(
                    Brush.verticalGradient(
                        colors = arrayListOf(
                            Color.Transparent, Color.DarkGray
                        )
                    )
                )
        )
        Column(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.BottomStart)
                .padding(start = 22.dp)
        ) {
            Text(
                text = cat.name,
                modifier = Modifier.wrapContentSize(),
                color = colorTextLight,
                fontSize = 22.sp,
                fontWeight = FontWeight(500),
            )
            Text(
                text = cat.location,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 3.dp, bottom = 12.dp),
                color = colorTextLight,
                fontSize = 16.sp,
            )
        }

        Text(
            text = cat.age,
            modifier = Modifier
                .wrapContentSize()
                .padding(end = 22.dp, bottom = 12.dp)
                .align(Alignment.BottomEnd),
            color = colorTextLight,
            fontSize = 16.sp
        )
    }
}