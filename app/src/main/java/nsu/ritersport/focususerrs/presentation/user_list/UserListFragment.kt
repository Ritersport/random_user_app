package nsu.ritersport.focususerrs.presentation.user_list

import android.os.Bundle
import android.os.Parcel
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import nsu.ritersport.focususerrs.R
import nsu.ritersport.focususerrs.databinding.FragmentListBinding
import nsu.ritersport.focususerrs.presentation.base.view.BaseFragment
import nsu.ritersport.focususerrs.presentation.base.view.viewBinding
import nsu.ritersport.focususerrs.presentation.user_datails.DetailsFragment
import nsu.ritersport.focususerrs.presentation.user_list.rv.MarginItemDecoration
import nsu.ritersport.focususerrs.presentation.user_list.rv.UserAdapter
import nsu.ritersport.focususerrs.presentation.user_list.rv.UserWrapper


private const val ITEM_MARGIN = 16

@AndroidEntryPoint
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
        setupView()
        setupViewListeners()
        setupVmObservers()
    }

    private fun setupVmObservers() {
        viewModel.users.observe(viewLifecycleOwner, ::onUsersLoaded)
        viewModel.navEvent.observe(viewLifecycleOwner, ::obtainNavEvent)
    }

    private fun setupView() {
        with(binding.rvUsers) {
            adapter = userAdapter
            addItemDecoration(MarginItemDecoration(ITEM_MARGIN))
        }
    }

    private fun setupViewListeners() {
        binding.swipeRefresh.setOnRefreshListener {
            viewModel.deleteUsers()
            viewModel.updateUsers()
        }
    }

    private fun onUsersLoaded(users: List<UserWrapper>) {
        userAdapter.items = users
        if (binding.swipeRefresh.isRefreshing) {
            binding.swipeRefresh.isRefreshing = false
        }
    }

    private fun obtainNavEvent(dir: ScreenRoutes) {
        when (dir) {
            is ScreenRoutes.ToUser -> findNavController().navigate(R.id.ToDetails, Bundle().apply {
                putString(DetailsFragment.ARG_KEY, dir.userId)
            })
        }
    }
}