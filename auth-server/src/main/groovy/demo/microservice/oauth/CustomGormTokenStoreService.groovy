package demo.microservice.oauth

import grails.plugin.springsecurity.oauthprovider.GormTokenStoreService
import grails.transaction.Transactional
import org.springframework.security.oauth2.common.OAuth2AccessToken
import org.springframework.security.oauth2.common.OAuth2RefreshToken
import org.springframework.security.oauth2.provider.OAuth2Authentication

class CustomGormTokenStoreService extends GormTokenStoreService {
    @Transactional(readOnly = true)
    OAuth2Authentication readAuthentication(OAuth2AccessToken token) {
        return readAuthentication(token.value)
    }

    @Transactional(readOnly = true)
    OAuth2Authentication readAuthentication(String token) {
        super.readAuthentication(token)
    }

    @Transactional(readOnly = true)
    void storeAccessToken(OAuth2AccessToken token, OAuth2Authentication authentication) {
        super.storeAccessToken(token, authentication)
    }

    @Transactional(readOnly = true)
    OAuth2AccessToken readAccessToken(String tokenValue) {
        super.readAccessToken(tokenValue)
    }

    @Transactional(readOnly = true)
    void removeAccessToken(OAuth2AccessToken token) {
        super.removeAccessToken(token)
    }

    @Transactional(readOnly = true)
    void removeAccessToken(String tokenValue) {
        super.removeAccessToken(tokenValue)
    }

    @Transactional(readOnly = true)
    void storeRefreshToken(OAuth2RefreshToken refreshToken, OAuth2Authentication authentication) {
        super.storeRefreshToken(refreshToken, authentication)
    }

    @Transactional(readOnly = true)
    OAuth2RefreshToken readRefreshToken(String tokenValue) {
        super.readRefreshToken(tokenValue)
    }

    @Transactional(readOnly = true)
    OAuth2Authentication readAuthenticationForRefreshToken(OAuth2RefreshToken token) {
        super.readAuthenticationForRefreshToken(token)
    }

    @Transactional(readOnly = true)
    void removeRefreshToken(String tokenValue) {
        super.removeRefreshToken(tokenValue)
    }

    @Transactional(readOnly = true)
    void removeAccessTokenUsingRefreshToken(OAuth2RefreshToken refreshToken) {
        super.removeAccessTokenUsingRefreshToken(refreshToken)
    }

    @Transactional(readOnly = true)
    OAuth2AccessToken getAccessToken(OAuth2Authentication authentication) {
        super.getAccessToken(authentication)
    }

    @Transactional(readOnly = true)
    Collection<OAuth2AccessToken> findTokensByClientIdAndUserName(String clientId, String userName) {
        super.findTokensByClientIdAndUserName(clientId, userName)
    }

    @Transactional(readOnly = true)
    Collection<OAuth2AccessToken> findTokensByClientId(String clientId) {
        super.findTokensByClientId(clientId)
    }

    @Transactional(readOnly = true)
    OAuth2AccessToken createOAuth2AccessToken(gormAccessToken) {
        super.createOAuth2AccessToken(gormAccessToken)
    }

    @Transactional(readOnly = true)
    OAuth2RefreshToken createRefreshTokenForAccessToken(gormAccessToken, refreshTokenPropertyName) {
        super.createRefreshTokenForAccessToken(gormAccessToken, refreshTokenPropertyName)
    }

    @Transactional(readOnly = true)
    OAuth2RefreshToken createOAuth2RefreshToken(gormRefreshToken) {
        super.createOAuth2RefreshToken(gormRefreshToken)
    }
}
