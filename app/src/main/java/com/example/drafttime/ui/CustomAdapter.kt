import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.connectedweather.R
import com.example.drafttime.data.PlayerInfo

class CustomAdapter() : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    var playerdata: List<PlayerInfo> = listOf()
    fun updatePlayer(playerInfo: Map<String, PlayerInfo>{
       playerdata = playerInfo?: listOf()
        notifyDataSetChanged()
    }
    // create new views
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
        val pPosition : TextView = itemView.findViewById(R.id.position)
        val pTeam: TextView = itemView.findViewById(R.id.team_name)

        fun bind(playerInfo: PlayerInfo) {
            pName.text = playerInfo.fullName
            pAge.text = playerInfo.age
            pPosition.text = playerInfo.postion
            pTeam.text = playerInfo.team

        }
    }
}
