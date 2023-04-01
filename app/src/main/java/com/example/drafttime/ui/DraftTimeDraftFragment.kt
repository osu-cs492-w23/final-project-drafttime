package com.example.drafttime.ui


import CustomAdapter
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.connectedweather.R
import com.example.drafttime.api.ConnectedSleeper
import com.example.drafttime.data.PlayerInfo


class DraftTimeDraftFragment : Fragment(R.layout.draft_time_draft_fragment) {
    private val sleeperConnect = ConnectedSleeper.create()
    private val viewModel: PlayerInfoViewModel by viewModels()
    private val playerModel: DraftTimeViewModel by viewModels()
    private var data = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playerModel.loadPlayers()


        //Get view for recycler adapter
        val recyclerview = view.findViewById<RecyclerView>(R.id.recyclerview)
        //Layout manager
        recyclerview.layoutManager = LinearLayoutManager(requireContext())
        //Set fixed size
        recyclerview.setHasFixedSize(true)
        //View to find button
        val generate_team_btn = view.findViewById<Button>(R.id.generate_team_btn)

        //Click listener fot generate team button


        generate_team_btn.setOnClickListener {

            playerModel.results.observe(viewLifecycleOwner) { playerResults ->
                if(playerResults != null) {
                    val adapter = CustomAdapter(playerResults, viewModel)
                    recyclerview.adapter = adapter
                }

            }
        }

        }

    }








