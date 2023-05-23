package com.example.testecarrefour.response

import com.google.gson.annotations.SerializedName

data class UsersResponse(

    @SerializedName("login")
    var login: String = "",

    @SerializedName("id")
    val id: String = "",

    @SerializedName("node_id")
    val node_id: String = "",

    @SerializedName("avatar_url")
    val avatar_url: String = "",

    @SerializedName("type")
    val type: String = ""

)
