package pro.sky.collections1.service;

import org.springframework.stereotype.Service;
import pro.sky.collections1.Employee;
import pro.sky.collections1.NotFoundException;
import pro.sky.collections1.OverflowArrayException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List employee = new ArrayList();

    @Override
    public String addEmployeeToList(String firstName, String lastName) {
        Employee employee1 = new Employee(firstName, lastName);
        employee.add(employee1);
        return (employee1.toString());
    }
    @Override
    public int sizeEmployeeList() {
        int numberEmployees = employee.size();
        return numberEmployees;
    }
    @Override
    public List printList() {
        return employee;
    }
    @Override
    public String removeEmployeeFromList(String firstName, String lastName) {
        Employee employee1 = new Employee(firstName, lastName);
        if (employee.contains(employee1)) {
            employee.remove(employee1);
            return (employee1.toString());
        } else
            throw new NotFoundException();
    }
    @Override
    public Employee findEmployeeInList(String firstName, String lastName) {
        Employee employee1 = new Employee(firstName, lastName);
        if (employee.contains(employee1)) {
            return (employee1);
        }
        throw new NotFoundException();
    }
}
