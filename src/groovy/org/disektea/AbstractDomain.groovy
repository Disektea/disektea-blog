package org.disektea

/**
 * Created by Biniam Asnake.
 */
abstract class AbstractDomain {

    Date dateCreated
    Date lastUpdated
    User createdBy
    User updatedBy

    transient springSecurityService

    static constraints = {

        createdBy nullable: true
        updatedBy nullable: true
    }

    def beforeInsert() {

        if(!springSecurityService) {

            User currentUser = springSecurityService.getCurrentUser();

            if(currentUser)
                this.createdBy = currentUser
        }
    }

    def beforeUpdate() {

        if(!springSecurityService) {

            User currentUser = springSecurityService.getCurrentUser();

            if(currentUser)
                this.updatedBy = currentUser
        }
    }
}
