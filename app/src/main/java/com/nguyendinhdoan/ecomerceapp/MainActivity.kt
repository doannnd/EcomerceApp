package com.nguyendinhdoan.ecomerceapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.nguyendinhdoan.ecomerceapp.model.Product
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productList = arrayListOf<Product>()

        for (i in 0..100) {
            productList.add(Product("Organic Apple #$i", "https://via.placeholder.com/150/dddddd/000000", 1.99))
        }

        recycler_view.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = ProductAdapter(productList)
        }
    }
}
