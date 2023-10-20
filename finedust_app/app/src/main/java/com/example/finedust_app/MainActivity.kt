package com.example.finedust_app

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import com.example.finedust_app.data.Repository
import com.example.finedust_app.data.models.airquilty.AirQualityItems
import com.example.finedust_app.data.models.airquilty.Grade
import com.example.finedust_app.data.models.monitoringstation.MornitoringItems
import com.example.finedust_app.databinding.ActivityMainBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationToken
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.Exception

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
//    권한요청 처리 결과 수신
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
                    binding.errorDescriptionTextView.visibility=View.GONE
                    try {
                        Log.d("hch", "onRequestPermissionsResult: 성공")
                        val station = Repository.getNearbyMonitoringStation(longitude = location.longitude, latitude = location.latitude)
                        val measureValue =Repository.getLatestAirQualityData(station!!.stationName!!)
                        displayAirQualityData(station, measureValue!!)
                    }catch(exception: Exception){
                        Log.d("hch", "onRequestPermissionsResult: ${exception} ")
                        binding.errorDescriptionTextView.visibility = View.VISIBLE
                    }finally {
                        binding.progressBar.visibility= View.GONE
                        // 새로고침 완료시,
                        // 새로고침 아이콘이 사라질 수 있게 isRefreshing = false
                        binding.refresh.isRefreshing=false
                    }

                }

            }

        }

    }
    fun displayAirQualityData(monitoringStion : MornitoringItems, measuredValue : AirQualityItems) {
        Log.d("hch", "displayAirQualityData: ${monitoringStion},${measuredValue}")
        binding.meausringStationName.text=monitoringStion.stationName
        binding.measuringstationAddressTextView.text=monitoringStion.addr
        binding.contentsLayout.animate()
            .alpha(1f)
            .start()
        (measuredValue.khaiGrade ?: Grade.UNKNOWN).let {
            binding.totalGradeLabelTextView.text =it.label
            binding.totalGradeEmojiText.text = it.emoji
        }
        with(measuredValue){
            binding.fineDustInfomationTextView.text=
                "미세먼지: ${pm10Value} ${(pm10Grade?:Grade.UNKNOWN).emoji}"
            binding.ultrafineDustInfomationTextView.text=
                "초미세먼지: ${pm25Value}${(pm25Grade?:Grade.UNKNOWN).emoji}"

            with(binding.so2Item){
                labelTextView.text="아황산가스"
                gradeTextView.text=(so2Grade?:Grade.UNKNOWN).toString()
                valuewTextView.text=so2Value
            }
            with(binding.coItem){
                labelTextView.text="일산화탄소"
                gradeTextView.text=(coGrade?:Grade.UNKNOWN).toString()
                valuewTextView.text=coValue
            }
            with(binding.o32Item){
                labelTextView.text="오존"
                gradeTextView.text=(o3Grade?:Grade.UNKNOWN).toString()
                valuewTextView.text=o3Value
            }
            with(binding.no2Item){
                labelTextView.text="이산화질소"
                gradeTextView.text=(no2Grade?:Grade.UNKNOWN).toString()
                valuewTextView.text=no2Value
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