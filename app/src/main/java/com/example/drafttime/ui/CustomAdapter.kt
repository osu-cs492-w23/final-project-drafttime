import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.connectedweather.R
import com.example.drafttime.data.PlayerInfo
import com.example.drafttime.ui.PlayerInfoViewModel
import kotlin.random.Random


class CustomAdapter(val playerdata: List<List<PlayerInfo?>>, val viewModel: PlayerInfoViewModel) :

    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view

        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.team_list_view, parent, false)

        return ViewHolder(view, viewModel)
    }


    override fun getItemCount(): Int {
        return playerdata.size
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        this.playerdata[position]?.let { holder.bind(it, position) }

        // sets the image to the imageview from our itemHolder class

    }

    // return the number of the items in the list
    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View, viewModel: PlayerInfoViewModel) :
        RecyclerView.ViewHolder(ItemView) {


        val pName: TextView = itemView.findViewById(R.id.name)
        val pAge: TextView = itemView.findViewById(R.id.age)
        var pPosition: TextView = itemView.findViewById(R.id.position)
        val pTeam: TextView = itemView.findViewById(R.id.team_name)
        val optionMenu: Button = itemView.findViewById(R.id.textViewOptions)
        var player: PlayerInfo? = null
        var adapterPos = 0


        ///Handle clicks from the user
        init {

            optionMenu.setOnClickListener {

                //TODO: Add to database instead of array

                //team.add(player)
                player?.let { it1 -> viewModel.addPlayer(it1) }
                Toast.makeText(
                    itemView.context,
                    "Player Added ${player?.fullName}",
                    Toast.LENGTH_SHORT
                ).show()


            }

        }

        fun bind(playerInfo: List<PlayerInfo?>, position: Int) {
            val value = Random.nextInt(0, 10)
            adapterPos = position
            player = playerInfo[value]
            pName.text = playerInfo[value]?.fullName
            pAge.text = playerInfo[value]?.age
            pPosition.text = playerInfo[value]?.postion
            pTeam.text = playerInfo[value]?.team


        }
    }
}


