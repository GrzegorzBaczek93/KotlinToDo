package com.grzeg.kotlintodo.ui.createview

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import com.grzeg.kotlintodo.R

import com.grzeg.kotlintodo.databinding.CreateItemFragmentBinding

class CreateItem : Fragment() {

    companion object {
        fun newInstance() = CreateItem()
    }

    private lateinit var viewModel: CreateItemViewModel
    private lateinit var dataBinding: CreateItemFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        dataBinding = CreateItemFragmentBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(this).get(CreateItemViewModel::class.java)

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupFabListener()
    }

    private fun setupFabListener() {
        dataBinding.floatingActionButton.setOnClickListener {
            findNavController(it).popBackStack()
        }
    }
}
