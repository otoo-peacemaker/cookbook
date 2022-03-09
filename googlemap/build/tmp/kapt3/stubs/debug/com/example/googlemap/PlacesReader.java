package com.example.googlemap;

import java.lang.System;

/**
 * @author Peacemaker
 * @constructor context, the application context or activity where this class would be called
 * Reads a list of place JSON objects from the file places.json
 */
@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/example/googlemap/PlacesReader;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gson", "Lcom/google/gson/Gson;", "inputStream", "Ljava/io/InputStream;", "getInputStream", "()Ljava/io/InputStream;", "read", "", "Lcom/example/googlemap/Place;", "googlemap_debug"})
public final class PlacesReader {
    private final android.content.Context context = null;
    private final com.google.gson.Gson gson = null;
    
    public PlacesReader(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    private final java.io.InputStream getInputStream() {
        return null;
    }
    
    /**
     * Reads the list of place JSON objects in the file places.json
     * and returns a list of Place objects
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.googlemap.Place> read() {
        return null;
    }
}