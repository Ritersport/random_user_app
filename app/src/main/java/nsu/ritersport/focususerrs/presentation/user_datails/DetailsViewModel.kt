package nsu.ritersport.focususerrs.presentation.user_datails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import nsu.ritersport.focususerrs.domain.model.User
import nsu.ritersport.focususerrs.domain.repository.UserRepository
import nsu.ritersport.focususerrs.presentation.base.view.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : BaseViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    fun loadUser(id: String) {
        userRepository.getUserById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    _user.value = it
                },
                {
                    onError(it)
                }
            ).unsubscribeOnCleared()

    }
}