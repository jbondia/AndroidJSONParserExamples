class UrlMappings {

	static mappings = {
        /*
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        */

        "/api/v1/character" {
            controller = 'character'
            action = [GET: 'showCharacter']
        }

        "/"(view:"/index")
        "500"(view:'/error')
	}
}
