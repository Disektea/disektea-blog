package org.disektea

import grails.transaction.Transactional

@Transactional
class UserService {

    def blogService

    User saveUserInformation(String firstName, String lastName, String email, String password, String confirmedPassword,
                             GenderEnum gender, String username, String blogTitle, String blogDescription) {

       /* User user = new User()

        user.firstName = firstName
        user.lastName = lastName*/

        if(password.equals(confirmedPassword)) {

            Blog blog = blogService.saveBlog(blogTitle, blogDescription)

            User user = new User(firstName: firstName, lastName: lastName, email: email, username: username,
                    password: password, gender: gender, blog: blog).save(flush: true)

            return user
        } else {

            throw new Exception("Password doesn't match.")
        }
    }
}