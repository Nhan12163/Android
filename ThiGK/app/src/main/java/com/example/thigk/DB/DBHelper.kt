package com.example.thigk.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.thigk.Model.ConTact

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DB_NAME, factory, DB_VERSION) {
    companion object {
        private const val DB_NAME = "thigk"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "contact"
        private const val ID_COL = "id"
        private const val NAME_COL = "name"
        private const val PHONE_COL = "phone"
        private const val EMAIL_COL = "email"


    }
    override fun onCreate(db: SQLiteDatabase) {
        val query = ("create table " + TABLE_NAME + "("
                + ID_COL + " integer primary key autoincrement, "
                + NAME_COL+" text,"
                + PHONE_COL + " text unique,"
                + EMAIL_COL + " text unique)")
        db.execSQL(query)
    }
    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABEL IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }
    fun addContact(
        Name: String?, Phone: String?,
        Email: String?) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COL, Name)
        values.put(PHONE_COL, Phone)
        values.put(EMAIL_COL, Email)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun readCourse(): ArrayList<ConTact>? {
        val db = this.readableDatabase
        val cursorContact: Cursor = db.rawQuery("select * from $TABLE_NAME", null)
        val cursorModelArrayList: ArrayList<ConTact> = ArrayList()
        if (cursorContact.moveToFirst()){
            do{
                cursorModelArrayList.add(
                    ConTact(
                        cursorContact.getString(1),
                        cursorContact.getString(2),
                        cursorContact.getString(3),
                    )
                )
            }while(cursorContact.moveToNext())
        }
        cursorContact.close()
        return cursorModelArrayList
    }
}