package com.example.contactapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayListOf<ItemModel>(
            ItemModel(1, "David", "0928234876", "david@gmail.com"),
            ItemModel(2, "John", "0123456789", "john@gmail.com"),
            ItemModel(3, "Emily", "0231458876", "emily@gmail.com"),
            ItemModel(4, "Sarah", "0987864128", "sarah@gmail.com"),
            ItemModel(5, "Michael", "0369852147", "michael@gmail.com"),
            ItemModel(6, "Jessica", "0857496321", "jessica@gmail.com"),
            ItemModel(7, "Daniel", "0789632145", "daniel@gmail.com"),
            ItemModel(8, "Olivia", "0258964713", "olivia@gmail.com"),
            ItemModel(9, "William", "0856932147", "william@gmail.com"),
            ItemModel(10, "Sophia", "0896547123", "sophia@gmail.com")
        )

        val adapter = ItemAdapter(items)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter

        listView.onItemClickListener  = AdapterView.OnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("id", items[position].id)
            intent.putExtra("name", items[position].name)
            intent.putExtra("phoneNumber", items[position].phoneNumber)
            intent.putExtra("email", items[position].email)

            startActivity(intent)
        }

        registerForContextMenu(findViewById(R.id.listView))
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.main_menu, menu)
    }
}