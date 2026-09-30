package com.example.listpays


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listViewPays = findViewById<ListView>(R.id.listViewPays)

        val pays = arrayOf(
            "Téléphone",
            "Casque Bluetooth",
            "Montre connectée",
            "Chargeur USB",
            "Accessoires",
            "Cosmétiques",
        )

        val images = arrayOf(
            R.drawable.ic_phone,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_gallery,
            android.R.drawable.ic_menu_gallery
        )

        val adapter = ProductAdapter(this, pays, images)

        listViewPays.adapter = adapter

        listViewPays.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this,
                "Produit sélectionné : ${pays[position]}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }


    class ProductAdapter(
        context: Context,
        private val names: Array<String>,
        private val images: Array<Int>
    ) : ArrayAdapter<String>(context, 0, names) {

        override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
            val view = convertView ?: LayoutInflater.from(context)
                .inflate(R.layout.item_product, parent, false)
            view.findViewById<ImageView>(R.id.imgProduct).setImageResource(images[position])
            view.findViewById<TextView>(R.id.txtProductName).text = names[position]
            return view
        }
    }}