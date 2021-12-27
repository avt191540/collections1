package pro.sky.collections1.service;

import org.springframework.stereotype.Service;
import pro.sky.collections1.DataMatchException;
import pro.sky.collections1.Employee;
import pro.sky.collections1.NotFoundException;
import pro.sky.collections1.OverflowArrayException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employee = new ArrayList<>();

    @Override
    public String addEmployeeToList(String firstName, String lastName, int department, double salary) {
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
        Employee employee1 = new Employee(firstName, lastName, department, salary);
        if (employee.contains(employee1)) {
            employee.remove(employee1);
            return (employee1.toString());
        } else
            throw new NotFoundException();
    }
    @Override
    public Employee findEmployeeInList(String firstName, String lastName, int department, double salary) {
        Employee employee1 = new Employee(firstName, lastName, department, salary);
        if (employee.contains(employee1)) {
            return (employee1);
        }
        throw new NotFoundException();
    }

    //Поиск сотрудника с минимальной зарплатой в указанном отделе
    public static Employee searchEmployeeDepartmentMinSalary(int department) {
        int indexEmployee = 0; //Индекс сотрудника
        if (numberEmployeesDepartment(department) == 0) {
            System.out.print("Такого отдела нет! ");
            return null;
        }
        double minSalaryDepartment = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                continue;
            } else if ((minSalaryDepartment == 0 || employees[i].getSalary() < minSalaryDepartment) && employees[i].getDepartment() == department) {
                //Если для этого отдела первая не нулевая ячейка массива или зарплата меньше минимальной
                minSalaryDepartment = employees[i].getSalary();
                indexEmployee = i;
            }
        }
        return employees[indexEmployee];
        //Если несколько сотрудников с минимальной з/п, тогда возвращается первый по списку
}
