package com.example.shopscannerx.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "tableBarcode")
data class BarcodeEntity(
    @PrimaryKey(autoGenerate = true)
    val BarcodeId: Int?,
    @ColumnInfo
    val BarcodeCode: Int,
//    @ColumnInfo
//    val BarcodeIsInDbOrInet: Boolean,
    @ColumnInfo(name = "barcodeName")
    val barcodeName: String,
    @ColumnInfo
    val priceOfBarcode: Double

) : Parcelable

// {
//    override fun toString(): String {
//        return "BarcodeEntity" +
//                "\n\t(" +
//                "\n\t\tBarcodeId=$BarcodeId" +
//                "\n\t\tBarcodeCode=$BarcodeCode" +
//                "\n\t\tBarcodeName=$BarcodeName"
//        "\n\t)"
//    }
//}
