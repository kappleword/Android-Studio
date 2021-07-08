package com.example.ktbook801

import com.google.gson.annotations.SerializedName

data class SerchBookDTO (
    @SerializedName("title") val title: String,
    @SerializedName("item") val id: List<Book>,
)