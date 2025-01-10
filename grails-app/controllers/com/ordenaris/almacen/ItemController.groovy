package com.ordenaris.almacen


import grails.rest.*
import grails.converters.*

class ItemController {
	static responseFormats = ['json', 'xml']
	
    def index() {
        render "Hello, World!"
    }

}
