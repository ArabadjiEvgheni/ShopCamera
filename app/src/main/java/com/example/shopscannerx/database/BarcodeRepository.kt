package com.example.shopscannerx.database

import androidx.annotation.WorkerThread

import kotlinx.coroutines.flow.Flow

class BarcodeRepository(private val barcodeDao: BarcodeDao) {
    val allBarcode: Flow<List<BarcodeEntity>> = barcodeDao.getAll()
    val barcode: Flow<List<BarcodeEntity>> = barcodeDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(barcode: BarcodeEntity){
        barcodeDao.insert(barcode)
    }
}