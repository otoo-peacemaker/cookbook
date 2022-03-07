package com.example.googlemap

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.googlemap.databinding.ActivityMainBinding
import com.example.googlemap.googleplaces.PlacesSelection
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.LocationListener
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.widget.AutocompleteSupportFragment
import com.google.android.libraries.places.widget.listener.PlaceSelectionListener
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener,
    LocationListener {
    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMainBinding

    //    var client: FusedLocationProviderClient? = null
    private var mGoogleApiClient: GoogleApiClient? = null

    private val bottomSheetView by lazy {
        findViewById<ConstraintLayout>(R.id.design_bottom_sheet)
    }

    private lateinit var bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout?>

    private var autocompleteFragment: AutocompleteSupportFragment? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
         Places.initialize(applicationContext, getString(R.string.google_map_api))

        service = this.getSystemService(LOCATION_SERVICE) as LocationManager
        enabled = service!!.isProviderEnabled(LocationManager.GPS_PROVIDER)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Initialize the AutocompleteSupportFragment.
         autocompleteFragment = supportFragmentManager.findFragmentById(R.id.autocomplete_fragment)
                    as AutocompleteSupportFragment
        onPlaceSelectedListener()
        launchAutoCompleteActivity()

        mapFragment.getMapAsync { googleMap ->
            addMakers(googleMap)
            googleMap.setInfoWindowAdapter(MarkerInfoWindowAdapter(this))
        }

        binding.searchPlace.setOnClickListener {
            startActivity(Intent(this, PlacesSelection::class.java))
        }

        /*  val modalBottomSheet = StartRide()
          modalBottomSheet.show(supportFragmentManager, StartRide.TAG)*/

        val view: View? = findViewById(R.id.design_bottom_sheet)
        view?.post {
            bottomSheetBehavior = BottomSheetBehavior.from(view as ConstraintLayout)
            bottomSheetBehavior.setBottomSheetCallback(object :
                BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, state: Int) {
                    print(state)
                    when (state) {
                        BottomSheetBehavior.STATE_HIDDEN -> {
                            Toast.makeText(
                                this@MapsActivity,
                                "Show Bottom Sheet",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                        BottomSheetBehavior.STATE_EXPANDED ->
                            Toast.makeText(
                                this@MapsActivity,
                                "Close Bottom Sheet",
                                Toast.LENGTH_SHORT
                            ).show()
                        BottomSheetBehavior.STATE_COLLAPSED ->
                            Toast.makeText(
                                this@MapsActivity,
                                "Show Bottom Sheet",
                                Toast.LENGTH_SHORT
                            ).show()

                        BottomSheetBehavior.STATE_DRAGGING -> {
                        }
                        BottomSheetBehavior.STATE_SETTLING -> {
                        }
                        BottomSheetBehavior.STATE_HALF_EXPANDED -> {

                        }
                    }
                }

                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                }
            })
        }

        val sheetButton = view?.findViewById<ImageView>(R.id.expandable_icon)
        sheetButton?.setOnClickListener {
            expandCollapseSheet()
        }


    }


    /**
     * @places_property, load list of bicycle shop
     * Note: This property is declared as lazy so that
     * reading all the places from the file is
     * performed only when needed—right after the GoogleMap object is initialized
     * */
   /* private val places: List<Place> by lazy {
        PlacesReader(this).read()
    }*/

    /**
     * This property uses the predefined color [purple_200] in the app,
     * and uses that to tint the bicycle icon and return it as a [BitmapDescriptor]
     * */

    private val bicycleIcon: BitmapDescriptor by lazy {
        val color = ContextCompat.getColor(this, R.color.purple_200)
        BitmapHelper.vectorToBitmap(this, R.drawable.baseline_pedal_bike_black_24dp, color)
    }


    /**
     * @addMakerMethod
     * This method iterates through the list of places followed by invoking the addMarker()
     * method on the provided GoogleMap object.
     * The marker is created by instantiating a MarkerOptions object, which allows you to customize the marker itself.
     * In this case, the title and position of the marker is provided,
     * which represents the bicycle shop name and its coordinates, respectively.
     * */
    private fun addMakers(googleMap: GoogleMap) {
      /*  places.forEach { place ->
            val marker = googleMap.addMarker(
                MarkerOptions().title(place.name)
                    .position(place.latLng)
                    .icon(bicycleIcon)
            )
            marker?.tag = place
        }*/
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


    @SuppressLint("ObsoleteSdkInt")
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
//        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL

        /*    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                ) {
                    //Location Permission already granted
                    buildGoogleApiClient()
                    mMap.isMyLocationEnabled = true
                } else {
                    //Request Location Permission
                    checkLocationPermission()
                }
            } else {
                buildGoogleApiClient()
                mMap.isMyLocationEnabled = true
            }*/
        //add my Location Button on top-right side corner

        /*// Add a marker in Sydney and move the camera
        val amalitech = LatLng(4.8943, 1.7563)
        mMap.addMarker(MarkerOptions().position(amalitech).title("Amalitech Services"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(amalitech))*/


        Dexter.withContext(applicationContext)
            .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                    //   TODO("Not yet implemented")
                }

                override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                    Toast.makeText(
                        this@MapsActivity,
                        "Permission" + p0?.permissionName + "was denied",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                override fun onPermissionRationaleShouldBeShown(
                    p0: PermissionRequest?,
                    p1: PermissionToken?
                ) {
                    //     TODO("Not yet implemented")
                }

            }).check()
    }


    /* private fun checkLocationPermission() {
         if (ContextCompat.checkSelfPermission(
                 this,
                 Manifest.permission.ACCESS_FINE_LOCATION
             ) != PackageManager.PERMISSION_GRANTED
         ) {
             if (ActivityCompat.shouldShowRequestPermissionRationale(
                     this,
                     Manifest.permission.ACCESS_FINE_LOCATION
                 )
             ) {
                 AlertDialog.Builder(this)
                     .setTitle("Location Permission Needed")
                     .setMessage("This app needs the Location permission, please accept to use location functionality")
                     .setPositiveButton("OK", DialogInterface.OnClickListener { _, _ ->
                         ActivityCompat.requestPermissions(
                             this,
                             arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                             REQUEST_LOCATION_CODE
                         )
                     })
                     .create()
                     .show()

             } else ActivityCompat.requestPermissions(
                 this,
                 arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                 REQUEST_LOCATION_CODE
             )
         }
     }*/

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_LOCATION_CODE -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(
                            this,
                            Manifest.permission.ACCESS_FINE_LOCATION
                        ) == PackageManager.PERMISSION_GRANTED
                    ) {
                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient()
                        }
                        mMap.isMyLocationEnabled = true
                    }
                } else {
                    // permission denied, boo! Disable the functionality that depends on this permission.
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show()
                }
                return
            }
        }
    }

    @Synchronized
    fun buildGoogleApiClient() {
        mGoogleApiClient = GoogleApiClient.Builder(this)
            .addConnectionCallbacks(this)
            .addOnConnectionFailedListener(this)
            .addApi(LocationServices.API)
            .build()

        mGoogleApiClient!!.connect()
    }


    override fun onConnected(p0: Bundle?) {
        mLocationRequest = LocationRequest()
        mLocationRequest!!.interval = 1000
        mLocationRequest!!.fastestInterval = 1000
        mLocationRequest!!.priority = LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY

        // Check if enabled and if not send user to the GPS settings
        if (!enabled!!) {
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(intent)
        }
        // Check if permission is granted or not
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            mGoogleApiClient?.let {
                LocationServices.FusedLocationApi.requestLocationUpdates(
                    it,
                    mLocationRequest!!,
                    this
                )
            }
        }
    }

    override fun onConnectionSuspended(p0: Int) {
        //  TODO("Not yet implemented")
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        //TODO("Not yet implemented")
    }

    override fun onLocationChanged(location: Location) {
        mLastLocation = location
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker!!.remove()
        }

        //Place current location marker
        val latLng = LatLng(location.latitude, location.longitude)
        val markerOptions = MarkerOptions()


        // Add a marker in Sydney and move the camera
        //  val amalitech = LatLng(4.8943, 1.7563)
        markerOptions.position(latLng)
        mMap.addMarker(MarkerOptions().position(latLng).title("Amalitech Services"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
        mCurrLocationMarker = mMap.addMarker(markerOptions)


        /*  markerOptions.position(latLng)
          markerOptions.title("Current Position")
          markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))
          mCurrLocationMarker = mMap.addMarker(markerOptions)
          mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15f))*/
    }

    companion object {
        private var REQUEST_LOCATION_CODE = 101
        private var mLocationRequest: LocationRequest? = null
        private var enabled: Boolean? = null
        private var service: LocationManager? = null
        private var mCurrLocationMarker: Marker? = null
        private var mLastLocation: Location? = null



    }

    private fun expandCollapseSheet() {
        if (bottomSheetBehavior.state != BottomSheetBehavior.STATE_EXPANDED) {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            Toast.makeText(
                this@MapsActivity,
                "close Bottom Sheet",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            Toast.makeText(
                this@MapsActivity,
                "Show Bottom Sheet",
                Toast.LENGTH_SHORT
            ).show()
        }

    }

    private fun onPlaceSelectedListener(){
         // Specify the types of place data to return.
        autocompleteFragment?.setPlaceFields(listOf(Place.Field.ID, Place.Field.NAME))
        autocompleteFragment?.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onError(status: Status) {
                // TODO: Handle the error.
                Log.i("SELECTION ERR", "An error occurred: $status")
                Toast.makeText(applicationContext,""+status.toString(),Toast.LENGTH_LONG).show()
            }

            override fun onPlaceSelected(place: Place) {
                // TODO: Get info about the selected place.
                Log.i("SELECTION", "Place: ${place.name}, ${place.id}")
                Toast.makeText(applicationContext,""+ place.name+ place.latLng,Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun launchAutoCompleteActivity(){
        val  AUTOCOMPLETE_REQUEST_CODE = 1
        // Set the fields to specify which types of place data to
        // return after the user has made a selection.
        val fields = listOf(Place.Field.ID, Place.Field.NAME)

        // Start the autocomplete intent.
        val intent = Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY, fields)
            .build(this)
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE)
    }





}