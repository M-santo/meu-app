package com.alunosqualifica.cria_aplicativo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShoppingListActivity : AppCompatActivity() {
    private lateinit var shoppingList: ShoppingList
    private lateinit var listView: ListView
    private lateinit var textViewTotal: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

        shoppingList = ShoppingList()
        listView = findViewById(R.id.list_view_shopping_items)
        textViewTotal = findViewById(R.id.text_view_total)

        val addButton = findViewById<Button>(R.id.button_add)
        addButton.setOnClickListener { addShoppingItem() }
    }

    private fun addShoppingItem() {
        val name = findViewById<EditText>(R.id.edit_text_name).text.toString()
        val price = findViewById<EditText>(R.id.edit_text_price).text.toString().toDouble()
        val quantity = findViewById<EditText>(R.id.edit_text_quantity).text.toString().toInt()

        val shoppingItem = ShoppingItem(name, price, quantity)
        shoppingList.addShoppingItem(shoppingItem)

        listView.adapter = ShoppingListAdapter(this, shoppingList)
        updateTotal()
    }

    @SuppressLint("SetTextI18n")
    private fun updateTotal() {
        val total = shoppingList.getTotal()
        textViewTotal.text = "Total: R$ $total,00"
    }
}