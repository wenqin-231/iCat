package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.androiddevchallenge.ui.Detail
import com.example.androiddevchallenge.viewmodel.CatViewModel

class DetailActivity : AppCompatActivity() {

    companion object {
        private const val KEY_ID = "key_id"
        fun start(context: Context, catId: String) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(KEY_ID, catId)
            context.startActivity(intent)
        }
    }

    private lateinit var catId: String
    private val viewModel: CatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        catId = intent.getStringExtra(KEY_ID).orEmpty()
        viewModel.requestByCatId(catId)
        setContent {
            Detail {
                finish()
            }
        }
    }
}