package com.example.shopscannerx

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.shopscannerx.database.BarcodeRepository
import java.lang.IllegalArgumentException

class BarcodeViewModelFactory(
    private val repository: BarcodeRepository,
    private val application: Application) : ViewModelProvider.Factory{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BarcodeViewModel::class.java)){
            return BarcodeViewModel(repository, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}