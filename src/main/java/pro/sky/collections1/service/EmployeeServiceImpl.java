package pro.sky.collections1.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.collections1.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employee = new ArrayList<>();

    @Override
    public String addEmployeeToList(String firstName, String lastName, int department, double salary) {
        firstName = checkingInputTextData(firstName);
        lastName = checkingInputTextData(lastName);
        Employee employee1 = new Employee(firstName, lastName, department, salary);
        if (employee.contains(employee1)) {
            throw new DataMatchException();
        }
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
    public String removeEmployeeFromList(String firstName, String lastName, int department, double salary) {
        firstName = checkingInputTextData(firstName);
        lastName = checkingInputTextData(lastName);
        Employee employee1 = new Employee(firstName, lastName, department, salary);
        if (employee.contains(employee1)) {
            employee.remove(employee1);
            return (employee1.toString());
        } else
            throw new NotFoundException();
    }
    @Override
    public Employee findEmployeeInList(String firstName, String lastName, int department, double salary) {
        firstName = checkingInputTextData(firstName);
        lastName = checkingInputTextData(lastName);
        Employee employee1 = new Employee(firstName, lastName, department, salary);
        if (employee.contains(employee1)) {
            return (employee1);
        }
        throw new NotFoundException();
    }
    //Поиск сотрудника с максимальной зарплатой в указанном отделе
    @Override
    public Employee searchEmployeeDepartmentMaxSalary(int department) {
        return employee.stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Value is null"));
    }
    //Поиск сотрудника с минимальной зарплатой в указанном отделе
    @Override
    public Employee searchEmployeeDepartmentMinSalary(int department) {
        return employee.stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow(() -> new RuntimeException("Value is null"));
    }
    //Получение информации о всех сотрудниках указанного отдела
    @Override
    public List getAllEmployeesOfDepartment(int department) {
        return employee.stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }
    //Получение информации о сотрудниках по отделам
    @Override
    public List getEmployeesByDepartments() {
        return employee.stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .collect(Collectors.toList());
    }
    //Получение информации о сотрудниках по отделам - вариант с Map
    @Override
    public Map getMapEmployeesByDepartments() {
        Map<Integer, List<Employee>> map = employee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return map;
    }
    //Проверка вводимого текста (наличие только букв) и установка заглавной первой буквы
    @Override
    public String checkingInputTextData(String text) {
        if (!StringUtils.isAlpha(text)) {
            throw new InvalidInputData();
        } else text = StringUtils.capitalize(text);
        return text;
    }
}
