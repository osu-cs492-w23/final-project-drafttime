package com.example.drafttime.ui

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.connectedweather.R
import com.example.drafttime.api.ConnectedSleeper
import com.example.drafttime.data.PlayerInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DraftTimeDraftActivity : AppCompatActivity() {
    private val sleeperConnect = ConnectedSleeper.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draft_time_draft)
        //TODO: Create recycler view

        val generate_team_btn = findViewById<Button>(R.id.generate_team_btn)


        generate_team_btn.setOnClickListener {

            //TODO: Invole call to generate a team
            println("GENERATE TEAM WAS CLICKED ")

            sleeperConnect.getPlayerData()


                .enqueue(object : Callback<Map<String, PlayerInfo>> {
                    override fun onResponse(
                        call: Call<Map<String, PlayerInfo>>,
                        response: Response<Map<String, PlayerInfo>>
                    ) {
                        ///Need to hook up adapter to this part of the response
                        if (response.isSuccessful) {
                            Log.d("Response", "onResponse: ${response.body()}")
                            //TODO: Adapter and recycler view should go here


                        }
                    }

                    override fun onFailure(call: Call<Map<String, PlayerInfo>>, t: Throwable) {
                        Log.d("Draft time Activity ", "onFailure: " + t.message)
                    }
                })
        }



    }
}