import grails.util.Environment
import org.disektea.Blog
import org.disektea.GenderEnum
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

        Requestmap.findOrSaveByUrlAndConfigAttribute('/user/signup', 'permitAll').save(flush: true, failOnError: true)
        Requestmap.findOrSaveByUrlAndConfigAttribute('/user/saveUser', 'permitAll').save(flush: true, failOnError: true)

        println Environment.getCurrent()

        if (Environment.getCurrent() != Environment.PRODUCTION) {

            Blog blog = Blog.findOrSaveByTitleAndDescription('My blog', 'my blog description ...').save(flush: true, failOnError: true)

            User user = User.findByUsername('admin')

            if(!user) {

                User.SaveByUsernameAndPasswordAndFirstNameAndLastNameAndEmailAndGenderAndBlog(
                        'admin', 'password', 'Abebe', 'Kebede', 'abebe@gmail.com', GenderEnum.MALE, blog
                ).save(flush: true, failOnError: true)
            }

            println "Bootstrap is done."
        }
    }

    def destroy = {

    }
}
