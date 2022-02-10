package com.example.shopscannerx.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.shopscannerx.BuildConfig

import java.util.concurrent.Executors


@Database(
   entities = [BarcodeEntity::class],
    version = 1
)
abstract class BarcodeDb : RoomDatabase() {

            abstract fun barcodeDao(): BarcodeDao
    companion object {
    @Volatile
    private var INSTANCE: BarcodeDb? = null

    fun getInstance(context: Context): BarcodeDb {
        synchronized(this) {
            var instance = INSTANCE
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    BarcodeDb::class.java,
                    "BarcodeDb"
                )
                    .fallbackToDestructiveMigration()
                    .setQueryCallback(
                        { sqlQuery, bindArgs ->
                            if (BuildConfig.DEBUG) {
                                val builder = StringBuilder()
                                val parts = sqlQuery.split("?")
                                if (parts.isNotEmpty() && bindArgs.isNotEmpty()) {
                                    bindArgs.forEachIndexed { index, s ->
                                        builder.append(parts[index])
                                        builder.append(s)
                                    }
                                    builder.append(parts.last())
                                    Log.i("BarcodeDb", "Query$builder")
                                }
                            }
                        }, Executors.newSingleThreadExecutor()
                    ).build()
                INSTANCE = instance
            }
            return instance
        }
    }
}}





//    companion object{
//        @Volatile
//        private var INSTANCE: BarcodeDb? = null
//        fun getInstance(
//                    context: Context,
//                    scope: CoroutineScope
//                    ): BarcodeDb {
//            synchronized(this) {
//                var instance = INSTANCE
//                if (instance == null) {
//                    instance = Room.databaseBuilder(
//                        context.applicationContext,
//                        BarcodeDb::class.java,
//                        "BarcodeDb"
//                    )
//                        .fallbackToDestructiveMigration()
//                        .build()
//                    INSTANCE = instance
//                }
//                return instance
//            }
//        }
//
//    }
//}

//            abstract fun barcodeDao(): BarcodeDao
////    abstract val barcodeDao: BarcodeDao
//    companion object {
//    @Volatile
//    private var INSTANCE: BarcodeDb? = null
//
//    fun getInstance(context: Context): BarcodeDb {
//        synchronized(this) {
//            var instance = INSTANCE
//            if (instance == null) {
//                instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    BarcodeDb::class.java,
//                    "BarcodeDb"
//                )
//                    .fallbackToDestructiveMigration()
//                    .setQueryCallback(
//                        { sqlQuery, bindArgs ->
//                            if (BuildConfig.DEBUG) {
//                                val builder = StringBuilder()
//                                val parts = sqlQuery.split("?")
//                                if (parts.isNotEmpty() && bindArgs.isNotEmpty()) {
//                                    bindArgs.forEachIndexed { index, s ->
//                                        builder.append(parts[index])
//                                        builder.append(s)
//                                    }
//                                    builder.append(parts.last())
//                                    Log.i("BarcodeDb", "Query$builder")
//                                }
//                            }
//                        }, Executors.newSingleThreadExecutor()
//                    ).build()
//                INSTANCE = instance
//            }
//            return instance
//        }
//    }
//}}
//doAsync {

//    val db = Room.databaseBuilder(context.applicationContext,
//        BarcodeDb::class.java,
//        "BarcodeDb"
//    ).build()
//    uiThread{
//    }
