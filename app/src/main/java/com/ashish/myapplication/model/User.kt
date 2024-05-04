package com.ashish.myapplication.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name") var name: String? = null,
    @SerializedName("username") var username: String? = null,
    @SerializedName("twitter_username") var twitterUsername: String? = null,
    @SerializedName("github_username") var githubUsername: String? = null,
    @SerializedName("user_id") var userId: Int? = null,
    @SerializedName("website_url") var websiteUrl: String? = null,
    @SerializedName("profile_image") var profileImage: String? = null,
    @SerializedName("profile_image_90") var profileImage90: String? = null
)
