package com.example.googlemap;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b\u00a8\u0006\n"}, d2 = {"Lcom/example/googlemap/BitmapHelper;", "", "()V", "vectorToBitmap", "Lcom/google/android/gms/maps/model/BitmapDescriptor;", "context", "Landroid/content/Context;", "id", "", "color", "googlemap_debug"})
public final class BitmapHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.example.googlemap.BitmapHelper INSTANCE = null;
    
    private BitmapHelper() {
        super();
    }
    
    /**
     * @author Peacemaker Otoo
     *
     * Demonstrates converting a [Drawable] to a [BitmapDescriptor], for use as a marker icon on the mapp. Taken from ApiDemos on GitHub:
     * @see: https://github.com/googlemaps/android-samples/blob/main/ApiDemos/kotlin/app/src/main/java/com/example/kotlindemos/MarkerDemoActivity.kt
     * @param [id] takes resource id drawable icon file to display on the map
     * @param [color] the color of the icon
     * @param [context] application context or activity
     * @param [vectorToBitmap()] takes app context, icon by id and color of the icon
     *
     * @exception: Resource not found
     */
    @org.jetbrains.annotations.NotNull()
    public final com.google.android.gms.maps.model.BitmapDescriptor vectorToBitmap(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @androidx.annotation.DrawableRes()
    int id, @androidx.annotation.ColorInt()
    int color) {
        return null;
    }
}