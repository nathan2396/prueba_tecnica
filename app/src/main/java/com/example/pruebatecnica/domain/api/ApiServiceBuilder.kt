package com.example.pruebatecnica.domain.api

abstract class ApiServiceBuilder<T : Any> : ConnectionManager() {

    abstract fun build(): T

    fun setBaseUrl(baseUrl: String) {
        client.apply {
            updateRetrofitApi(baseUrl, getInterceptor())
        }
    }

}