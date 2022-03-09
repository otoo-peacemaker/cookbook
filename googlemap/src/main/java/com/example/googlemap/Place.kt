package com.example.googlemap

import com.google.android.gms.maps.model.LatLng

/**
 *@author created by Peacemaker
 * This code invokes the read()
 * method on a PlacesReader, which returns a List<Place>.
 * A Place has a property called name, the name of the place, and a latLng—the
 * coordinates where the place is located.
 * */

/**
 * @params name, the name the place
 * @param latLng, the coordinates where the place is located
 * @param address, the address of the latLng
 * @param rating, the rating of the place.
 * */
data class Place(
    val name: String,
    val latLng: LatLng,
    val address: String,
    val rating: Float
)
