import org.disektea.Requestmap
import org.disektea.User

class BootStrap {

    def init = { servletContext ->

        println "Bootstrap is running"

        // Request map Stored in Database
        for (String url in [
                '/', '/index', '/index.gsp', '/**/favicon.ico',
                '/**/javascripts/**', '/**/stylesheets/**', '/**/images/**', '/assets/**',
                '/login', '/login.*', '/login/*',
                '/logout', '/logout.*', '/logout/*']) {
            Requestmap.findOrSaveByUrlAndConfigAttribute(url, 'permitAll').save(flush: true, failOnError: true)
        }

        new User(username: 'admin', password: 'password').save(flush: true, failOnError: true)

        println "Bootstrap is done."
    }

    def destroy = {

    }
}
