package com.example.watchchain.ui

import android.app.Application
import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.watchchain.data.Repository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore

const val TAG = "MAINVIEWMODEL"

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repo = Repository()

    //collectors aus dem Repository laden
    val collectors = repo.collectors

    //nft aus dem Repository laden
    val nft = repo.nft

    //wird loadNft() des Repository aufgerufen
    init {
        repo.loadNft()
    }

    //Kommunikationspunkt mit der Firestore Datenbank
    val db = FirebaseFirestore.getInstance()

    // Kommunikationspunkt mit der FirebaseAuth
    private val firebaseAuth = FirebaseAuth.getInstance()

    // currentuser ist null wenn niemand eingeloggt ist
    private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser: LiveData<FirebaseUser?>
    get() = _currentUser

    // hier wird versucht einen User zu erstellen um diesen anschließend auch gleich einzuloggen
    fun signUp(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                login(email, password)
            } else {
                Log.e(TAG, "SignUp failed: ${it.exception}")
            }
        }
    }

    fun facebookLogin() {
        firebaseAuth
    }

    fun login(email: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                _currentUser.value = firebaseAuth.currentUser
            } else {
                Log.e(TAG, "Login failed: ${it.exception}")
            }
        }
    }

    fun logout() {
        firebaseAuth.signOut()
        _currentUser.value = firebaseAuth.currentUser
    }
}