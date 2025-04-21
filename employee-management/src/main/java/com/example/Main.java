package com.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Delete Employee");
            System.out.println("4. View Employee");
            System.out.println("5. View All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    Employee newEmployee = new Employee();
                    System.out.print("Enter name: ");
                    newEmployee.setName(scanner.nextLine());
                    System.out.print("Enter department: ");
                    newEmployee.setDepartment(scanner.nextLine());
                    System.out.print("Enter salary: ");
                    newEmployee.setSalary(scanner.nextDouble());
                    scanner.nextLine(); // consume newline
                    employeeDAO.saveEmployee(newEmployee);
                    break;
                case 2:
                    System.out.print("Enter employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    Employee updateEmployee = employeeDAO.getEmployee(updateId);
                    if (updateEmployee != null) {
                        System.out.print("Enter new name: ");
                        updateEmployee.setName(scanner.nextLine());
                        System.out.print("Enter new department: ");
                        updateEmployee.setDepartment(scanner.nextLine());
                        System.out.print("Enter new salary: ");
                        updateEmployee.setSalary(scanner.nextDouble());
                        scanner.nextLine(); // consume newline
                        employeeDAO.updateEmployee(updateEmployee);
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    employeeDAO.deleteEmployee(deleteId);
                    break;
                case 4:
                    System.out.print("Enter employee ID to view: ");
                    int viewId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    Employee viewEmployee = employeeDAO.getEmployee(viewId);
                    if (viewEmployee != null) {
                        System.out.println("ID: " + viewEmployee.getId());
                        System.out.println("Name: " + viewEmployee.getName());
                        System.out.println("Department: " + viewEmployee.getDepartment());
                        System.out.println("Salary: " + viewEmployee.getSalary());
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;
                case 5:
                    List<Employee> employees = employeeDAO.getAllEmployees();
                    for (Employee employee : employees) {
                        System.out.println("ID: " + employee.getId());
                        System.out.println("Name: " + employee.getName());
                        System.out.println("Department: " + employee.getDepartment());
                        System.out.println("Salary: " + employee.getSalary());
                        System.out.println("------------");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }
}