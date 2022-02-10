package com.example.shopscannerx.database

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface BarcodeDao {

    @Query ("SELECT * FROM tableBarcode")
    fun getAll():Flow<List<BarcodeEntity>>

    @Query ("SELECT * FROM tableBarcode")
    fun get():Flow<List<BarcodeEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(vararg barcode: BarcodeEntity)

    @Delete
    suspend fun delete(barcode: BarcodeEntity)



//    @Query("DELETE FROM tableBarcode")
//    suspend fun deleteAll()


//    @Update
//    fun update(barcode: BarcodeEntity)
//
//    @Query("SELECT * FROM tableBarcode WHERE BarcodeId = :barcodeId")
//    fun get(barcodeId: Int): BarcodeEntity?
//
//
//    @Query("SELECT * FROM tableBarcode ORDER BY BarcodeId DESC LIMIT 1")
//    fun getBarcode(): BarcodeEntity?
//
//    @Query ("SELECT * FROM tableBarcode ORDER BY BarcodeName ASC")
//    fun getAlphabetizedBarcodeList(): LiveData<List<BarcodeEntity>>
//
//    @Query("SELECT * FROM tableBarcode ORDER BY BarcodeName ASC")
//    fun getAlphabetizedBarcode(): Flow<List<BarcodeEntity>>


}
//@Query("DELETE FROM ${RoomContract.tableBarcode} WHERE BarcodeId = :barcodeId")
//suspend fun deleteBarcode(barcodeId: Int): Int
//
//@Query("SELECT * FROM ${RoomContract.tableBarcode} WHERE BarcodeId = :barcodeId")
//suspend fun getBarcode(barcodeId: Int
////                           , barcodeIsInDbOrInet: Boolean
//): BarcodeEntity?
//
//@Query("SELECT * FROM ${RoomContract.tableBarcode} WHERE BarcodeId = :caseId")
//suspend fun getBarcode(caseId: String): BarcodeEntity
//
//@Query("SELECT * FROM ${RoomContract.tableBarcode} WHERE BarcodeId = :barcodeId")
//suspend fun getBarcodes(barcodeId: Int): List<BarcodeEntity>
//
//@Query("SELECT * FROM ${RoomContract.tableBarcode} WHERE BarcodeId = :caseId")
//suspend fun getBarcodeId (caseId: String): Int
//
//@Query("SELECT * FROM ${RoomContract.tableBarcode} WHERE BarcodeName = :barcodeName")
//suspend fun getBarcodeByName(barcodeName: String): BarcodeEntity?
//
//@Query("SELECT BarcodeCode FROM ${RoomContract.tableBarcode} WHERE BarcodeCode = :barcodeCode")
//suspend fun getBarcodeCode(barcodeCode: Int): Int
//
//@Insert(entity = BarcodeEntity::class, onConflict = OnConflictStrategy.REPLACE)
//suspend fun insertItem(row: BarcodeEntity): Int
//
//@Update
//suspend fun updateItem(member: BarcodeEntity)
//
//@Query("DELETE FROM ${RoomContract.tableBarcode}")
//suspend fun deleteAll()
//
//@Query("SELECT * from ${com.example.shopscannerbase.RoomContract.tableBarcode} ORDER BY BarcodeName ASC")
//fun getAlphabetizedTodoList(): LiveData<List<BarcodeEntity>>
