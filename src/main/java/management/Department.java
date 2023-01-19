package management;

import java.util.SortedSet;
import java.util.TreeSet;

import management.employees.Manager;
import management.employees.abstractions.Employee;

@SuppressWarnings("unused")
public class Department implements Comparable<Department> {
    private String _name;
    private final SortedSet<Employee> _employees = new TreeSet<>();
    private Manager _leader;

    public Department(String name, Manager leader) {
        this.setName(name);
        this.setLeader(leader);
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be null, empty or consists of white-spaces!");

        this._name = name;
    }

    public Manager getLeader() {
        return this._leader;
    }

    private void setLeader(Manager leader) {
        this._leader = leader;
    }

    public Manager changeLeader(Manager newLeader) {
        Manager oldLeader = this.getLeader();

        this.setLeader(newLeader);

        return oldLeader;
    }

    public SortedSet<Employee> getEmployees() {
        return this._employees;
    }

    public String getSalaryList() {
        StringBuilder builder = new StringBuilder("Gehaltsliste der Abteilung: " + this.getName() + "\n");

        for(Employee item : this.getEmployees()) {
            builder.append('(').append(item.getId()).append(") ")
                    .append(item.getName()).append(": ")
                    .append(item.income()).append("€\n");
        }

        return builder.toString();
    }

    @Override
    public int compareTo(Department department) {
        return this.getName().compareTo(department.getName());
    }
}