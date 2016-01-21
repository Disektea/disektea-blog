import org.disektea.Requestmap

class BootStrap {

    def init = { servletContext ->

        println "Bootstrap is running"

        // Request map Stored in Database
        for (String url in [
                '/', '/index', '/index.gsp', '/**/favicon.ico',
                '/**/javascripts/**', '/**/stylesheets/**', '/**/images/**', '/assets/**',
                '/login', '/login.*', '/login/*',
                '/logout', '/logout.*', '/logout/*']) {
            Requestmap.findOrSaveByUrlAndConfigAttribute(url, 'permitAll').save()
        }

        println "Bootstrap is done."
    }

    def destroy = {
    }
}
