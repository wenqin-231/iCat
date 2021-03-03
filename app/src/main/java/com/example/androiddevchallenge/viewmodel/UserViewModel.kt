package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.Data
import com.example.androiddevchallenge.model.User
import com.example.androiddevchallenge.utils.submit

class UserViewModel : ViewModel() {

    val user: LiveData<User> = MutableLiveData<User>()

    fun requestUser() {
        user.submit(Data.user)
    }
}