package com.ordenaris.almacen

import grails.gorm.transactions.Transactional

@Transactional
class UserService {
    // Actualizar y editar
    def manageUser( data, username = null ) {
        User.withTransaction{tsStatus ->
            try{
                println "${new Date()} -> Gestion de Usiario -> Comienza el registro del usuario -> data: ${data}"
                
                def user = User.findByUsername( username )

                if( !user ) { user = new User()}

                // SELECT * FROM table where role = data.role
                def role = Role.findByAuthority( data.role )
                if(!role){
                    println "${new Date()} -> Gestion de Usiario -> Rol de usuraio no registrado -> data: ${data}"
                    return [ success: false, message: "Rol de usuraio no registrado"]
                } 
                println "${new Date()} -> Gestion de Usiario -> Rol de usuraio encontrado -> data: ${data}"

                user.username = data.username
                user.password = data.password
                user.save(flush: true, failOnError:true)
                println "${new Date()} -> Gestion de Usiario -> El usuario se ha registrado -> data: ${data}"

                if (!username) {
                    new UserRole(
                        user:user, 
                        role:role
                    ).save(flush: true, failOnError: true)
                }
                println "${new Date()} -> Gestion de Usiario -> Asignación de usurio a rol -> data: ${data}"
                return [success: true]
            }catch(e){
                tsStatus.setRollbackOnly()
                println "${new Date()} -> Gestion de Usiario -> Inicio de Solicitud -> data: ${data} -> ERROR: ${e.getMessage()}"
                return [success: false]
            }
        }
    }
}
