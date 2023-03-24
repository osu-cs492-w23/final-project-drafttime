package com.example.drafttime.ui

import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.connectedweather.R


var launchVS = false
class ViewTeamFragment : Fragment(R.layout.view_team_fragment) {

    lateinit var listView: ListView
    var adapterL: ListViewAdapter? = null
    private val viewModel: PlayerInfoViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listView = view.findViewById(R.id.listview_view_team)


        viewModel.userPlayers.observe(viewLifecycleOwner) { playerinfo ->
            adapterL = ListViewAdapter(requireContext(), playerinfo, viewModel)
            listView.adapter = adapterL


        }
        launchVS = true
        viewModel.userQB.observe(viewLifecycleOwner){playerQB->
            if(playerQB.size < 1){
                Toast.makeText(requireContext(),
                    "1 QB required",
                    Toast.LENGTH_SHORT
                ).show()
                launchVS = false

            }

        }
        viewModel.userRB.observe(viewLifecycleOwner){playerRB ->
            if(playerRB.size < 2){
                Toast.makeText(requireContext(),
                    "2 RB required",
                    Toast.LENGTH_SHORT
                ).show()
                launchVS = false

            }

        }
        viewModel.userWR.observe(viewLifecycleOwner){playerWR ->
            if(playerWR.size < 2){
                Toast.makeText(requireContext(),
                    "2 WR required",
                    Toast.LENGTH_SHORT
                ).show()
                launchVS = false

            }
        }
        viewModel.userTE.observe(viewLifecycleOwner){playerTE ->
            if(playerTE.size < 1){
                Toast.makeText(requireContext(),
                    "1 TE required",
                    Toast.LENGTH_SHORT
                ).show()
                launchVS = false

            }


    }

    }

}