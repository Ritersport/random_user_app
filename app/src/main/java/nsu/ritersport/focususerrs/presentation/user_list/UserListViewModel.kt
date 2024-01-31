package nsu.ritersport.focususerrs.presentation.user_list

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import nsu.ritersport.focususerrs.domain.model.User
import nsu.ritersport.focususerrs.domain.repository.UserRepository
import nsu.ritersport.focususerrs.presentation.base.live_data.SingleLiveEvent
import nsu.ritersport.focususerrs.presentation.base.live_data.update
import nsu.ritersport.focususerrs.presentation.base.view.BaseViewModel
import nsu.ritersport.focususerrs.presentation.user_list.rv.UserWrapper
import javax.inject.Inject

private const val USERS_ON_PAGE = 20

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val _users: MutableLiveData<List<UserWrapper>> = MutableLiveData()
    val users: LiveData<List<UserWrapper>> = _users

    private val _navEvent = SingleLiveEvent<ScreenRoutes>()
    val navEvent: LiveData<ScreenRoutes> = _navEvent

    init {
        loadUsers()
    }

    private fun loadUsers() {
        userRepository.getSavedUsersList().map { it ->
            it.map {
                UserWrapper(
                    it.userId,
                    "%s %s %s".format(it.name.title, it.name.first, it.name.last),
                    "%s, %s, %s".format(it.location.country, it.location.state, it.location.city),
                    it.phone,
                    Uri.parse(it.picture)
                )
            }
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _users.value = it
                if (it.isEmpty()) {
                    updateUsers()
                }
            },
                {
                    onError(it)
                })
            .unsubscribeOnCleared()
    }

    fun updateUsers() {
        userRepository.updateUsers(USERS_ON_PAGE)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loadUsers()
            },
                {
                    onError(it)
                }).unsubscribeOnCleared()
    }

    fun deleteUsers() {
        userRepository.deleteAll()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

            },
                {
                    onError(it)
                }).unsubscribeOnCleared()
    }

    fun onItemClicked(userId: String) {
        _navEvent.update { ScreenRoutes.ToUser(userId) }
    }
}