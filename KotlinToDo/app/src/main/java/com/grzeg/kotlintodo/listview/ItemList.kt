package com.grzeg.kotlintodo.listview

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import com.grzeg.kotlintodo.R

import com.grzeg.kotlintodo.databinding.ItemListFragmentBinding

class ItemList : Fragment() {

    companion object {
        fun newInstance() = ItemList()
    }

    private lateinit var viewModel: ItemListViewModel
    private lateinit var dataBinding: ItemListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        dataBinding = ItemListFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this).get(ItemListViewModel::class.java)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpFabListener()
    }

    private fun setUpFabListener() {
        dataBinding.floatingActionButton.setOnClickListener {
            findNavController(it).navigate(R.id.fab_action, null)
        }
    }
}
