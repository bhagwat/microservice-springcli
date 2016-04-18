@DependencyManagementBom('org.springframework.cloud:spring-cloud-starter-parent:Brixton.RC1')
@Grab('spring-cloud-starter-eureka-server')
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@RestController
class EmployeeApp {
    @RequestMapping("/")
    String home() {
        "Employee Micro-service"
    }
    @RequestMapping("/employees")
    List<Employee> list() {
        (1..10).collect{new Employee(name: "Employee" + it, age: it* 10)}
    }
}
class Employee{String name; Integer age}