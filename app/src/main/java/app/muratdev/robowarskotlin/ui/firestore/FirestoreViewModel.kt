package app.muratdev.robowarskotlin.ui.firestore

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirestoreViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Example Robot Control with Firebase Firestore"
    }
    val text: LiveData<String> = _text
}