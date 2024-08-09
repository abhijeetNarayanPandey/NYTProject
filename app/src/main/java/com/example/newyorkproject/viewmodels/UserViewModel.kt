package com.example.newyorkproject.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cheezycode.daggermvvm.models.Users
import com.example.newyorkproject.repositories.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class UserViewModel @Inject constructor(private val usersRepository: UsersRepository) : ViewModel() {

    private val _users = MutableLiveData<List<Users>>()
    val users: LiveData<List<Users>>
        get() = _users

    init {
        fetchUsers()
    }

   private fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = usersRepository.fetchUsers()
                _users.value = response
            }
            catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

}