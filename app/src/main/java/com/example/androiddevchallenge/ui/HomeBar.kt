package com.example.androiddevchallenge.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.utils.showToast
import com.example.androiddevchallenge.viewmodel.UserViewModel

@Composable
fun HomeBar(userViewModel: UserViewModel = viewModel()) {
    val user = userViewModel.user.observeAsState()
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
    ) {
        val context = LocalContext.current
        Image(
            painter = painterResource(id = user.value?.avatar ?: R.drawable.ic_avatar),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 16.dp)
                .size(35.dp)
                .clip(CircleShape)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_category),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 16.dp)
                .size(30.dp)
                .clickable {
                    context.showToast("Filter will come with dialog")
                }
        )
    }
}