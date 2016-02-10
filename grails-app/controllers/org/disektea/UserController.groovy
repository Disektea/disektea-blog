package org.disektea

class UserController {

    def userService

    def index() { }

    def signup() {

        render view: 'signup'
    }

    def saveUser() {

        User user = userService.saveUserInformation(params.firstName, params.lastName, params.email, params.password, params.confirmPassword,
                    GenderEnum.valueOf(params.gender), params.username, params.blogTitle, params.blogDescription)

        if(!user) {

            flash.message = "User info is saved successfully"
            render view: 'signup'
        }
    }
}
