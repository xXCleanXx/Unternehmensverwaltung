package management.employees;

import driverlicense.DriverLicense;
import driverlicense.DriverLicenseTypes;

public class Driver extends ShiftEmployee {
    private DriverLicense _driverLicense;

    public Driver(int id, String name, int hours, double hourlyRate, DriverLicense driverLicense) {
        super(id, name, hours, hourlyRate);
        this.setDriverLicense(driverLicense);
    }

    public DriverLicense getDriverLicense() {
        return this._driverLicense;
    }

    private void setDriverLicense(DriverLicense driverLicense) {
        this._driverLicense = driverLicense;
    }

    public boolean checkLicense(DriverLicenseTypes driverLicenseTypes) {
        return this.getDriverLicense() != null && this.getDriverLicense().getDriverLicenseTypes().contains(driverLicenseTypes);
    }
}