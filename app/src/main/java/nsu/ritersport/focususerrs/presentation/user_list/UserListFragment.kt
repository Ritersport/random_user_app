package nsu.ritersport.focususerrs.presentation.user_list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import nsu.ritersport.focususerrs.databinding.FragmentListBinding
import nsu.ritersport.focususerrs.presentation.base.view.BaseFragment
import nsu.ritersport.focususerrs.presentation.base.view.viewBinding
import nsu.ritersport.focususerrs.presentation.user_list.rv.UserAdapter

class UserListFragment : BaseFragment() {
    override val binding by viewBinding { inflater, container ->
        FragmentListBinding.inflate(inflater, container, false)
    }
    override val viewModel: UserListViewModel by viewModels()

    private val userAdapter by lazy {
        UserAdapter(
            viewModel::onItemClicked
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvUsers.adapter = userAdapter
    }
}