import demo.microservice.oauth.CustomGormAuthorizationCodeService
import demo.microservice.oauth.CustomGormClientDetailsService
import demo.microservice.oauth.CustomGormTokenStoreService

beans = {
    gormClientDetailsService(CustomGormClientDetailsService) {
        grailsApplication = ref('grailsApplication')
        clientAdditionalInformationSerializer = ref('clientAdditionalInformationSerializer')
    }

    gormAuthorizationCodeService(CustomGormAuthorizationCodeService) {
        grailsApplication = ref('grailsApplication')
        oauth2AuthenticationSerializer = ref('oauth2AuthenticationSerializer')
    }

    gormTokenStoreService(CustomGormTokenStoreService) {
        grailsApplication = ref("grailsApplication")

        oauth2AuthenticationSerializer = ref("oauth2AuthenticationSerializer")
        authenticationKeyGenerator = ref("authenticationKeyGenerator")

        accessTokenAdditionalInformationSerializer = ref("accessTokenAdditionalInformationSerializer")
        accessTokenScopeSerializer = ref("accessTokenScopeSerializer")
    }
}