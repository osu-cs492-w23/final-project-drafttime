package com.example.drafttime.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.drafttime.data.AppDatabase
import com.example.drafttime.data.PlayerInfo
import com.example.drafttime.data.PlayerInfoData
import kotlinx.coroutines.launch

class PlayerInfoViewModel(application: Application) : AndroidViewModel(application) {
    private val playerAdd = PlayerInfoData(
        AppDatabase.getInstance(application).playerDao()
    )

    val userPlayers = playerAdd.getAllPlayerData().asLiveData()
    val userQB = playerAdd.getAllQbData().asLiveData()
    val userRB = playerAdd.getAllRbData().asLiveData()
    val userWR = playerAdd.getAllWrData().asLiveData()
    val userTE = playerAdd.getAllTeData().asLiveData()


    fun addPlayer(player: PlayerInfo) {
        viewModelScope.launch {

            playerAdd.insertPlayer(player)
        }

    }

    fun deletePlayer(player: PlayerInfo) {
        viewModelScope.launch {

            playerAdd.deletePlayer(player)
        }
    }
}