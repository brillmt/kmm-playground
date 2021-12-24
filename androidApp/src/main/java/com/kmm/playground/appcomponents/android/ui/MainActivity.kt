package com.kmm.playground.appcomponents.android.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kmm.playground.appcomponents.android.R
import com.kmm.playground.appcomponents.android.viewmodels.CryptoViewModel
import com.kmm.playground.appcomponents.android.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

//fun greet(): String {
//    return Greeting().greeting()
//}

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val cryptoViewModel: CryptoViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.initString.observe(this, {
            val tv: TextView = findViewById(R.id.text_view)
            tv.text = it
        })

        cryptoViewModel.data.observe(this, {
            val tv: TextView = findViewById(R.id.coins)
            tv.text = it.toString()
        })

        viewModel.start()

        cryptoViewModel.start()
    }
}
