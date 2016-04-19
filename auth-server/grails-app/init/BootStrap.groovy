import demo.microservice.oauth.Client
import demo.microservice.oauth.Role
import demo.microservice.oauth.User
import demo.microservice.oauth.UserRole

class BootStrap {

    def init = { servletContext ->
        Role roleUser = new Role(authority: 'ROLE_USER').save(flush: true)

        User user = new User(
                username: 'bhagwat.kumar@tothenew.com',
                password: '123456',
                enabled: true,
                accountExpired: false,
                accountLocked: false,
                passwordExpired: false
        ).save(flush: true)

        UserRole.create(user, roleUser, true)

        new Client(
                clientId: 'my-client',
                clientSecret: 'my-client-secret',
                authorizedGrantTypes: ['authorization_code', 'refresh_token', 'implicit', 'password', 'client_credentials'],
                authorities: ['ROLE_CLIENT'],
                scopes: ['read', 'write'],
                redirectUris: ['http://myredirect.com']
        ).save(flush: true)
    }
    def destroy = {
    }
}
