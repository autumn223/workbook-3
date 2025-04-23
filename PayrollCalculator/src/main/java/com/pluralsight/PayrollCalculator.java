package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PayrollCalculator {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        String filePath = "employee_data.csv";

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufReader = new BufferedReader(fileReader);

            String line;
            bufReader.readLine(); 

            while ((line = bufReader.readLine()) != null) {
                String[] data = line.split("\\|");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double hoursWorked = Double.parseDouble(data[2]);
                double payRate = Double.parseDouble(data[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                employees.add(employee);
            }

            bufReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Employee employee : employees) {
            System.out.printf("Employee ID: %d, Name: %s, Gross Pay: $%.2f\n",
                    employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
        }
    }
}
