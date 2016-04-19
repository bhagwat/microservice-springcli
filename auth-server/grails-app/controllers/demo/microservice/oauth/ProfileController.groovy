package demo.microservice.oauth

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured

class ProfileController {
    static responseFormats = ['json', 'xml']

    SpringSecurityService springSecurityService

    @Secured(["#oauth2.isUser()"])
    def user() {
        respond springSecurityService.getPrincipal()
    }
}