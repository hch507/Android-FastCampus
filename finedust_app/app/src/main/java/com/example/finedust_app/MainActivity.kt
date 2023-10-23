package com.example.finedust_app

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.finedust_app.data.dto.airquilty.AirQualityItems
import com.example.finedust_app.data.dto.airquilty.Grade
import com.example.finedust_app.data.dto.monitoringstation.MornitoringItems
import com.example.finedust_app.databinding.ActivityMainBinding
import com.example.finedust_app.domain.models.MeasureInfoState
import com.example.finedust_app.ui.MainViewModel
import com.example.finedust_app.ui.utils.FineDustUiState
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private var cancellationTokenSourec:CancellationTokenSource?=null


    lateinit var binding: ActivityMainBinding
    private val scope = MainScope()
    private val viewModel : MainViewModel by viewModels()

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
                        viewModel.getMeasureInfo(latitude = location.latitude, longitude = location.longitude)
                        Log.d("hch", "onRequestPermissionsResult: 성공")
                        repeatOnLifecycle(Lifecycle.State.STARTED){
                            viewModel.uiState.collectLatest {
                              when(it){
                                  is FineDustUiState.Success ->{
                                      Log.d("hch", "onRequestPermissionsResult:${it} ")
                                      displayAirQualityData(it.data)
                                  }
                                  else -> {

                                  }
                              }
                            }
                        }

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
    fun displayAirQualityData(measureInfo : MeasureInfoState?) {

        binding.measuringstationAddressTextView.text=measureInfo?.measureStationAddress
        binding.contentsLayout.animate()
            .alpha(1f)
            .start()

        binding.totalGradeLabelTextView.text = measureInfo?.totalGradeLabel?: "정보없음"
        binding.totalGradeEmojiText.text = measureInfo?.totalGradeEmoji


        binding.meausringStationName.text=measureInfo?.measureStationName ?: ""
        binding.measuringstationAddressTextView.text=measureInfo?.measureStationAddress
        binding.fineDustInfomationTextView.text=
            "미세먼지: ${measureInfo?.fineDustInfomation ?: " 정보 없음"}"
        binding.ultrafineDustInfomationTextView.text=
            "초미세먼지: ${measureInfo?.ultrafineDustInfomation ?: "정보없음"}"

        with(binding.so2Item){
            labelTextView.text="아황산가스"
            gradeTextView.text=(measureInfo?.so2Grade?:Grade.UNKNOWN).toString()
            valuewTextView.text=measureInfo?.so2Value ?: "정보 없음"
        }
        with(binding.coItem){
            labelTextView.text="일산화탄소"
            gradeTextView.text=(measureInfo?.coGrade?:Grade.UNKNOWN).toString()
            valuewTextView.text=measureInfo?.coValue?: "정보 없음"
        }
        with(binding.o32Item){
            labelTextView.text="오존"
            gradeTextView.text=(measureInfo?.o3Grade?:Grade.UNKNOWN).toString()
            valuewTextView.text=measureInfo?.o3Value ?:"정보 없음"
        }
        with(binding.no2Item){
            labelTextView.text="이산화질소"
            gradeTextView.text=(measureInfo?.no2Grade?:Grade.UNKNOWN).toString()
            valuewTextView.text=measureInfo?.no2Value ?: "정보 없음"
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