package com.example.drafttime.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import androidx.activity.viewModels
import com.example.connectedweather.R

class ViewTeamActivity : AppCompatActivity() {

    lateinit var listView: ListView
    var adapterL: ListViewAdapter? = null
    private val viewModel: PlayerInfoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_team)
        title = "View Team"
        listView = findViewById(R.id.listview_view_team)

        ///TODO:Create recyclerview adapater( Copy and paste from custom adapter)
        ///TODO: Pass data from data base into adapter
        ///TODO: Modify button to delete player from list
        ///TODO: Optional start another activity to to see the details of another activity

        ///View team recycler view

        viewModel.userPlayers.observe(this){playerinfo->
            adapterL = ListViewAdapter(this , playerinfo, viewModel)
            listView.adapter = adapterL


        }
    }

}