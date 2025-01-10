package com.ordenaris.almacen


import grails.rest.*
import grails.converters.*

class UserController {
	static responseFormats = ['json', 'xml']
	
    def UserService

    def manage() {

        def data = request.JSON
        // Seguimiento de la información
        println "${new Date()} -> Gestion de Usiario -> Inicio de Solicitud de creación -> data: ${data}"
        if(!data.username) return respond( [success: false, message: "Parametro username requerido"])
        if(!data.password) return respond( [success: false, message: "Parametro password requerido"])
        if(!data.role) return respond( [success: false, message: "Parametro role requerido"])
        def responseService= UserService.manageUser(data, params.username)
        respond(responseService)
    }
}
