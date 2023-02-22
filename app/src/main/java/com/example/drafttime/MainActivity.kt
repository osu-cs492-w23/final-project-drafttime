package com.example.drafttime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.connectedweather.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private val sleeperConnect = ConnectedSleeper.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    sleeperConnect.getPlayerData()


    .enqueue(object : Callback<PlayerData> {
        override fun onResponse(
            call: Call<PlayerData>,
            response: Response<PlayerData>
        ) {
            ///Need to hook up adapter to this part of the response
            if(response.isSuccessful) {
                Log.d("Response" , "onResponse: ${response.body()}")
               // forecastAdapter.updateForecast(response.body())
            }
        }
        override fun onFailure(call: Call<PlayerData>, t: Throwable) {
            Log.d("MainActivity","onFailure: "+t.message )
        }
    })

}}