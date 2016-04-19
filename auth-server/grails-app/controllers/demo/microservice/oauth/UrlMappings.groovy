package auth.server

class UrlMappings {

    static mappings = {
        "/user"(controller: 'profile', action: 'user')

        "/$controller/$action?/$id?(.$format)?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
