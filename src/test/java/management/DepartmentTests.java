package management;

import management.Department;
import management.employees.Manager;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DepartmentTests {
    @Test
    public void departmentTest() {
        Manager manager = new Manager(5001, "Karl-Heinz Geye", 5000, 0.2);

        Department department = new Department("AE", manager);

        assertEquals("AE", department.getName());
        assertEquals(manager, department.getLeader());

        Manager newManager = new Manager(5002, "Hans Böckler", 5100, 0.2);

        assertDoesNotThrow(() -> department.changeLeader(newManager));

        assertEquals(newManager, department.getLeader());
    }
}