package com.example.androiddevchallenge.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.utils.submit
import com.example.androiddevchallenge.Data

class CatViewModel : ViewModel() {

    val cats: LiveData<List<Cat>> = MutableLiveData<List<Cat>>()
    val cat: LiveData<Cat> = MutableLiveData<Cat>()

    fun request() {
        cats.submit(Data.cats)
    }

    fun requestByCatId(catId: String) {
        Data.cats.find { it.id == catId }?.also {
            cat.submit(it)
        }
    }
}