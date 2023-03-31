package com.example.thigk.Model

class ConTact(Name:String?, Phone:String?,
              Email:String?) {
  private var id = 0;
  private var Name: String? = Name
  private var Phone: String? = Phone
  private var Email: String? = Email


  fun getId(): Int{
    return id
  }
  fun setId(id:Int){
    this.id = id
  }

  fun getName():String?{
    return Name
  }
  fun setName(Name: String?){
    this.Name = Name
  }
  fun getPhone():String?{
    return Phone
  }
  fun setPhone(Phone: String?){
    this.Phone = Phone
  }
  fun getEmail():String?{
    return Email
  }
  fun setEmail(Email: String?){
    this.Email = Email
  }
}