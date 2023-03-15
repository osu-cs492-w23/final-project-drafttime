package com.example.drafttime.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.connectedweather.R
import com.example.drafttime.data.PlayerData
import com.example.drafttime.api.ConnectedSleeper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class MainActivity : AppCompatActivity() {
    private val sleeperConnect = ConnectedSleeper.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //TODO: Add button listener here

        val view_team_btn= findViewById<Button>(R.id.view_team_button)
        val draft_now_btn = findViewById<Button>(R.id.draft_now_button)
        val vs_btn = findViewById<Button>(R.id.vs_button)


///TODO: Convert to view model to prevent reload if device is turned

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


        ///View Team button listener

        view_team_btn?.setOnClickListener {

            //Start view team activity

            val intent = Intent(this , ViewTeamActivity::class.java)
            startActivity(intent)
        }
        ///Draft now button listener

        draft_now_btn?.setOnClickListener {

            ///Start draft team activity

            val intent = Intent(this , DraftTimeDraftActivity::class.java)
            startActivity(intent)

        }

        ///VS Button listener
        vs_btn?.setOnClickListener {
            //Start VS activity
            val intent = Intent(this, DraftTimeDraftActivity::class.java)
            startActivity(intent)
        }


    }



}