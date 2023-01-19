package driverlicense;

import java.util.SortedSet;
import java.util.TreeSet;

@SuppressWarnings("unused")
public class DriverLicense {
    private final SortedSet<DriverLicenseTypes> _driverLicenseTypes = new TreeSet<>();

    public SortedSet<DriverLicenseTypes> getDriverLicenseTypes() {
        return this._driverLicenseTypes;
    }
}