@DependencyManagementBom('org.springframework.cloud:spring-cloud-starter-parent:Brixton.RC1')
@Grab('spring-cloud-starter-eureka-server')

import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import java.security.Principal

@EnableEurekaClient
@EnableResourceServer
@RestController
class EmployeeApp {
    @RequestMapping("/")
    Map home(@RequestHeader(value = "Authorization") String authorizationHeader, Principal currentUser) {
        [app: "Employee Micro-service", currentUser: currentUser.getName(), auth: authorizationHeader]
    }

    @RequestMapping("/employees")
    List<Employee> list() {
        (1..10).collect { new Employee(name: "Employee" + it, age: it * 10) }
    }
}

class Employee {
    String name;
    Integer age
}