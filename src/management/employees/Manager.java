package management.employees;

public class Manager extends OfficeEmployee {
    private double _bonusRate;

    public Manager(int id, String name, double salary, double bonusRate) {
        super(id, name, salary);
        this.setBonusRate(bonusRate);
    }

    public double getBonusRate() {
        return this._bonusRate;
    }

    public void setBonusRate(double bonusRate) {
        if (bonusRate < 0) throw new IllegalArgumentException("Bonus rate cannot be less than 0!");

        this._bonusRate = bonusRate;
    }

    @Override
    protected void setId(int id) {
        if (id < 5000 || id > 5099) throw new IllegalArgumentException("Employee id must between 5000 and 5099!");

        super._id = id;
    }

    private double calculateBonus() {
        return super.getSalary() / 100 * this.getBonusRate();
    }

    @Override
    public double income() {
        return super.getSalary() + this.calculateBonus();
    }
}