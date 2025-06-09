package com.example.githubs3.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PersonalInformationVariantViewModel : ViewModel() {
    private val _loaderState = MutableLiveData<Boolean>()
    val loaderState: LiveData<Boolean>
        get() = _loaderState

    private val _mensaje = MutableLiveData<Boolean>()
    val mensaje: LiveData<Boolean>
        get() = _mensaje

    fun requestPersonalInformation(Name: String, Usernames: String, Lastnames: String, BirthDate: String, Code: String
    ) {
        _loaderState.value = true

        if (Name.isNotEmpty() && Usernames.isNotEmpty() && Lastnames.isNotEmpty()
            && BirthDate.isNotEmpty() && Code.isNotEmpty()
        ) {
            _mensaje.value = true
        } else {
            _mensaje.value = false
        }

        _loaderState.value = false
    }
}
