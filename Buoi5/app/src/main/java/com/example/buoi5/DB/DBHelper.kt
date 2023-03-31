package com.example.buoi5.DB

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.buoi5.Entity.Course

class DBHelper(context:Context, factory: SQLiteDatabase.CursorFactory?):
    SQLiteOpenHelper(context, DB_NAME, factory, DB_VERSION) {
    companion object {
        private const val DB_NAME = "buoi5"
        private const val DB_VERSION = 1
        private const val TABLE_NAME = "course"
        private const val ID_COL = "id"
        private const val NAME_COL = "namecourse"
        private const val DECRIPTION_COL = "decription"
        private const val DURATION_COL = "duration"
        private const val TRACK_COL = "track"


    }

    override fun onCreate(db: SQLiteDatabase) {
        val query = ("create table " + TABLE_NAME + "("
                + ID_COL + " integer primary key autoincrement, "
                + NAME_COL+" text,"
                + DECRIPTION_COL + " text,"
                + DURATION_COL + " text,"
                + TRACK_COL + " text)")
        db.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase, p1: Int, p2: Int) {
        db.execSQL("DROP TABEL IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }

    fun addCourse(
        CourseName: String?, CourseDecription: String?,
        CourseDuration: String?, CourseTrack: String?
    ) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COL, CourseName)
        values.put(DECRIPTION_COL, CourseDecription)
        values.put(DURATION_COL, CourseDuration)
        values.put(TRACK_COL, CourseTrack)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun readCourse(): ArrayList<Course>? {
        val db = this.readableDatabase
        val cursorCourse: Cursor = db.rawQuery("select * from $TABLE_NAME", null)
        val cursorModelArrayList: ArrayList<Course> = ArrayList()
        if (cursorCourse.moveToFirst()){
            do{
                cursorModelArrayList.add(
                    Course(
                        cursorCourse.getString(1),
                        cursorCourse.getString(2),
                        cursorCourse.getString(3),
                        cursorCourse.getString(4)
                    )
                )
            }while(cursorCourse.moveToNext())
        }
        cursorCourse.close()
        return cursorModelArrayList
    }

    fun updateCourse(Course_Name: String?, CourseName: String?,
                     CourseDecription: String?, CourseDuration: String?,
                     CourseTrack: String?){
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(NAME_COL, CourseName)
        values.put(DECRIPTION_COL, CourseDecription)
        values.put(DURATION_COL, CourseDuration)
        values.put(TRACK_COL, CourseTrack)

        db.update(TABLE_NAME, values, "namecourse=?", arrayOf(Course_Name))
        db.close()
    }
    fun deleteCourse(Course_Name:String?){
        val db = this.writableDatabase

        db.delete(TABLE_NAME, "namecourse=?", arrayOf(Course_Name))
        db.close()
    }

    fun search(CoursName:String?): ArrayList<Course>? {
        val db = this.readableDatabase
        val cursorCourse: Cursor = db.rawQuery("select * from $TABLE_NAME where $NAME_COL like ? ", arrayOf("%$CoursName%"))
        val cursorModelArrayList: ArrayList<Course> = ArrayList()
        if (cursorCourse.moveToFirst()) {
            do {
                cursorModelArrayList.add(
                    Course(
                        cursorCourse.getString(1),
                        cursorCourse.getString(2),
                        cursorCourse.getString(3),
                        cursorCourse.getString(4)
                    )
                )
            } while (cursorCourse.moveToNext())
        }
        cursorCourse.close()
        return cursorModelArrayList
    }
    }