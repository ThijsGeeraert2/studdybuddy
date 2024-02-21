package be.thijsgeeraert.studdybuddy.viewmodels


import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginVM: ViewModel() {
    var username by mutableStateOf("")
        private set
    var password by mutableStateOf("")
        private set

    init {
        Log.d("debug","loginhulp")
    }
    fun updateUserName(username: String) {
        this.username = username
    }

    fun updatePassword(password: String) {
        this.password = password
    }

    fun login() : Boolean {

        if (username == "admin" && password == "admin") {
            return true
        }
        return false
    }
}