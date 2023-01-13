package vehicles.abstractions;

import driverlicense.DriverLicenseTypes;
import vehicles.GPS;
import management.employees.Driver;
import management.employees.abstractions.Employee;

@SuppressWarnings("unused")
public abstract class Vehicle implements Comparable<Vehicle> {
    private int _maxTank;
    private int _tank;
    private GPS _position;
    private boolean _engineState;
    private Employee[] _passengers;
    private Driver _driver;
    private int _maxSpeed;
    private int _speed;

    public Vehicle(int tankSize, int amountSeats) {
        this.setMaxTank(tankSize);
        this.setPassengers(amountSeats);
    }

    public Employee[] getPassengers() {
        return this._passengers;
    }

    protected void setPassengers(int size) {
        if (size < 1) throw new IllegalArgumentException();

        this._passengers = new Employee[size];
    }

    public Driver getDriver() {
        return this._driver;
    }

    protected void setDriver(Driver driver) {
        this._driver = driver;
    }

    public int getMaxTank() {
        return this._maxTank;
    }

    protected void setMaxTank(int maxTank) {
        this._maxTank = maxTank;
    }

    public int getTank() {
        return this._tank;
    }

    public int tanken(int amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be less than 0!");

        int size = this.getTank() + amount;

        if (size > this.getMaxTank()) {
            this._tank = this.getMaxTank();

            return size - this.getMaxTank();
        }

        this._tank = size;

        return 0;
    }

    public GPS getPosition() {
        return this._position;
    }

    public void driveTo(GPS position) {
        if (position == null) throw new IllegalArgumentException("GPS position cannot be null!");
        if (!this.isEngineEnabled()) throw new RuntimeException("Fahrzeug ist aus!");

        this._position = position;
    }

    public boolean isEngineEnabled() {
        return this._engineState;
    }

    public void setEngineEnabled(boolean flag) {
        this._engineState = flag;
    }

    public int getAmountOfSeats() {
        return this.getPassengers().length;
    }

    public int getMaxSpeed() {
        return this._maxSpeed;
    }

    protected void setMaxSpeed(int speed) {
        if (speed < 0) throw new IllegalArgumentException("Max speed limit cannot be less than 0!");

        this._maxSpeed = speed;
    }

    public int getSpeed() {
        return this._speed;
    }

    protected void setSpeed(int speed) {
        this._speed = speed;
    }

    protected boolean exists(Employee passenger) {
        if (passenger == null) throw new IllegalArgumentException("Passenger cannot be null!");

        for (Employee item : this.getPassengers()) {
            if (item != null && item.getId() == passenger.getId()) {
                return true;
            }
        }

        return false;
    }

    public void einsteigenFahrer(Driver driver, DriverLicenseTypes führerscheinklasse) {
        if (driver == null) throw new IllegalArgumentException("Driver cannot be null!");
        if (!driver.checkLicense(führerscheinklasse)) throw new IllegalArgumentException("Fahrer hat keine gültige Führerscheinklasse!");
        if (this.getDriver() != null) throw new IllegalArgumentException("Es ist bereits ein Fahrer im Fahrzeug!");
        if (this.exists(driver)) throw new IllegalArgumentException("Fahrer ist bereits Passagier!");

        this.setDriver(driver);
    }

    public void austeigenFahrer() {
        this.setDriver(null);
    }

    public void einsteigen(Employee passenger) {
        if (passenger == null) throw new IllegalArgumentException("Passenger cannot be null!");
        if (this.getDriver() != null && this.getDriver().getId() == passenger.getId()) throw new IllegalArgumentException("Passagier ist der Fahrer!");
        if (this.exists(passenger)) throw new IllegalArgumentException("Passagier ist bereits im Fahrzeug!");

        for (int i = 0; i < this.getAmountOfSeats(); i++) {
            if (this.getPassengers()[i] == null) {
                this.getPassengers()[i] = passenger;

                break;
            }
        }
    }

    public void aussteigen(int seatId) {
        if (seatId < 1 || seatId > this.getAmountOfSeats()) throw new IndexOutOfBoundsException("Id kann nicht kleiner als 0 sein oder größer als die maximale Anzahl der Sitze!");

        this.getPassengers()[seatId] = null;
    }

    public void parken() {
        for (int i = 0; i < this.getAmountOfSeats(); i++) {
            this.getPassengers()[i] = null;
        }

        this.austeigenFahrer();
        this.setEngineEnabled(false);
    }

    public abstract float getUtilization();

    public void bremsen() {
        this._speed = 0;
    }

    public void bremsen(int speed) {
        if (speed < 0) throw new IndexOutOfBoundsException("Speed cannot be less than 0!");

        this.setSpeed(Math.max(this.getSpeed() - speed, 0));
    }

    public void beschleunigen(int speed) {
        if (speed < 0) throw new IndexOutOfBoundsException("Speed cannot be less than 0!");
        if (!this.isEngineEnabled()) throw new RuntimeException("Fahrzeug ist aus!");

        this.setSpeed(Math.min(speed + this.getSpeed(), this.getMaxSpeed()));
    }

    public int compareTo(Vehicle kfz) {
        if (kfz == null) throw new NullPointerException();

        return Float.compare(this.getUtilization(), kfz.getUtilization());
    }
}