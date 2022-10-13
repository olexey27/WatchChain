package com.example.watchchain.ui.authentication

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.watchchain.data.Repository
import com.example.watchchain.data.remote.NftApi
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

private const val TAG = "MainViewModel"

enum class ApiStatus {LOADING, ERROR, DONE}

class MainViewModel(application: Application) : AndroidViewModel(application) {

    //private val database = getDatabase(application)

    //private val repository = Repository(NftApi, database)
    private val repository = Repository(NftApi)

    //Die Nfts und die Favoriten werden in einer Live Variablen gespeichert
    val nfts = repository.collectors
    //val favoriteNft = repository.favoriteNft

    /*private val _favoriteNft = MutableLiveData<List<Nft>>()
    val favoriteNft: LiveData<List<Nft>>
        get() = _favoriteNft

    init {
        addNftToFavorite()
    }

    /**
     * Eine Funktion um einen Nft zu den Favoriten hinzuzufügen
     */
    private fun addNftToFavorite(nft: Nft) {
        val favorite = _favoriteNft.value
        val newNft = mutableListOf(nft)
        if (favorite != null) {
            newNft.addAll(favorite.toTypedArray())
        }
        _favoriteNft.value = newNft
    }*/


    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus>
    get() = _loading

    init {
        loadData()
    }


    private fun loadData() {
        viewModelScope.launch {
            _loading.value = ApiStatus.LOADING
            try {
                repository.getNfts()
                _loading.value = ApiStatus.DONE
            } catch (e:Exception) {
                Log.e(TAG,"Error loading Data from API: $e")
                if (nfts.value.isNullOrEmpty()) {
                    _loading.value = ApiStatus.ERROR
                } else {
                    _loading.value = ApiStatus.DONE
                }
            }
        }
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