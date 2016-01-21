package org.disektea

class Blog {

    String title
    String description

    static hasMany = [blogPosts: BlogPost]

    static constraints = {
        title(blank: false)
    }
}
