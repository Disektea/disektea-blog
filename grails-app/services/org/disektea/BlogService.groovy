package org.disektea

import grails.transaction.Transactional

@Transactional
class BlogService {

    /**
     * Accepts title and desc and saves a blog object
     *
     * @param blogTitle
     * @param blogDescription
     * @return Blog
     */
    Blog saveBlog (String blogTitle, String blogDescription) {

        Blog blog = new Blog(title: blogTitle, description: blogDescription).save(flush: true)

        return blog
    }
}
