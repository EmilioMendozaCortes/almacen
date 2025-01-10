package elalmacen
import com.ordenaris.almacen.Role
import com.ordenaris.almacen.User
import com.ordenaris.almacen.UserRole

class BootStrap {

    def init = { servletContext ->
        // SELECT COUNT * FROM role;
        if(!Role.count()) {
            def roleRoot = new Role(authority: "ROLE_ROOT").save()

            new Role(authority: "ROLE_ADMIN").save()
            new Role(authority: "ROLE_VENDOR").save()

            def userRoot = new User(username: "luis.gomez@oredenaris.com", password: "super1234").save()

            new Role(user: userRoot, role: roleRoot).save()
        }
    }
    def destroy = {
    }
}
