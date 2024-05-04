package com.ashish.myapplication.model

import com.google.gson.annotations.SerializedName

data class Organization(

    @SerializedName("name"             ) var name           : String? = null,
    @SerializedName("username"         ) var username       : String? = null,
    @SerializedName("slug"             ) var slug           : String? = null,
    @SerializedName("profile_image"    ) var profileImage   : String? = null,
    @SerializedName("profile_image_90" ) var profileImage90 : String? = null
)
