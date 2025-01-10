package com.ordenaris.almacen

class Person {
    static hasMany = [visits: Visit, subcription: Subcription]
    String uuid = UUID.randomUUID().toString().replaceAll('\\-', '')
    String name
    String firstLastname
    String secondLastname
    String email
    String phone

    Date createAt

    static constraints = {
        uuid unique: true
        email unique: true, email: true
        phone unique:true
    }

    static mapping = {
        version false      
    }
}
