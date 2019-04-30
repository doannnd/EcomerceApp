package com.nguyendinhdoan.ecomerceapp

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.nguyendinhdoan.ecomerceapp.model.Product
import com.squareup.picasso.Picasso

class ProductAdapter(private val productList: ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val itemView = LayoutInflater.from(context).inflate(R.layout.product_row, parent, false)
        val holder = ViewHolder(itemView)
        itemView.setOnClickListener {
            val intent = Intent(context, ProductDetails::class.java)
            intent.putExtra("title", productList[holder.adapterPosition].title)
            context.startActivity(intent)
        }
        return holder
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]
        Picasso.get().load(product.photoUrl).into(holder.photo)
        holder.title.text = product.title
        holder.price.text = product.price.toString()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val photo: ImageView = itemView.findViewById(R.id.photo)
        val title: TextView = itemView.findViewById(R.id.title)
        val price: TextView = itemView.findViewById(R.id.price)
    }
}
