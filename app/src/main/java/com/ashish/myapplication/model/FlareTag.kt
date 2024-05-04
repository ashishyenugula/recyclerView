package com.ashish.myapplication.model

import com.google.gson.annotations.SerializedName

data class FlareTag(
    @SerializedName("name") var name: String? = null,
    @SerializedName("bg_color_hex") var bgColorHex: String? = null,
    @SerializedName("text_color_hex") var textColorHex: String? = null
)
