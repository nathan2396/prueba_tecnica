package com.example.pruebatecnica.mvvm.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnica.data.dto.ProductDTO
import com.example.pruebatecnica.domain.api.RequestState
import com.example.pruebatecnica.mvvm.common.GenericActivity
import com.example.pruebatecnica.mvvm.common.ProductAdapter
import com.example.pruebatecnica.use_case.SearchProductsUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ProductListViewModel constructor(private val showProductsUseCase: SearchProductsUseCase) :ViewModel() {

    private val _loaderStatus = MutableLiveData<GenericActivity.LoadingView>()
    val loaderStatus : LiveData<GenericActivity.LoadingView> get() = _loaderStatus


    private val  _productsAdapter = MutableLiveData<ProductAdapter>()
    val productsAdapter : LiveData<ProductAdapter> get() = _productsAdapter

    private val _productList = MutableLiveData<MutableList<ProductDTO>>()
    val productList : LiveData<MutableList<ProductDTO>> get() = _productList


    fun initAdapter() {
        _productsAdapter.value = ProductAdapter(_productList.value ?: mutableListOf()){}
    }



    fun getProductList(coincidence:String? = null,onError: (message:String) ->Unit) {
        showProductsUseCase.getProductsList(coincidence = coincidence).onEach { products ->
            when (products) {
                is RequestState.Success -> {
                    _loaderStatus.value = GenericActivity.LoadingView.HIDE
                    _productList.value = products.data?.productsFoundDAO
                    _productsAdapter.value?.updateProductList(products.data?.productsFoundDAO!!)
                }
                is RequestState.Error -> {
                    _loaderStatus.value = GenericActivity.LoadingView.HIDE
                    onError(products.message!!)
                }
                is RequestState.Loading -> {
                    _loaderStatus.value = GenericActivity.LoadingView.SHOW
                }
            }

        }.launchIn(viewModelScope)
    }


}