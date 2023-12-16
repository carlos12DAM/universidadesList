package com.example.actfragments

import android.app.Fragment
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
class FirstFragment : Fragment()
{
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val btnFr1 = view.findViewById<Button>(R.id.btnFr1)
        val edtFr1 = view.findViewById<EditText>(R.id.edtFr1)

        val secondFragment = SecondFragment()

        btnFr1.setOnClickListener {

            val bundle = Bundle()

            bundle.putString("text",edtFr1.text.toString())

            secondFragment.arguments = bundle


            parentFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayout, secondFragment)
                    .commit()
            }

        }
        return view
    }
}