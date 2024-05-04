package com.ashish.myapplication.utills


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashish.myapplication.model.ResponseMain
import com.ashish.myapplication.repository.MainRepository
import com.ashish.myapplication.repository.NetworkState

import kotlinx.coroutines.*


class MainViewModel(private val repository: MainRepository) : ViewModel() {


    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String>
        get() = _errorMessage


    val list = MutableLiveData<List<ResponseMain>>()

    var job: Job? = null


    private val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }
    val loading = MutableLiveData<Boolean>(true)

    fun getAllImages() {
        Log.d("Thread Outside", Thread.currentThread().name)

        viewModelScope.launch {
            Log.d("Thread Inside", Thread.currentThread().name)
            when (val response = repository.getAllImages()) {
                is NetworkState.Success -> {
                    list.postValue(response.data!!)
                    loading.postValue(false)
                }

                is NetworkState.Error -> {
                    loading.postValue(false)
                    if (response.response.code() == 401) {
                        // list.postValue(NetworkState.Error())
                    } else {
                        //  list.postValue(NetworkState.Error)
                    }
                }
            }
        }
    }

    fun onError(message: String) {
        _errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }


}