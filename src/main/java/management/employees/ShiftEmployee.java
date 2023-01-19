package management.employees;

import management.employees.abstractions.Employee;

public class ShiftEmployee extends Employee {
    private double _hourlyRate;
    private int _hours;

    public ShiftEmployee(int id, String name, int hours, double hourlyRate) {
        super(id, name);
        this.setHourlyRate(hourlyRate);
        this.setHours(hours);
    }

    public double getHourlyRate() {
        return this._hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this._hourlyRate = hourlyRate;
    }

    @Override
    protected void setId(int id) {
        if (id < 3000 || id > 3999) throw new IllegalArgumentException("Employee id must between 3000 and 39999!");

        super._id = id;
    }

    public int getHours() {
        return this._hours;
    }

    public void setHours(int hours) {
        this._hours = hours;
    }

    @Override
    public double income() {
        return this.getHourlyRate() * this.getHours();
    }
}