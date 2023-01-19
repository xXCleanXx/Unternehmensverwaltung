package vehicles;

@SuppressWarnings("unused")
public class GPS {
    private int _longitude;
    private int _latitude;

    public GPS(int longitude, int latitude) {
        this.setLongitude(longitude);
        this.setLatitude(latitude);
    }

    public int getLongitude() {
        return this._longitude;
    }

    public void setLongitude(int longitude) {
        if (longitude < -90 || longitude > 90) throw new IllegalArgumentException();

        this._longitude = longitude;
    }

    public int getLatitude() {
        return this._latitude;
    }

    public void setLatitude(int latitude) {
        if (latitude < 0 || latitude >= 360) throw new IllegalArgumentException();

        this._latitude = latitude;
    }
}