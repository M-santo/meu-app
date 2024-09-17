package com.alunosqualifica.cria_aplicativo

class ShoppingItem(val name: String, val price: Double, val quantity: Int) {
    fun getTotal(): Double {
        return price * quantity
    }
}