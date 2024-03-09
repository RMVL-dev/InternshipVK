package com.example.intershipvk.ui.catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.intershipvk.data.Response
import com.example.intershipvk.di.interfaces.ProductsRepository
import com.example.intershipvk.ui.ResponseState
import kotlinx.coroutines.launch

class CatalogViewModel(private val repository: ProductsRepository):ViewModel() {

    private var _productLiveData  = MutableLiveData<ResponseState<Response>>()
    val productLiveData:LiveData<ResponseState<Response>>
        get() = _productLiveData

    fun getProducts(
        offset:Int,
        countPetPage:Int
    ){
        _productLiveData.postValue(ResponseState.Loading())
        viewModelScope.launch {
            _productLiveData.value = try {
                ResponseState.Success(
                    repository.getProducts(offset = offset, limit = countPetPage)
                )
            }catch (e:Exception){
                e.printStackTrace()
                ResponseState.Error()
            }
        }
    }

}