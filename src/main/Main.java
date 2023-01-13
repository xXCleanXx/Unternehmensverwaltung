package main;

import vehicles.PassengerTransport;
import management.Department;
import management.Unternehmensverwaltung;
import management.employees.OfficeEmployee;
import management.employees.Manager;
import management.employees.ShiftEmployee;
import management.employees.abstractions.Employee;
import views.MainWindow;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Window mainWindow = new MainWindow();
    }

    private static void geometry() {

    }

    private static void management() {
        Department buchhaltung = new Department("Buchhaltung", new Manager(5000, "Gustav Schmidt", 11000, 1.8));
        Employee b1 = new ShiftEmployee(3000, "Anika Stammnitz", 8, 12);
        buchhaltung.getEmployees().add(b1);

        Department entwicklung = new Department("Entwicklung", new Manager(5001, "Max Mustermann", 14000, 1.2));
        Employee e1 = new OfficeEmployee(5102,"Test2", 250);
        Employee e2 = new OfficeEmployee(5101,"Test1", 250);
        entwicklung.getEmployees().add(e1);
        entwicklung.getEmployees().add(e2);

        Unternehmensverwaltung uv = Unternehmensverwaltung.getInstance();
        uv.getDepartments().add(buchhaltung);
        uv.getDepartments().add(entwicklung);

        PassengerTransport p2 = new PassengerTransport(100, 20);
        p2.einsteigen(e1);
        p2.einsteigen(e2);
        PassengerTransport p1 = new PassengerTransport(100, 20);
        p1.einsteigen(b1);

        List<Employee> list = new ArrayList<>();
        list.add(b1);
        list.add(e1);
        list.add(e2);
        list.sort(new Employee.IncomeComparator());
    }
}