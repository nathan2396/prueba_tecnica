package com.example.pruebatecnica.use_case

import com.example.pruebatecnica.data.dao.toDTO
import com.example.pruebatecnica.data.dto.ProductDTO
import com.example.pruebatecnica.data.dto.ProductFoundDTO
import com.example.pruebatecnica.domain.api.RequestState
import com.example.pruebatecnica.repository.ProductsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class SearchProductsUseCase constructor(val repository :ProductsRepository) {
    fun getProductsList(coincidence:String?) : Flow<RequestState<ProductFoundDTO>> = flow {
        try {
            emit(RequestState.Loading<ProductFoundDTO>())
            val response = repository.getProductList(coincidence = coincidence)
            if(response.code() in 200..299) {
                val productsFound = response?.body()?.productsFound?.toDTO
                emit(RequestState.Success<ProductFoundDTO>(productsFound!!))
            } else {
                emit(RequestState.Error<ProductFoundDTO>("Couldn't parse response"))
            }
        } catch (e: HttpException) {
            emit(RequestState.Error<ProductFoundDTO>(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(RequestState.Error<ProductFoundDTO>("Couldn't reach server. Check your internet connection."))
        }

    }

}