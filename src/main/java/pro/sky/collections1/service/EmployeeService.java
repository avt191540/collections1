package pro.sky.collections1.service;

import pro.sky.collections1.Employee;

import java.util.List;

public interface EmployeeService {

    String removeEmployeeFromList(String firstName, String lastName, int department, double salary);

    Employee findEmployeeInList(String firstName, String lastName, int department, double salary);

    String addEmployeeToList(String firstName, String lastName, int department, double salary);

    int sizeEmployeeList();

    List printList();

    Employee searchEmployeeDepartmentMinSalary(int department);
}
