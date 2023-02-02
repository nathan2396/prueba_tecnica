package com.example.pruebatecnica.domain

import com.example.pruebatecnica.domain.api.ApiServiceBuilder

interface CommentsApi {

    class Builder() : ApiServiceBuilder<CommentsApi>() {
        override fun build(): CommentsApi {
            return client.create(CommentsApi::class.java)
        }
    }

}