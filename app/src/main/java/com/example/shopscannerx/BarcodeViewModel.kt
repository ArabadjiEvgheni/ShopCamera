package com.example.shopscannerx

import android.app.Application
import androidx.lifecycle.*
import com.example.shopscannerx.database.BarcodeDao
import com.example.shopscannerx.database.BarcodeDb
import com.example.shopscannerx.database.BarcodeEntity
import com.example.shopscannerx.database.BarcodeRepository
import kotlinx.coroutines.launch

class BarcodeViewModel

//    : ViewModel()

    (private val repository: BarcodeRepository
            , application: Application) : AndroidViewModel(application)

{

    val barcode: LiveData<List<BarcodeEntity>> = repository.allBarcode.asLiveData()
//    init {
//        val getDao = BarcodeDb.getInstance(application).barcodeDao()
//        repository = BarcodeRepository(getDao)
//        allBarcode = repository.allBarcode
//    }
    fun insert (barcode: BarcodeEntity) = viewModelScope.launch {
        repository.insert(barcode)
    }

}