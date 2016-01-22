package org.disektea

class User extends AbstractDomain {

	transient springSecurityService

	String username
    String password
    String firstName
    String lastName
    String email

    Blog blog
    GenderEnum gender

	boolean enabled = true
    boolean accountExpired = false
    boolean accountLocked = false
    boolean passwordExpired = false

    static transients = ['springSecurityService']

    static constraints = {
        username blank: false, unique: true
        password blank: false
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
