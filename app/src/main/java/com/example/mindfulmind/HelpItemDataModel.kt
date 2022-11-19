package com.example.mindfulmind

import com.google.gson.annotations.SerializedName

data class HelpItemDataModel(
    @SerializedName("businesses") val therapists: List<Therapist>
)
data class Therapist(
    @SerializedName("name") val name: String,
    @SerializedName("rating") val rating: Float,
    @SerializedName("phone") val phoneNumber: String,
    @SerializedName("distance") val distance: Double,
    @SerializedName("url") val websiteLink: String,
    @SerializedName("image_url") val image_url: String,
    val location: Location
    ){
    fun getDistance(): String{
        val milesPerMeter = 0.000621371
        val distanceInMiles = (distance*milesPerMeter).toInt()
        return "${distanceInMiles} mi"
    }
}
data class Location(
    @SerializedName("address1") val address: String
)