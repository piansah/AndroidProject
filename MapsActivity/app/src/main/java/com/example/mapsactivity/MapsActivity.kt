package com.example.mapsactivity

import android.app.DownloadManager.Query
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.mapsactivity.databinding.ActivityMapsBinding
import java.io.IOError
import java.io.IOException

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.SearchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String): Boolean {
                searchLocation(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

        })
    }

    private fun searchLocation(query: String) {
        val geocoder = Geocoder(this)
        var addressList: List<Address>? = null

        try {
            addressList = geocoder.getFromLocationName(query, 1)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        if (addressList != null && addressList.isNotEmpty()) {
            val address = addressList[0]
            val latLng = LatLng(address.latitude, address.longitude)

            mMap.addMarker(MarkerOptions().position(latLng).title(query))
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
        }else{
            Toast.makeText(this, "Location not found", Toast.LENGTH_LONG).show()
        }
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

     override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Majalengka and move the camera
        val majalengka = LatLng(-6.8497, 108.2273)
        mMap.addMarker(MarkerOptions().position(majalengka).title("Marker in Majalengka"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(majalengka, 10f))
     }
}














