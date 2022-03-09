package com.example.googlemap;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 92\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u00019B\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\u0006\u0010 \u001a\u00020\u001eJ\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\u0012\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0010\u0010&\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\'H\u0016J\u0010\u0010(\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020)H\u0016J\u0012\u0010*\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010%H\u0014J\u0010\u0010,\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cH\u0017J\b\u00100\u001a\u00020\u001eH\u0002J-\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020)2\u000e\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u000205042\u0006\u00106\u001a\u000207H\u0016\u00a2\u0006\u0002\u00108R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R#\u0010\u0014\u001a\n \u0015*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u000e\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/example/googlemap/MapsActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/google/android/gms/maps/OnMapReadyCallback;", "Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;", "Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;", "Lcom/google/android/gms/location/LocationListener;", "()V", "autocompleteFragment", "Lcom/google/android/libraries/places/widget/AutocompleteSupportFragment;", "bicycleIcon", "Lcom/google/android/gms/maps/model/BitmapDescriptor;", "getBicycleIcon", "()Lcom/google/android/gms/maps/model/BitmapDescriptor;", "bicycleIcon$delegate", "Lkotlin/Lazy;", "binding", "Lcom/example/googlemap/databinding/ActivityMainBinding;", "bottomSheetBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "bottomSheetView", "kotlin.jvm.PlatformType", "getBottomSheetView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "bottomSheetView$delegate", "mGoogleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "mMap", "Lcom/google/android/gms/maps/GoogleMap;", "addMakers", "", "googleMap", "buildGoogleApiClient", "expandCollapseSheet", "launchAutoCompleteActivity", "onConnected", "p0", "Landroid/os/Bundle;", "onConnectionFailed", "Lcom/google/android/gms/common/ConnectionResult;", "onConnectionSuspended", "", "onCreate", "savedInstanceState", "onLocationChanged", "location", "Landroid/location/Location;", "onMapReady", "onPlaceSelectedListener", "onRequestPermissionsResult", "requestCode", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "googlemap_debug"})
public final class MapsActivity extends androidx.appcompat.app.AppCompatActivity implements com.google.android.gms.maps.OnMapReadyCallback, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener, com.google.android.gms.location.LocationListener {
    private com.google.android.gms.maps.GoogleMap mMap;
    private com.example.googlemap.databinding.ActivityMainBinding binding;
    private com.google.android.gms.common.api.GoogleApiClient mGoogleApiClient;
    private final kotlin.Lazy bottomSheetView$delegate = null;
    private com.google.android.material.bottomsheet.BottomSheetBehavior<androidx.constraintlayout.widget.ConstraintLayout> bottomSheetBehavior;
    private com.google.android.libraries.places.widget.AutocompleteSupportFragment autocompleteFragment;
    
    /**
     * This property uses the predefined color [purple_200] in the app,
     * and uses that to tint the bicycle icon and return it as a [BitmapDescriptor]
     */
    private final kotlin.Lazy bicycleIcon$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.googlemap.MapsActivity.Companion Companion = null;
    private static int REQUEST_LOCATION_CODE = 101;
    private static com.google.android.gms.location.LocationRequest mLocationRequest;
    private static java.lang.Boolean enabled;
    private static android.location.LocationManager service;
    private static com.google.android.gms.maps.model.Marker mCurrLocationMarker;
    private static android.location.Location mLastLocation;
    
    public MapsActivity() {
        super();
    }
    
    private final androidx.constraintlayout.widget.ConstraintLayout getBottomSheetView() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * This property uses the predefined color [purple_200] in the app,
     * and uses that to tint the bicycle icon and return it as a [BitmapDescriptor]
     */
    private final com.google.android.gms.maps.model.BitmapDescriptor getBicycleIcon() {
        return null;
    }
    
    /**
     * @addMakerMethod
     * This method iterates through the list of places followed by invoking the addMarker()
     * method on the provided GoogleMap object.
     * The marker is created by instantiating a MarkerOptions object, which allows you to customize the marker itself.
     * In this case, the title and position of the marker is provided,
     * which represents the bicycle shop name and its coordinates, respectively.
     */
    private final void addMakers(com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @android.annotation.SuppressLint(value = {"ObsoleteSdkInt"})
    @java.lang.Override()
    public void onMapReady(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.maps.GoogleMap googleMap) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @kotlin.jvm.Synchronized()
    public final synchronized void buildGoogleApiClient() {
    }
    
    @java.lang.Override()
    public void onConnected(@org.jetbrains.annotations.Nullable()
    android.os.Bundle p0) {
    }
    
    @java.lang.Override()
    public void onConnectionSuspended(int p0) {
    }
    
    @java.lang.Override()
    public void onConnectionFailed(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.common.ConnectionResult p0) {
    }
    
    @java.lang.Override()
    public void onLocationChanged(@org.jetbrains.annotations.NotNull()
    android.location.Location location) {
    }
    
    private final void expandCollapseSheet() {
    }
    
    private final void onPlaceSelectedListener() {
    }
    
    private final void launchAutoCompleteActivity() {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/googlemap/MapsActivity$Companion;", "", "()V", "REQUEST_LOCATION_CODE", "", "enabled", "", "Ljava/lang/Boolean;", "mCurrLocationMarker", "Lcom/google/android/gms/maps/model/Marker;", "mLastLocation", "Landroid/location/Location;", "mLocationRequest", "Lcom/google/android/gms/location/LocationRequest;", "service", "Landroid/location/LocationManager;", "googlemap_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}