package pro.sky.collections1.service;

import pro.sky.collections1.Employee;

import java.util.List;

public interface EmployeeService {

    String removeEmployeeFromList(String firstName, String lastName);

    Employee findEmployeeInList(String firstName, String lastName);

    String addEmployeeToList(String firstName, String lastName);

    int sizeEmployeeList();

    List printList();
}
