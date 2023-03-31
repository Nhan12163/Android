package com.example.thigk2.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GK (
    @SerializedName("userId")
    @Expose
    var userId: Int?,
    @SerializedName("id")
    @Expose
    var id: Int?,
    @SerializedName("title")
    @Expose
    var title: String?,
    @SerializedName("completed")
    @Expose
    var completed: Boolean?,
){
}