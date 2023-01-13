package vehicles;

import vehicles.abstractions.Vehicle;
import management.employees.abstractions.Employee;

public class PassengerTransport extends Vehicle {
    public PassengerTransport(int tankSize, int amountSeats) {
        super(tankSize, amountSeats);
    }

    @Override
    public float getUtilization() {
        int count = 0;

        for (Employee item : super.getPassengers())
            if (item != null) count++;

        return 100f / super.getAmountOfSeats() * count;
    }
}
