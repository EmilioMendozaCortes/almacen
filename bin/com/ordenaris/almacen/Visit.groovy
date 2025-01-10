package com.ordenaris.almacen

class Visit {
    static belongsTo = [person: Person, item: Item]
    Date createAt = new Date()

    static constraints= {

    }
    static mapping = {
        version false
        createAt index: 'visit_create_at_idx'
    }
}
