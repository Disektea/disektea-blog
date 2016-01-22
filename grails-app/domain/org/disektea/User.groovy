package org.disektea

class User extends AbstractDomain {

	transient springSecurityService

	String username, password, firstName, lastName, email, address = "", blogTitle = "", blogDescription = ""
	boolean enabled = true, accountExpired = false, accountLocked = false, passwordExpired = false
    GenderEnum sex

    static transients = ['springSecurityService']

    static constraints = {
        username blank: false, unique: true
        password blank: false
        address blank: true
        blogTitle blank: true
        blogDescription blank: true
    }

    static mapping = {
        table '`user`'
        password column: '`password`'
    }

    Set<Role> getAuthorities () {
        UserRole.findAllByUser(this).collect { it.role }
    }

    def beforeInsert () {
        encodePassword()
    }

    def beforeUpdate () {
        if(isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword () {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }
}
