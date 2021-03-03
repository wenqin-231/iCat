package com.example.androiddevchallenge

import com.example.androiddevchallenge.model.Cat
import com.example.androiddevchallenge.model.User

object Data {

    val user = User("CatLover", R.drawable.ic_avatar)

    val cats = listOf(
        Cat(
            "1",
            name = "Lucy",
            age = "12个月",
            pictures = listOf(
                R.drawable.cat_1
            ),
            location = "上海",
            guardians = User(name = "张三", avatar = R.drawable.ic_avatar1),
            gender = "boy",
            litter = "豆腐",
            foodBrands = "渴望",
            character = "活泼",
            sterilization = true,
            vaccines = "狂犬和三针已经打齐"
        ),

        Cat(
            "2",
            name = "Mimi",
            age = "24个月",
            pictures = listOf(
                R.drawable.cat_2
            ),
            location = "北京",
            guardians = User(name = "刘六", avatar = R.drawable.ic_avatar2),
            gender = "girl",
            litter = "豆腐",
            foodBrands = "Now",
            character = "粘人",
            sterilization = true,
            vaccines = "狂犬和三针已经打齐"
        ),

        Cat(
            "3",
            name = "Dandy",
            age = "23个月",
            pictures = listOf(
                R.drawable.cat_3
            ),
            location = "广州",
            guardians = User(name = "王五", avatar = R.drawable.ic_avatar3),
            gender = "girl",
            litter = "硼土",
            foodBrands = "皇家",
            character = "爱叫",
            sterilization = true,
            vaccines = "狂犬和三针已经打齐"
        ),

        Cat(
            "4",
            name = "Coffee",
            age = "2个月",
            pictures = listOf(
                R.drawable.cat_4
            ),
            location = "深圳",
            guardians = User(name = "李四", avatar = R.drawable.ic_avatar4),
            gender = "girl",
            litter = "都可以",
            foodBrands = "渴望",
            character = "胆小",
            sterilization = false,
            vaccines = "未打疫苗"
        ),
    )
}