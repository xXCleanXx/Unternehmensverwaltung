package vehicles;

import vehicles.abstractions.Vehicle;

@SuppressWarnings("unused")
public class Truck extends Vehicle {
    private float _maxLadefläche;
    private float _ladefläche;

    public Truck(int tankSize, int amountSeats, float ladefläche) {
        super(tankSize, amountSeats);
        this.setMaxLadefläche(ladefläche);
    }
    
    public float getMaxLadefläche() {
        return this._maxLadefläche;
    }

    private void setMaxLadefläche(float amount) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be less than 0!");

        this._maxLadefläche = amount;
    }

    public float getLadefläche() {
        return this._ladefläche;
    }

    private void setLadefläche(float amount) {
        if (amount < 0 || amount > this.getMaxLadefläche()) throw new IllegalArgumentException("Amount cannot be less than 0 or greater than the max loading amount!");

        this._ladefläche = amount;
    }

    public void load(float amount) {
        if (amount < 0 || amount + this.getLadefläche() > this.getMaxLadefläche()) throw new IllegalArgumentException("Amount cannot be less than 0 or the amount plus the loading amount cannot be greater than the max loading amount!");

        this.setLadefläche(this.getLadefläche() + amount);
    }

    public void unload(float amount) {
        if (amount < 0 || amount > this.getLadefläche()) throw new IllegalArgumentException("Amount cannot be less than 0 or greater than the loading amount!");

        this.setLadefläche(this.getLadefläche() - amount);
    }

    @Override
    public float getUtilization() {
        return this.getMaxLadefläche() / 100 * this.getLadefläche();
    }
}