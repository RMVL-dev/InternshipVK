package com.example.intershipvk.ui.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.createViewModelLazy
import com.example.intershipvk.data.Product
import com.example.intershipvk.databinding.FragmentCatalogBinding
import com.example.intershipvk.ui.ResponseState
import com.example.intershipvk.ui.catalog.rv.CatalogAdapter
import com.example.intershipvk.ui.provider.ProductsViewModelProvider


class CatalogFragment : Fragment() {

    private var _binding: FragmentCatalogBinding? = null
    private val binding
        get() = _binding!!

    private val viewModel:CatalogViewModel by createViewModelLazy(
        CatalogViewModel::class,
        { this.viewModelStore },
        factoryProducer ={ProductsViewModelProvider().factory}
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getProducts(offset = 0, countPetPage = 20)
        viewModel.productLiveData.observe(viewLifecycleOwner){response ->
            when(response){
                is ResponseState.Error -> {

                }
                is ResponseState.Loading -> {

                }
                is ResponseState.Success -> {
                    prepareCatalog(response.data.products)
                }
            }
        }
    }

    private fun prepareCatalog(data:List<Product>) {
        val adapter = CatalogAdapter(data = data)

        binding.rvProductCatalog.adapter = adapter
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }


}