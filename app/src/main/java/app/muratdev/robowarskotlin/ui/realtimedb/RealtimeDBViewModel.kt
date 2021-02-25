package app.muratdev.robowarskotlin.ui.realtimedb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RealtimeDBViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Example Robot Control with Firebase RealtimeDB"
    }
    val text: LiveData<String> = _text
}