package com.example.actfragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val txtFr2 = view.findViewById<TextView>(R.id.txtFr2)

        val data = arguments

        txtFr2.text = "Hello " + data?.getString("text") + "!!"


        return view
    }

}