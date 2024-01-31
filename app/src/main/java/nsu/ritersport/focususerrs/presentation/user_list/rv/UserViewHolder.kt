package nsu.ritersport.focususerrs.presentation.user_list.rv

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import nsu.ritersport.focususerrs.databinding.ItemUserBinding
import nsu.ritersport.focususerrs.domain.model.User

class UserViewHolder(
    private val binding: ItemUserBinding,
) : ViewHolder(binding.root) {
    fun bind(user: UserWrapper, onItemClicked: (String) -> Unit) =
        binding.run {
            nameText.text = user.name
            phoneText.text = user.phoneNumber
            addressText.text = user.address
            image.setImageURI(user.photo)
            root.setOnClickListener { onItemClicked(user.userId) }
        }
}