package com.example.drafttime.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.connectedweather.R
import com.example.drafttime.data.PlayerInfo

class ListViewAdapter(
    private val context: Context,
    val playerInfo: List<PlayerInfo>,
    val viewModel: PlayerInfoViewModel
) : BaseAdapter() {
    private lateinit var namel: TextView
    private lateinit var agel: TextView
    private lateinit var positionP: TextView
    private lateinit var teaml: TextView
    private lateinit var remove_btn: Button

    override fun getCount(): Int {
        return playerInfo.size
    }

    override fun getItem(position: Int): Any {
        return position
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {

        var convertView = convertView
        convertView = LayoutInflater.from(context).inflate(R.layout.view_team_list, parent, false)
        ///name
        namel = convertView.findViewById(R.id.view_name)
        namel.text = playerInfo[position].fullName
        ///age
        agel = convertView.findViewById(R.id.view_age)
        agel.text = playerInfo[position].age
        ///position
        positionP = convertView.findViewById(R.id.view_position)
        positionP.text = playerInfo[position].postion
        ///Team
        teaml = convertView.findViewById(R.id._view_team_name)
        teaml.text = playerInfo[position].team

        remove_btn = convertView.findViewById(R.id.remove_btn)

        remove_btn.setOnClickListener {
            Toast.makeText(
                context,
                "Player Removed ${playerInfo[position].fullName}",
                Toast.LENGTH_SHORT
            ).show()

            viewModel.deletePlayer(playerInfo[position])
        }
        return convertView
    }


}