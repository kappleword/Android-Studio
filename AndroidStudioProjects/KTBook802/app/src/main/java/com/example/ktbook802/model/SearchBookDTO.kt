package com.example.ktbook802.model

import com.google.gson.annotations.SerializedName

data class SearchBookDTO (
    @SerializedName("title") val title: String,
    @SerializedName("item") val id: List<Book>,
)