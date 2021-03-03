package com.example.androiddevchallenge.model

data class Cat(
    val id: String,
    val name: String = "",
    val age: String = "",
    val gender: String = "",
    val location: String = "",
    val sterilization: Boolean = false,
    var character: String = "",
    var foodBrands: String = "",
    val pictures: List<Int> = arrayListOf(),
    // 豆腐或硼土，or both
    val litter: String = "",
    // 要求有纱窗
    val requestWindowScreens: Boolean = true,
    val guardians: User? = null,
    var vaccines: String = ""
)