package pro.sky.collections1.service;

import pro.sky.collections1.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    String removeEmployeeFromList(String firstName, String lastName, int department, double salary);

    Employee findEmployeeInList(String firstName, String lastName, int department, double salary);

    String addEmployeeToList(String firstName, String lastName, int department, double salary);

    int sizeEmployeeList();

    List printList();

    Employee searchEmployeeDepartmentMinSalary(int department);

    Employee searchEmployeeDepartmentMaxSalary(int department);

    List getAllEmployeesOfDepartment(int department);

    List getEmployeesByDepartments();

    Map getMapEmployeesByDepartments();

    boolean checkingInputTextData();

}
