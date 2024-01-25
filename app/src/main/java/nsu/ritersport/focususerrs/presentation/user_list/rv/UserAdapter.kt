package nsu.ritersport.focususerrs.presentation.user_list.rv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import nsu.ritersport.focususerrs.databinding.ItemUserBinding
import nsu.ritersport.focususerrs.domain.model.User

class UserAdapter(
    private val onItemClicked: (User) -> Unit,
) : Adapter<ViewHolder>() {

    var items: List<UserWrapper> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        (holder as UserViewHolder).bind(items[position], onItemClicked)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        UserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
}