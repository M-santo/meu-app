package com.alunosqualifica.cria_aplicativo

class ShoppingList {
    private val shoppingItems = mutableListOf<ShoppingItem>()

    fun addShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItems.add(shoppingItem)
    }

    fun get(position: Int): ShoppingItem {
        return shoppingItems[position]
    }

    fun size(): Int {
        return shoppingItems.size
    }

    fun getTotal(): Double {
        var total = 0.0
        for (item in shoppingItems) {
            total += item.getTotal()
        }
        return total
    }
}