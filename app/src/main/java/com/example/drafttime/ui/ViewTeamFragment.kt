package com.example.drafttime.ui

import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.connectedweather.R

class ViewTeamFragment : Fragment(R.layout.view_team_fragment) {

    lateinit var listView: ListView
    var adapterL: ListViewAdapter? = null
    private val viewModel: PlayerInfoViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById(R.id.listview_view_team)

        ///TODO:Create recyclerview adapater( Copy and paste from custom adapter)
        ///TODO: Pass data from data base into adapter
        ///TODO: Modify button to delete player from list
        ///TODO: Optional start another activity to to see the details of another activity

        ///View team recycler view

        viewModel.userPlayers.observe(viewLifecycleOwner) { playerinfo ->
            adapterL = ListViewAdapter(requireContext(), playerinfo, viewModel)
            listView.adapter = adapterL


        }
    }

}