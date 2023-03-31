package com.example.login.Model

class DangNhap (Email:String?, Name:String?,
                Pass:String?) {
    private var id = 0;
    private var Email: String? = Email
    private var Name: String? = Name
    private var Pass: String? = Pass

    fun getId(): Int{
        return id
    }
    fun setId(id:Int){
        this.id = id
    }

    fun getEmail():String?{
        return Email
    }
    fun setEmail(Email: String?){
        this.Email = Email
    }
    fun getName():String?{
        return Name
    }
    fun setName(Name: String?){
        this.Name = Name
    }
    fun getPass():String?{
        return Pass
    }
    fun setPass(Pass: String?){
        this.Pass = Pass
    }
}