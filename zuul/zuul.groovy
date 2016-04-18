@DependencyManagementBom('org.springframework.cloud:spring-cloud-starter-parent:Brixton.RC1')
@Grab('spring-cloud-starter-eureka-server')
@Grab('spring-cloud-starter-zuul')

@org.springframework.cloud.netflix.zuul.EnableZuulProxy
class Zuul {}