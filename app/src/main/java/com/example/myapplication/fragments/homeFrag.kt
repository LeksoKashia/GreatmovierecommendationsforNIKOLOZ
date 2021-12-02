package com.example.myapplication.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.myapplication.R

class homeFrag: Fragment(R.layout.fragment_home) {
    private lateinit var editTextAmount: TextView
    private lateinit var buttonSend:Button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextAmount = view.findViewById(R.id.editTextAmount)
        buttonSend = view.findViewById(R.id.buttonSend)
        val controller = Navigation.findNavController(view)

        buttonSend.setOnClickListener(){
            val amountText = editTextAmount.text.toString()
            if(amountText.isEmpty())
                return@setOnClickListener
            val amount = amountText.toInt()
            val action = homeFragDirections.actionHomeFragToDashboardFrag(amount)
            controller.navigate(action)

        }
    }
}