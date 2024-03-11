package com.example.intershipvk.ui.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.intershipvk.databinding.FragmentProductItemBinding
import com.example.intershipvk.fromJson
import com.example.intershipvk.ui.product.adapter.ViewPagerAdapter

class ProductItemFragment : Fragment() {

    private var _binding: FragmentProductItemBinding? = null
    private val binding: FragmentProductItemBinding
        get() = _binding!!

    //получение продукта из safe args в виде строки
    private val args:ProductItemFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductItemBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val product = fromJson(args.product)

        product?.let {
            binding.mt.title = it.title
            binding.mt.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            binding.vpPreview.adapter = ViewPagerAdapter(it.images)
            binding.tvProductSecondScreenTitle.text = it.title
            binding.tvProductSecondScreenPrice.text = "${it.price} $"
            binding.tvProductSecondScreenDescr.text = it.description
        }


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}