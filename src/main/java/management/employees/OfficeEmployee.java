package management.employees;

import management.employees.abstractions.Employee;

public class OfficeEmployee extends Employee {
    private double _salary;

    public OfficeEmployee(int id, String name, double salary) {
        super(id, name);
        this.setSalary(salary);
    }

    protected double getSalary() {
        return this._salary;
    }

    protected void setSalary(double salary) {
        this._salary = salary;
    }

    @Override
    public double income() {
        return this.getSalary();
    }

    @Override
    protected void setId(int id) {
        if (id < 5100 || id > 5999) throw new IllegalArgumentException();

        super._id = id;
    }
}