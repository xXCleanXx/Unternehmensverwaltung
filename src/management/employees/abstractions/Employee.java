package management.employees.abstractions;

import java.util.Comparator;

public abstract class Employee implements Comparable<Employee> {
    protected int _id;
    private String _name;

    public Employee(int id, String name) {
        this.setId(id);
        this.setName(name);
    }
    
    public int getId() {
        return this._id;
    }
    
    protected void setId(int id) {
        if (id < 1000 || id > 9999) throw new IllegalArgumentException("Employee id must between 1000 and 9999!");

        this._id = id;
    }
    
    public String getName() {
        return this._name;
    }
    
    public void setName(String name) {
        this._name = name;
    }

    public abstract double income();

    public int compareTo(Employee employee) {
        if (employee == null) throw new NullPointerException("Employee cannot be null!");

        return this.getName().compareTo(employee.getName());
    }

    public static class IncomeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee employee1, Employee emplozee2) {
            return Double.compare(employee1.income(), emplozee2.income());
        }
    }
}