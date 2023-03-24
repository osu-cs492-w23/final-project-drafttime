package com.example.drafttime.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.drafttime.api.ConnectedSleeper
import com.example.drafttime.data.DraftTimeRepository
import com.example.drafttime.data.PlayerInfo
import kotlinx.coroutines.launch

class DraftTimeViewModel : ViewModel() {
    private val players = DraftTimeRepository(ConnectedSleeper.create())
    private val _playerResults = MutableLiveData<List<List<PlayerInfo?>>>(null)
    val results: LiveData<List<List<PlayerInfo?>>> = _playerResults


    fun loadPlayers() {

        viewModelScope.launch {
            val result = players.loadPlayers()
            _playerResults.value = result.getOrNull()
        }

    }
}