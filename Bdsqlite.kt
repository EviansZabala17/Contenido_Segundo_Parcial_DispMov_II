package com.example.clase14_5

//import android.database.sqlite.SQLiteOpenHelperpackage com.example.clase14_5
import android.content.Context
import android.database.sqlite.SQLiteDatabase
//importacion de la libreria por defecto
import android.database.sqlite.SQLiteOpenHelper
//creacion de un subclase de sqlliteopenhelper
class Bdsqlite (
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper (context,name,factory,version) {


    // creacion de la bd
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table participante (ci text primary key, nombre text,observacion text)")
    }
    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        TODO("Not yet implemented")
    }
}
