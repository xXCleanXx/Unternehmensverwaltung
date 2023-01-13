package management;

import java.io.*;
import java.util.*;

import components.abstractions.Subject;
import vehicles.abstractions.Vehicle;
import management.employees.ShiftEmployee;
import management.employees.abstractions.Employee;

@SuppressWarnings("unused")
public final class Unternehmensverwaltung extends Subject {
    private static Unternehmensverwaltung _instance;
    private final List<Vehicle> _vehicles = new ArrayList<>();
    private final List<Employee> _employees = new ArrayList<>();
    private final SortedSet<Department> _departments = new TreeSet<>();
    private final LinkedList<ShiftEmployee> _shiftEmployees = new LinkedList<>();

    private Unternehmensverwaltung() {
        this.getEmployees().add(new ShiftEmployee(3500, "Test", 50, 2.55));
        this.getEmployees().add(new ShiftEmployee(3501, "Test2", 50, 2.55));
        this.getEmployees().add(new ShiftEmployee(3502, "Test3", 50, 2.55));
        this.getEmployees().add(new ShiftEmployee(3503, "Test4", 50, 2.55));
    }

    public static Unternehmensverwaltung getInstance() {
        if (_instance == null) _instance = new Unternehmensverwaltung();

        return _instance;
    }

    public List<Employee> getEmployees() {
        return this._employees;
    }

    public boolean addPersonal(Employee employee) {
        if (employee == null) throw new NullPointerException("Employee cannot be null!");
        if (this.containsPersonal(employee)) return false;

        if (employee instanceof ShiftEmployee) this.addShiftEmployee((ShiftEmployee) employee);

        this.getEmployees().add(employee);


        return true;
    }

    private List<String> loadEmployeesFromCsv() {
        File file = new File("H:\\Erdweg_Seb\\SUD\\Java\\Unternehmensverwaltungssystem\\Employees");

        if (file.exists()) {
            try(BufferedReader fr = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
                List<String> list = new ArrayList<>();

                while(fr.read() >= 0) {
                    list.add(fr.readLine());
                }

                return list;
            } catch(IOException e) {
                System.out.println(e.getMessage());

                return null;
            }
        }

        return new ArrayList<>();
    }

    public void loadEmployees() {
        List<String> list = this.loadEmployeesFromCsv();

        if (list != null) {
            for(String item : list) {
                String[] emp = item.split(",");

                switch(emp[emp.length - 1]) {
                    case "Schichtarbeiter":
                    case "Manager":
                    case "Fahrer":
                    case "Bueroarbeiter":

                        break;
                }
            }
        }

    }

    private void saveAsCSV() {
        File file = new File("H:\\Erdweg_Seb\\SUD\\Java\\Unternehmensverwaltungssystem\\Employees");

        if (!file.exists()) {
            try (FileWriter fw = new FileWriter(file)) {
                for(Employee item : this.getEmployees()) {
                    StringBuilder sb = new StringBuilder();
                    List<String> list = toStringList(item);

                    for(int i = 0; i < list.size(); i++) {
                        sb.append(list.get(i));

                        if (i < list.size() - 1) {
                            sb.append(",");
                            continue;
                        }

                        sb.append("\n");
                    }

                    fw.append(sb.toString());
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<String> toStringList(Employee employee) {
        List<String> list = new ArrayList<>();
        list.add(Integer.toString(employee.getId()));
        list.add(employee.getName());
        list.add(Double.toString(employee.income()));
        list.add(employee.getClass().getTypeName());

        return list;
    }

    public boolean removePersonal(Employee employee) {
        if (employee == null) throw new IllegalArgumentException("Mitarbeiter cannot be null!");
        if (this.containsPersonal(employee)) return false;

        this.getEmployees().remove(employee);

        return true;
    }

    public boolean containsPersonal(Employee employee) {
        for (Employee item : this.getEmployees()) {
            if (item.compareTo(employee) == 0) return true;
        }

        return false;
    }

    public LinkedList<ShiftEmployee> getShiftEmployees() {
        return this._shiftEmployees;
    }

    public boolean addShiftEmployee(ShiftEmployee shiftEmployee) {
        if (shiftEmployee == null) throw new NullPointerException("ShiftEmployee cannot be null!");
        if (this.getShiftEmployees().contains(shiftEmployee)) return false;

        this.getShiftEmployees().add(shiftEmployee);

        return true;
    }

    public boolean removeShiftEmployee(ShiftEmployee shiftEmployee) {
        if (shiftEmployee == null) throw new NullPointerException("ShiftEmployee cannot be null!");
        if (!this.getShiftEmployees().contains(shiftEmployee)) return false;

        return this.getShiftEmployees().remove(shiftEmployee);
    }

    public Employee getEmployeeById(int id) {
        if (id < 1000 || id > 9999) throw new IllegalArgumentException("Employee id must between 1000 and 9999!");

        for (Employee item : this.getEmployees()) {
            if (item.getId() == id) return item;
        }

        return null;
    }

    public List<Vehicle> getVehicles() {
        return this._vehicles;
    }

    public void addVehicle(Vehicle vehicle) {
        if (vehicle == null) throw new IllegalArgumentException("Vehicle cannot be null!");

        this.getVehicles().add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        if (vehicle == null) throw new IllegalArgumentException("Vehicle cannot be null!");

        this.getVehicles().remove(vehicle);
    }

    public void PrintDepartments() {
        for (Department item : this.getDepartments()) {
            System.out.println(item.getName());
        }
    }

    public SortedSet<Department> getDepartments() {
        return this._departments;
    }
}