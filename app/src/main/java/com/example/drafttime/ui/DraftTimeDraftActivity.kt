package com.example.drafttime.ui


import CustomAdapter
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.connectedweather.R
import com.example.drafttime.api.ConnectedSleeper
import com.example.drafttime.data.PlayerInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var change = false

val team = ArrayList<PlayerInfo?>()

class DraftTimeDraftActivity : AppCompatActivity() {
    private val sleeperConnect = ConnectedSleeper.create()
    private val viewModel: PlayerInfoViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_draft_time_draft)
        //TODO: Create recycler view
        title = "Generate Team"

        //Get view for recycler adapter
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)
        //Layout manager
        recyclerview.layoutManager = LinearLayoutManager(this)
        //Set fixed size
        recyclerview.setHasFixedSize(true)
        //recyclerview.adapter = playerAdapter

        //View to find button
        val generate_team_btn = findViewById<Button>(R.id.generate_team_btn)

        //Click listener fot generate team button
        generate_team_btn.setOnClickListener {

            //TODO: Invole call to generate a team
            println("GENERATE TEAM WAS CLICKED ")

            sleeperConnect.getPlayerData()


                .enqueue(object : Callback<List<List<PlayerInfo>>> {
                    override fun onResponse(
                        call: Call<List<List<PlayerInfo>>>,
                        response: Response<List<List<PlayerInfo>>>
                    ) {
                        ///Need to hook up adapter to this part of the response
                        if (response.isSuccessful) {


                            Log.d("Response", "onResponse: ${response.body()}")
                            //TODO: Adapter and recycler view should go here
                            val adapter = CustomAdapter(response.body()!!, viewModel)
                            recyclerview.adapter = adapter


                        }
                    }

                    override fun onFailure(call: Call<List<List<PlayerInfo>>>, t: Throwable) {
                        Log.d("Draft time Activity ", "onFailure: " + t.message)
                    }
                })
        }
    }
    fun addDatabase(player: PlayerInfo?) {
        if (player != null) {
            viewModel.addPlayer(player)
        }
    }
}








