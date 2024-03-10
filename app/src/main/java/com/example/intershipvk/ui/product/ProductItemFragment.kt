package com.example.intershipvk.ui.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.intershipvk.R
import com.example.intershipvk.data.Product
import com.example.intershipvk.databinding.FragmentProductItemBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ProductItemFragment : Fragment() {

    private var _binding: FragmentProductItemBinding? = null
    private val binding: FragmentProductItemBinding
        get() = _binding!!

    private val args:ProductItemFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentProductItemBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val json by lazy { Gson() }
        val typeEntity = object : TypeToken<Product?>() {}.type
        val productString = args.product
        val product = json.fromJson(productString,typeEntity)

        binding.test.text = product
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}