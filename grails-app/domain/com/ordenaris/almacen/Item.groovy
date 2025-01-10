package com.ordenaris.almacen

import java.util.UUID

class Item {
    static hasMany = [visits: Visit, subcriptions: Subcription]
    String uuid = UUID.randomUUID().toString().replaceAll('\\-', '')
    String name
    String picture
    String shortDescription
    String longDescription
    String sku

    Date create_at = new Date()

    int status // 1-activo, 2-suspendido, 3-eliminado

    BigDecimal price

    static constraints = {
        uuid unique: true
    }

    static mapping = {
        version false
        uuid index: 'item_uuid_idx'        
        name index: 'item_name_idx'        
        sku index: 'item_sku_idx'        
        createAt index: 'item_create_at_idx'
        status index: 'item_status_idx'        
        price index: 'item_price_idx'        
    }
}

