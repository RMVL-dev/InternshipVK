package com.example.intershipvk.ui.catalog

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.createViewModelLazy
import androidx.navigation.fragment.findNavController
import com.example.intershipvk.data.Product
import com.example.intershipvk.databinding.FragmentCatalogBinding
import com.example.intershipvk.toJson
import com.example.intershipvk.ui.ResponseState
import com.example.intershipvk.ui.catalog.rv.CatalogAdapter
import com.example.intershipvk.ui.provider.ProductsViewModelProvider
import com.google.gson.Gson


class CatalogFragment : Fragment() {

    private var _binding: FragmentCatalogBinding? = null
    private val binding
        get() = _binding!!

    private var offset = 0
    private var totalProducts = 0

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
        viewModel.getProducts(offset = offset, countPetPage = countPerPage)
        prepareClickListeners()
        viewModel.productLiveData.observe(viewLifecycleOwner){response ->
            when(response){
                is ResponseState.Error -> {

                }
                is ResponseState.Loading -> {

                }
                is ResponseState.Success -> {
                    prepareCatalog(response.data.products)
                    totalProducts = response.data.total
                }
            }
        }
    }

    /**
     * Опеределение адаптера для recycler view
     */
    private fun prepareCatalog(data:List<Product>) {
        val adapter = CatalogAdapter(data = data)
        adapter.onCardClick = {position ->
            val gson by lazy { Gson() }
            findNavController().navigate(
                CatalogFragmentDirections.actionCatalogFragmentToProductItemFragment(
                    toJson(data[position])
                )
            )
        }
        binding.rvProductCatalog.adapter = adapter
        binding.tvPageNumber.text = "${(offset/ countPerPage)+1}"
    }

    /**
     * определение клик литенеров
     */
    private fun prepareClickListeners(){

        /* Пангинацию можно было и лучше сделать, но в задаче не
         * сказано какую сделать пангинацию, поэтому сделал самую простую :)
         */
        binding.ibBackPage.setOnClickListener {
            if (offset - countPerPage >= 0) {
                offset -= countPerPage
                viewModel.getProducts(
                    offset = offset,
                    countPetPage = countPerPage
                )
                binding.rvProductCatalog.smoothScrollToPosition(0)
            }else{
                //тут было бы лучше видно, еслиб я шарил в дизайне :)
                binding.ibBackPage.isEnabled = false
            }
        }

        binding.ibForwardPage.setOnClickListener {
            if (offset+ countPerPage < totalProducts) {
                offset += countPerPage
                viewModel.getProducts(
                    offset = offset,
                    countPetPage = countPerPage
                )
                binding.rvProductCatalog.smoothScrollToPosition(0)
            }else{
                //тут было бы лучше видно, еслиб я шарил в дизайне :)
                binding.ibForwardPage.isEnabled = false
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    companion object {
        private const val countPerPage = 20
    }


}