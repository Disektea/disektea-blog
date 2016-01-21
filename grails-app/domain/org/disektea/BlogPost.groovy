package org.disektea

class BlogPost extends AbstractDomain {

    String title
    String content
    Integer numberOfViewers = 0

    static constraints = {
        title(blank: false)
        content(blank: false)
    }
}
