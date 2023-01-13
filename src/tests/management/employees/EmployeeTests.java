package tests.management.employees;

import driverlicense.DriverLicense;
import driverlicense.DriverLicenseTypes;
import management.employees.Driver;
import management.employees.Manager;
import management.employees.OfficeEmployee;
import management.employees.ShiftEmployee;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class EmployeeTests {
    @Test
    public void shiftEmployeeTest() {
        ShiftEmployee shiftEmployee = new ShiftEmployee(3000, "Johannes Vogel", 8 * 30, 15);

        assertEquals("Johannes Vogel", shiftEmployee.getName());
        assertEquals(3000, shiftEmployee.getId());
        assertEquals(15, shiftEmployee.getHourlyRate());
        assertEquals(8 * 30, shiftEmployee.getHours());
        assertEquals(3600, shiftEmployee.income());
    }

    @Test
    public void managerTest() {
        Manager manager = new Manager(5001, "Karl-Heinz Geye", 5000, 2);

        assertEquals("Karl-Heinz Geye", manager.getName());
        assertEquals(5001, manager.getId());
        assertEquals(2, manager.getBonusRate());
        assertEquals(5100, manager.income());
        assertThrows(IllegalArgumentException.class, () -> manager.setBonusRate(-1));
    }

    @Test
    public void officeEmployeeTest() {
        OfficeEmployee officeEmployee = new OfficeEmployee(5101, "Eduard Hermann", 3600);

        assertEquals("Eduard Hermann", officeEmployee.getName());
        assertEquals(5101, officeEmployee.getId());
        assertEquals(3600, officeEmployee.income());
    }

    @Test
    public void driverTest() {
        DriverLicense driverLicense = new DriverLicense();
        driverLicense.getDriverLicenseTypes().add(DriverLicenseTypes.B);
        Driver driver = new Driver(3000, "Johannes Vogel", 8 * 30, 15, driverLicense);

        assertEquals(driverLicense, driver.getDriverLicense());
        assertTrue(driver.checkLicense(DriverLicenseTypes.B));
        assertFalse(driver.checkLicense(DriverLicenseTypes.D));
    }
}