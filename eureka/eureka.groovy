@DependencyManagementBom('org.springframework.cloud:spring-cloud-starter-parent:Brixton.RC1')
@Grab('spring-cloud-starter-eureka-server')

@org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
class Eureka {}