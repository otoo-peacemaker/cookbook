package com.example.googlemap

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

/**@author Peacemaker Otoo
 * @param [getInfoContents()] Takes the contents of a place from the Place class
 * @constructor: [context] Takes the context or activity of a class where this method is implemented
 * @property[marker] provide a marker for the places
 *
 * */


class MarkerInfoWindowAdapter(
    private val context: Context
) : GoogleMap.InfoWindowAdapter {
    override fun getInfoContents(marker: Marker): View? {
        // 1. Get tag
        val place = marker.tag as? Place ?: return null

        // 2. Inflate view and set title, address, and rating
        val view = LayoutInflater.from(context).inflate(
            R.layout.marker_info_contents, null
        )
        view.findViewById<TextView>(
            R.id.text_view_title
        ).text = place.name
        view.findViewById<TextView>(
            R.id.text_view_address
        ).text = place.address.toString()
        view.findViewById<TextView>(
            R.id.text_view_rating
        ).text = context.getString(R.string.rating).format(place.rating)

        return view
    }


    override fun getInfoWindow(p0: Marker): View? {
        // Return null to indicate that the
        // default window (white bubble) should be used
        return null
    }

}