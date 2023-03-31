package com.example.buoi5.Entity

class Course (courseName:String?, courseDecription:String?,
              courseDuration:String?, courseTrack:String?) {
    private var id = 0;
    private var courseName: String? = courseName
    private var courseDecription: String? = courseDecription
    private var courseDuration: String? = courseDuration
    private var courseTrack: String? = courseTrack

    fun getId(): Int{
        return id
    }
    fun setId(id:Int){
        this.id = id
    }

    fun getCourseName():String?{
        return courseName
    }
    fun setCourseName(courseName: String?){
        this.courseName = courseName
    }
    fun getCourseDecription():String?{
        return courseDecription
    }
    fun setCourseDecription(courseDecription: String?){
        this.courseDecription = courseDecription
    }
    fun getCourseDuration():String?{
        return courseDuration
    }
    fun setCourseDuration(courseDuration: String?){
        this.courseDuration = courseDuration
    }
    fun getCourseTrack():String?{
        return courseTrack
    }
    fun setCourseTrack(courseTrack: String?){
        this.courseTrack = courseTrack
    }
}