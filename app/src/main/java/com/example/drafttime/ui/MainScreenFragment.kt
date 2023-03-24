package com.example.drafttime.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.connectedweather.R

class MainScreenFragment : Fragment(R.layout.main_screen) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val view_team_btn = view.findViewById<Button>(R.id.view_team_button)
        val draft_now_btn = view.findViewById<Button>(R.id.draft_now_button)
        val vs_btn = view.findViewById<Button>(R.id.vs_button)
        val fantasy_football_btn = view.findViewById<Button>(R.id.go_to_sleeper)


        ///View Team button listener
        view_team_btn?.setOnClickListener {

            val directions = MainScreenFragmentDirections.navigationToDraftView()
            findNavController().navigate(directions)

        }
        ///Draft now button listener
        draft_now_btn?.setOnClickListener {

            val directions = MainScreenFragmentDirections.navigationToDraft()
            findNavController().navigate(directions)

        }
        ///VS Button listener
        vs_btn?.setOnClickListener {

            if(launchVS) {

                val directions = MainScreenFragmentDirections.navigationToVs()
                findNavController().navigate(directions)
            }else{
                Toast.makeText(requireContext(),
                    "VS Disabled, Incomplete Team",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        //Go to sleeper implement intent

        fantasy_football_btn?.setOnClickListener{
            val webIntent: Intent = Uri.parse("https://sleeper.com/").let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }
            startActivity(webIntent)
        }
    }

}