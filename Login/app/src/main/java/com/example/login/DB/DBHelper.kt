package com.example.login.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.login.Model.DangNhap
import java.util.jar.Attributes

class DBHelper(context:Context, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DB_NAME, factory, DB_VERSION) {
    companion object {
        private const val DB_NAME = "DBlogin"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "Login"
        private const val ID_COL = "id"
        private const val EMAIL_COL = "email"
        private const val NAME_COL = "name"
        private const val PASS_COL = "pass"

    }

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("create table " + TABLE_NAME + "("
                + ID_COL + " integer primary key autoincrement, "
                + EMAIL_COL+" text unique,"
                + NAME_COL + " text unique,"
                + PASS_COL + " text)")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABEL IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    fun addLogin(
        Email: String?, Name: String?,
        Pass: String?
    ) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(EMAIL_COL, Email)
        values.put(NAME_COL, Name)
        values.put(PASS_COL, Pass)
        db.insert(TABLE_NAME, null, values)
        db.close()
    }



    fun login(Name:String?, Pass:String? ): DangNhap{
        val db = this.readableDatabase
        val cursorLogin: Cursor = db.rawQuery("SELECT $NAME_COL, $PASS_COL FROM $TABLE_NAME WHERE $NAME_COL = ? AND $PASS_COL = ?", arrayOf(Name, Pass))
        var name: String? = null
        var pass: String? = null
        if (cursorLogin.moveToFirst() && cursorLogin.count > 0) {
            name = cursorLogin.getString(0)
            pass = cursorLogin.getString(1)
        }
        cursorLogin.close()
        return DangNhap(null,name, pass)
    }
}