package pro.sky.collections1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.collections1.Employee;
import pro.sky.collections1.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam String firstName, @RequestParam String lastName) {
        return ("В списке <Сотрудники> создан сотрудник: "
                + employeeService.addEmployeeToList(firstName, lastName) + ".");
    }
    @GetMapping("/remove")
    public String remove(@RequestParam String firstName, @RequestParam String lastName) {
        return ("В списке <Сотрудники> удален сотрудник: "
                + employeeService.removeEmployeeFromList(firstName, lastName));
    }
    @GetMapping("/find")
    public Employee find(@RequestParam String firstName, @RequestParam String lastName) {
        return (employeeService.findEmployeeInList(firstName, lastName));
    }
    @GetMapping("/size")
    public String size() {
        return ("Количество записей в списке <Сотрудники>: "
                + employeeService.sizeEmployeeList());
    }
    @GetMapping("/print")
    public List print() {
        return (employeeService.printList());
    }
}
