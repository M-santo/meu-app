package com.alunosqualifica.cria_aplicativo

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ShoppingListAdapter(context: Context, private val shoppingList: ShoppingList) :
    ArrayAdapter<ShoppingItem>(context, 0) {

    override fun getCount(): Int {
        return shoppingList.size()
    }

    override fun getItem(position: Int): ShoppingItem {
        return shoppingList.get(position)
    }

    @SuppressLint("MissingInflatedId", "ViewHolder", "SetTextI18n")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_shopping_list, parent, false)
        val nameTextView = view.findViewById<TextView>(R.id.text_view_name)
        val priceTextView = view.findViewById<TextView>(R.id.text_view_price)
        val quantityTextView = view.findViewById<TextView>(R.id.text_view_quantity)

        val shoppingItem = getItem(position)
        nameTextView.text = shoppingItem.name
        priceTextView.text = "R$ ${shoppingItem.price},00"
        quantityTextView.text = "${shoppingItem.quantity}x"

        return view
    }
}