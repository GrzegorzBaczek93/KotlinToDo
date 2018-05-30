package com.grzeg.kotlintodo.data

interface Repository {

    fun loadItems()

    fun loadItem()

    fun saveItems()

    fun saveItem()
}