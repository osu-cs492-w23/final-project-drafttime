package com.example.drafttime.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.connectedweather.R
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.ListView
import androidx.fragment.app.viewModels
import com.example.drafttime.data.Player
import com.example.drafttime.data.MyState
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.snackbar.Snackbar
import io.colyseus.Client
import kotlin.random.Random


class DraftTimeVsFragment : Fragment(R.layout.draft_time_vs_fragment) {


    private val client = Client("ws://10.0.2.2:4166")
    var player1: String? = null
    var player2: String? = null
    var numJoined = 0
    var joinRoomError = 0
    private lateinit var loadingIndicator: CircularProgressIndicator
    private val viewModel: PlayerInfoViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            val client = Client("ws://10.0.2.2:4166")
            //Log.d("MainActivity", "Player 1: $player1")
            //Log.d("MainActivity", "Player 2: $player2")
        var qb = ""
        var rb1 = ""
        var rb2 = ""
        var te = ""
        var wr1 = ""
        var wr2 = ""
        var flex_1 =""
        var flex_2 = ""

        viewModel.userQB.observe(viewLifecycleOwner){userQb ->
            qb = userQb[0].fullName

        }
        viewModel.userRB.observe(viewLifecycleOwner){userRb ->
            rb1 = userRb[0].fullName
            rb2 = userRb[1].fullName

        }
        viewModel.userWR.observe(viewLifecycleOwner){userWR ->
            wr1 = userWR[0].fullName
            wr2 = userWR[1].fullName
        }

        viewModel.userTE.observe(viewLifecycleOwner){userTE->
            te = userTE[0].fullName
        }
        viewModel.userPlayers.observe(viewLifecycleOwner){userFlex1 ->
            val index = Random.nextInt(0,  userFlex1.size)

            flex_1 = userFlex1[index].fullName
        }
        viewModel.userPlayers.observe(viewLifecycleOwner){userFlex2 ->
            val index = Random.nextInt(0,  userFlex2.size)

            flex_2 = userFlex2[index].fullName
        }

            val joinRoomBtn = view.findViewById<Button>(R.id.join_draftroom_button)
            loadingIndicator = view.findViewById(R.id.loading_indicator)
            loadingIndicator.visibility = View.INVISIBLE

            // Initial values
            val p1qb = Player("QB", "Patrick Mahomes", (1..40).random())
            val p1rb1 = Player("RB1", "Isiah Pacheco", (1..40).random())
            val p1rb2 = Player("RB2", "Clyde Edwards", (1..40).random())
            val p1wr1 = Player("WR1", "Skyy Moore", (1..40).random())
            val p1wr2 = Player("WR2", "Ihmir Smith", (1..40).random())
            val p1te = Player("TE", "Travis Kelce", (1..40).random())
            val p1flex1 = Player("FLEX1", "Jawaan Taylor", (1..40).random())
            val p1flex2 = Player("FLEX2", "Leo Chenal", (1..40).random())


            val p2qb = Player("QB", "Matthew Stafford", (1..40).random())
            val p2rb1 = Player("RB1", "Josh Jacobs", (1..40).random())
            val p2rb2 = Player("RB2", "Saquon Barkley", (1..40).random())
            val p2wr1 = Player("WR1", "Ceedee Lamb", (1..40).random())
            val p2wr2 = Player("WR2", "Justin Jefferson", (1..40).random())
            val p2te = Player("TE", "Travis Kelce", (1..40).random())
            val p2flex1 = Player("FLEX1", "Nick Bosa", 18)
            val p2flex2 = Player("FLEX2", "TJ Watt", 27)

            // holds positions that have been picked already
            val p1objArr = mutableListOf<String>()
            val p2objArr = mutableListOf<String>()

            var arrayAdapter1: ArrayAdapter<*>
            var arrayAdapter2: ArrayAdapter<*>
            var arrayAdapterPosition: ArrayAdapter<*>

            var arrayAdapterU1Score: ArrayAdapter<*>
            var arrayAdapterU2Score: ArrayAdapter<*>
            var arrayAdapterWeek: ArrayAdapter<*>

            var user1Total = 0
            var user2Total = 0
            var week = (1..17).random()
            var round = 1

            var user1Picked = false
            var user2Picked = false

            // Replace players array with player obj returned from API and print name + score for that week
            var players1 = arrayOf(
                "Total: " + user1Total,
                p1qb.name + "\nScore: " + p1qb.score,
                p1rb1.name + "\nScore: " + p1rb1.score,
                p1rb2.name + "\nScore: " + p1rb2.score,
                p1wr1.name + "\nScore: " + p1wr1.score,
                p1wr2.name + "\nScore: " + p1wr2.score,
                p1te.name + "\nScore: " + p1te.score,
                p1flex1.name + "\nScore: " + p1flex1.score,
                p1flex2.name + "\nScore: " + p1flex2.score,
            )

            var players2 = arrayOf(
                "Total: " + user2Total,
                p2qb.name + "\nScore: " + p2qb.score,
                p2rb1.name + "\nScore: " + p2rb1.score,
                p2rb2.name + "\nScore: " + p2rb2.score,
                p2wr1.name + "\nScore: " + p2wr1.score,
                p2wr2.name + "\nScore: " + p2wr2.score,
                p2te.name + "\nScore: " + p2te.score,
                p2flex1.name + "\nScore: " + p2flex1.score,
                p2flex2.name + "\nScore: " + p2flex2.score,
            )

            // Holds the Positions and week for middle list view
            var positions =
                arrayOf("Week: " + week, "QB", "RB1", "RB2", "WR1", "WR2", "TE", "FLEX1", "FLEX2")
            val u1Score = arrayOf(user1Total)
            val u2Score = arrayOf(user2Total)
            val weekArr = arrayOf(week)

            val user1LV = view.findViewById<ListView>(R.id.user1_LV)
            user1LV.visibility = View.INVISIBLE

            val user2LV = view.findViewById<ListView>(R.id.user2_LV)
            user2LV.visibility = View.INVISIBLE

            val positionLV = view.findViewById<ListView>(R.id.position_LV)
            positionLV.visibility = View.INVISIBLE

            // adapters linked to the arrays defined above i.e(players1)
            arrayAdapter1 = ArrayAdapter(
                requireContext(),
                R.layout.player_item, R.id.player_TV, players1
            )

            arrayAdapter2 = ArrayAdapter(
                requireContext(),
                R.layout.player_item, R.id.player_TV, players2
            )

            arrayAdapterPosition = ArrayAdapter(
                requireContext(),
                R.layout.position_item, positions
            )

            // set list view adapters
            user1LV.adapter = arrayAdapter1
            user2LV.adapter = arrayAdapter2
            positionLV.adapter = arrayAdapterPosition

            val u1ScoreLV = view.findViewById<ListView>(R.id.user1_score_LV)
            u1ScoreLV.visibility = View.INVISIBLE

            val u2ScoreLV = view.findViewById<ListView>(R.id.user2_score_LV)
            u2ScoreLV.visibility = View.INVISIBLE

            val weekLV = view.findViewById<ListView>(R.id.week_LV)
            weekLV.visibility = View.INVISIBLE

            arrayAdapterU1Score = ArrayAdapter(
                requireContext(),
                R.layout.player_item, R.id.player_TV, u1Score
            )

            arrayAdapterU2Score = ArrayAdapter(
                requireContext(),
                R.layout.player_item, R.id.player_TV, u2Score
            )

            arrayAdapterWeek = ArrayAdapter(
                requireContext(),
                R.layout.position_item, weekArr
            )

            u1ScoreLV.adapter = arrayAdapterU1Score
            u2ScoreLV.adapter = arrayAdapterU2Score
            weekLV.adapter = arrayAdapterWeek

            // listener for p1 pick (Must pick first before p2)
            user1LV.setOnItemClickListener { adapterView, view, i, l ->
                val score: Int = players1[i].filter { it.isDigit() }.toInt()
                if (user1Picked == false) {
                    if (p1objArr.contains(positions[i])) {
                        println("Already picked")
                        Snackbar.make(
                            view,
                            "${positions[i]} already picked",
                            Snackbar.LENGTH_LONG
                        ).show()

                    } else {
                        user1Total += score
                        user1Picked = true
                        p1objArr.add(positions[i])

                        Log.d("MainActivity", "${players1[i].filter { it.isDigit() }} clicked")
                        Snackbar.make(
                            view,
                            "User 1 picked: ${players1[i]}",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
            }

            // listener for p2 pick (Must pick after p1)
            user2LV.setOnItemClickListener { adapterView, view, i, l ->
                val score: Int = players2[i].filter { it.isDigit() }.toInt()
                if (!user2Picked) {
                    if (p2objArr.contains(positions[i])) {
                        println("Already picked")
                        Snackbar.make(
                            view,
                            "${positions[i]} already picked",
                            Snackbar.LENGTH_LONG
                        ).show()

                    } else {
                        user2Total += score
                        user2Picked = true
                        p2objArr.add(positions[i])

                        Log.d("MainActivity", "${players2[i].filter { it.isDigit() }} clicked")
                        Snackbar.make(
                            view,
                            "User 2 picked: ${players2[i]}",
                            Snackbar.LENGTH_LONG
                        ).show()
                    }
                }
                // once they both pick for this round, execute
                if (user1Picked && user2Picked) {
                    //if the last pick is in then show who won as a snackbar
                    if (round == 8) {
                        if (user1Total > user2Total) {
                            Snackbar.make(
                                view,
                                "User 1 wins!",
                                Snackbar.LENGTH_LONG
                            ).show()
                        } else if (user2Total > user1Total) {
                            Snackbar.make(
                                view,
                                "User 2 wins!",
                                Snackbar.LENGTH_LONG
                            ).show()
                        } else {
                            Snackbar.make(
                                view,
                                "It's a tie!",
                                Snackbar.LENGTH_LONG
                            ).show()
                        }
                    }
                    // if it's not the last round reset the scores for a new week
                    else {
                        // if they both picked, update the week, players, and adpater
                        var newWeek = (1..17).random()
                        while (newWeek == week) {
                            newWeek = (1..17).random()
                        }
                        week = newWeek

                        p1qb.score = (0..40).random()
                        p1rb1.score = (0..40).random()
                        p1rb2.score = (0..40).random()
                        p1wr1.score = (0..40).random()
                        p1wr2.score = (0..40).random()
                        p1te.score = (0..40).random()
                        p1flex1.score = (0..40).random()
                        p1flex2.score = (0..40).random()

                        p2qb.score = (0..40).random()
                        p2rb1.score = (0..40).random()
                        p2rb2.score = (0..40).random()
                        p2wr1.score = (0..40).random()
                        p2wr2.score = (0..40).random()
                        p2te.score = (0..40).random()
                        p2flex1.score = (0..40).random()
                        p2flex2.score = (0..40).random()


                        players1 = arrayOf(
                            "Total: " + user1Total,
                            p1qb.name + "\nScore: " + p1qb.score,
                            p1rb1.name + "\nScore: " + p1rb1.score,
                            p1rb2.name + "\nScore: " + p1rb2.score,
                            p1wr1.name + "\nScore: " + p1wr1.score,
                            p1wr2.name + "\nScore: " + p1wr2.score,
                            p1te.name + "\nScore: " + p1te.score,
                            p1flex1.name + "\nScore: " + p1flex1.score,
                            p1flex2.name + "\nScore: " + p1flex2.score,
                        )

                        players2 = arrayOf(
                            "Total: " + user2Total,
                            p2qb.name + "\nScore: " + p2qb.score,
                            p2rb1.name + "\nScore: " + p2rb1.score,
                            p2rb2.name + "\nScore: " + p2rb2.score,
                            p2wr1.name + "\nScore: " + p2wr1.score,
                            p2wr2.name + "\nScore: " + p2wr2.score,
                            p2te.name + "\nScore: " + p2te.score,
                            p2flex1.name + "\nScore: " + p2flex1.score,
                            p2flex2.name + "\nScore: " + p2flex2.score,
                        )

                        positions = arrayOf(
                            "Week: " + week,
                            "QB",
                            "RB1",
                            "RB2",
                            "WR1",
                            "WR2",
                            "TE",
                            "FLEX1",
                            "FLEX2"
                        )

                        arrayAdapter1 = ArrayAdapter(
                            requireContext(),
                            R.layout.player_item, R.id.player_TV, players1
                        )

                        arrayAdapter2 = ArrayAdapter(
                            requireContext(),
                            R.layout.player_item, R.id.player_TV, players2
                        )

                        arrayAdapterPosition = ArrayAdapter(
                            requireContext(),
                            R.layout.position_item, positions
                        )

                        user1LV.adapter = arrayAdapter1
                        user2LV.adapter = arrayAdapter2
                        positionLV.adapter = arrayAdapterPosition

                        arrayAdapterU1Score = ArrayAdapter(
                            requireContext(),
                            R.layout.player_item, R.id.player_TV, u1Score
                        )

                        arrayAdapterU2Score = ArrayAdapter(
                            requireContext(),
                            R.layout.player_item, R.id.player_TV, u2Score
                        )

                        arrayAdapterWeek = ArrayAdapter(
                            requireContext(),
                            R.layout.position_item, weekArr
                        )

                        u1ScoreLV.adapter = arrayAdapterU1Score
                        u2ScoreLV.adapter = arrayAdapterU2Score
                        weekLV.adapter = arrayAdapterWeek

                        // reset bool values for another week
                        user1Picked = false
                        user2Picked = false
                        round += 1
                    }
                }
            }


            // listener for the join room button at the beginning
            joinRoomBtn.setOnClickListener {
                println("Join Draft Room Button clicked!")
                loadingIndicator.visibility = View.VISIBLE
                if (numJoined < 2) {
                    joinRoom(client)
                    if (joinRoomError == 0) {
                        numJoined += 1
                    }
                }
                // Once two users have joined, remove button and show list view of each team
                if (numJoined == 2) {
                    joinRoomBtn.visibility = View.INVISIBLE
                    loadingIndicator.visibility = View.INVISIBLE
                    user1LV.visibility = View.VISIBLE
                    user2LV.visibility = View.VISIBLE
                    positionLV.visibility = View.VISIBLE
                }
            }
        }

        // function that joins the room server until 2 people are in
        fun joinRoom(client: Client) {
            if (numJoined < 2) {
                client.joinOrCreate(MyState::class.java, "my_room", callback = { room ->
                    with(room) {
                        println("connected to $name")
                        println("$sessionId joined.")
                        joinRoomError = 0

                        state.onRemove = {
                            println("state.onRemove")
                        }

                        onLeave = { code ->
                            println("onLeave $code")
                            numJoined -= 1
                        }
                        onError = { code, message ->
                            println("onError")
                            println(code)
                            println(message)
                        }

                        onStateChange = { state, _ ->
//                    println("state.boo = ${state.boo}")
                        }
                    }
                }, onError = { e ->
                    println("On error")
                    joinRoomError = 1
                    e.printStackTrace()
                })
            }

            readLine()
        }
}

