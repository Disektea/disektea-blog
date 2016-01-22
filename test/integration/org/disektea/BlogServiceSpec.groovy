package org.disektea
import grails.test.mixin.TestFor
import spock.lang.Specification
/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(BlogService)
class BlogServiceSpec extends Specification {

    def setup () {
    }

    def cleanup () {
    }

    void "test saveUserInformation method" () {

        given:
            String title = 'title'
            String desc = 'desc'

        when:
            def blog = service.saveBlog(title, desc)

        then:
            assertNotNull(blog)
    }
}
