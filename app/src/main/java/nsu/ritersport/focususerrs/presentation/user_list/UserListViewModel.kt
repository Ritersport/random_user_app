package nsu.ritersport.focususerrs.presentation.user_list

import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import nsu.ritersport.focususerrs.domain.model.User
import nsu.ritersport.focususerrs.domain.repository.UserRepository
import nsu.ritersport.focususerrs.presentation.base.view.BaseViewModel
import nsu.ritersport.focususerrs.presentation.user_list.rv.UserWrapper
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository
) : BaseViewModel() {

    private val _users: MutableLiveData<List<UserWrapper>> = MutableLiveData()
    val users: LiveData<List<UserWrapper>> = _users

    init {
        loadUsers()
    }

    private fun loadUsers() {
        userRepository.getUsers(50).map { it ->
            it.map {
                UserWrapper(
                    it,
                    "%s %s %s".format(it.name.title, it.name.first, it.name.last),
                    "%s, %s, %s".format(it.location.country, it.location.state, it.location.city),
                    it.phone,
                    Uri.parse(it.picture.thumbnail)
                )
            }
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _users.value = it
            },
                {
                    onError(it)
                })
            .unsubscribeOnCleared()
    }

    fun onItemClicked(user: User) {

    }
}