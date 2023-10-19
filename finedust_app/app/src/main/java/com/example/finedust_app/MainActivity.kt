package com.example.finedust_app

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.finedust_app.data.Repository
import com.example.finedust_app.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var cancellationTokenSourec:CancellationTokenSource?=null

    lateinit var binding: ActivityMainBinding
    private val scope = MainScope()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initVariables()
        requestLocationPermissions()
    }

    override fun onDestroy() {
        super.onDestroy()
        cancellationTokenSourec?.cancel()
        scope.cancel()
    }
    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        //접근 권한이 허용되었는지 확인하는 코드
        val locationPermissionGranted=
            requestCode== REQUEST_ACCESS_LOCATION_PERMISSIONS &&
                    grantResults[0]==PackageManager.PERMISSION_GRANTED

        if(!locationPermissionGranted){
            finish()
        }else{
            //fetchdata

            cancellationTokenSourec = CancellationTokenSource()
            fusedLocationProviderClient.getCurrentLocation(
                LocationRequest.PRIORITY_HIGH_ACCURACY,
                cancellationTokenSourec!!.token
            ).addOnSuccessListener { location->
                scope.launch {
                    val station = Repository.getNearbyMonitoringStation(longitude = location.longitude, latitude = location.latitude)?.stationName
                    binding.location.text = station
                }

            }

        }

    }
    private fun initVariables(){
        fusedLocationProviderClient=LocationServices.getFusedLocationProviderClient(this)
    }
    //런타임 상태에서 권한 요청
    private fun requestLocationPermissions(){
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
            ),
            REQUEST_ACCESS_LOCATION_PERMISSIONS
        )
    }

    companion object{
        private const val REQUEST_ACCESS_LOCATION_PERMISSIONS =100
    }

}