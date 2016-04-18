import org.springframework.cloud.client.loadbalancer.LoadBalanced
@DependencyManagementBom('org.springframework.cloud:spring-cloud-starter-parent:Brixton.RC1')
@Grab('spring-cloud-starter-eureka-server')
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
@DependencyManagementBom('org.springframework.cloud:spring-cloud-starter-parent:Brixton.RC1')
@Grab('spring-cloud-starter-eureka-server')
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
@DependencyManagementBom('org.springframework.cloud:spring-cloud-starter-parent:Brixton.RC1')
@Grab('spring-cloud-starter-eureka-server')
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.context.annotation.Bean
import org.springframework.core.ParameterizedTypeReference
import org.springframework.web.client.RestTemplate

@EnableEurekaClient
class LibraryApp {
    @Bean
    @LoadBalanced
    RestTemplate loadBalanced() {
        return new RestTemplate();
    }
}

@RestController
class LibraryController {
    @Autowired
    @LoadBalanced
    RestTemplate loadBalanced

    @RequestMapping("/")
    String home() {
        "Library Micro-service"
    }

    @RequestMapping("/employee/{employeeId}")
    public Employee get(@PathVariable Integer employeeId) {
        List<Employee> employees = loadBalanced.exchange(
                "http://employee-service/employees",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Employee>>() {
                },
                (Object) "mstine"
        ).getBody()
        return employees[employeeId - 1]
    }
}

class Employee {
    String name;
    Integer age
}