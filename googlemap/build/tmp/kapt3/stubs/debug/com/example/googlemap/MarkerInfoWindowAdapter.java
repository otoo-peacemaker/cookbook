package com.example.googlemap;

import java.lang.System;

/**
 * @author Peacemaker Otoo
 * @param [getInfoContents()] Takes the contents of a place from the Place class
 * @constructor: [context] Takes the context or activity of a class where this method is implemented
 * @property[marker] provide a marker for the places
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/googlemap/MarkerInfoWindowAdapter;", "Lcom/google/android/gms/maps/GoogleMap$InfoWindowAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getInfoContents", "Landroid/view/View;", "marker", "Lcom/google/android/gms/maps/model/Marker;", "getInfoWindow", "p0", "googlemap_debug"})
public final class MarkerInfoWindowAdapter implements com.google.android.gms.maps.GoogleMap.InfoWindowAdapter {
    private final android.content.Context context = null;
    
    public MarkerInfoWindowAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View getInfoContents(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.Marker marker) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View getInfoWindow(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.model.Marker p0) {
        return null;
    }
}