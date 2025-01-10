package com.ordenaris.almacen

class Subcription {
    static belongsTo = [person: Person, item: Item]
    Date createAt = new Date()

    Boolean status = true
    static constraints = {

    }
    static mapping = {
        version false
    }
}
