package org.disektea

class Blog extends AbstractDomain {

    String title
    String description

    static hasMany = [blogPosts: BlogPost]

    static constraints = {
        title(blank: false)
    }
}
