class UrlMappings {

	static mappings = {

        "/login/$action?" (controller: 'login')
        "/logout/$action?" (controller: 'logout')

        "/"(view:"/index")
        "500"(view:'/error')

        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
	}
}
