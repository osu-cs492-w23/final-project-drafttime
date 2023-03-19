import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.connectedweather.R
import com.example.drafttime.data.PlayerInfo
import kotlin.random.Random


class CustomAdapter(val playerdata: List<List<PlayerInfo>>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.team_list_view, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return playerdata.size
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.playerdata[position])

        // sets the image to the imageview from our itemHolder class

    }

    // return the number of the items in the list

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {




        val pName: TextView= itemView.findViewById(R.id.name)
        val pAge: TextView = itemView.findViewById(R.id.age)
        var pPosition : TextView = itemView.findViewById(R.id.position)
        val pTeam: TextView = itemView.findViewById(R.id.team_name)
        var playerItem: PlayerInfo? = null

        ///Handle clicks from the user
        init {
            itemView.setOnClickListener {


                Log.d("ViewHolder" , "Clicked")

            }
        }

        fun bind(playerInfo: List<PlayerInfo>) {
            val value = Random.nextInt(0,10)

            pName.text = playerInfo[value].fullName
            pAge.text = playerInfo[value].age
            pPosition.text = playerInfo[value].postion
            pTeam.text = playerInfo[value].team



        }
    }
}
