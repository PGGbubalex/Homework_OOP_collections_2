package Transport;

import Driver.Driver;

import java.util.*;

public abstract class Car {
    private final String brand;
    private final String model;
    private final double engineCapacity;
    private final Set<Driver> drivers = new HashSet<>();
    private final Set<Mechanic> mechanics = new HashSet<>();
    private final Set<Sponsor> sponsors = new HashSet<>();


    public Car(String brand, String model, double engineCapacity) {

        this.brand = ValidationUtill.validateString(brand);
        this.model = ValidationUtill.validateString(model);
        this.engineCapacity = ValidationUtill.validatePower(engineCapacity);
    }

    public void addDriver(Driver <?> driver) {
        drivers.add(driver);
    }

    public void addMechanic(Mechanic <?>... mechanics) {
        this.mechanics.addAll(Arrays.asList(mechanics));
    }

    public void addSponsor(Sponsor... sponsors) {
        this.sponsors.addAll(Arrays.asList(sponsors));
    }

    public Set<Driver> getDrivers() {
        return drivers;
    }

    public Set<Mechanic> getMechanics() {
        return mechanics;
    }

    public Set<Sponsor> getSponsors() {
        return sponsors;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public abstract void startMove();

    public abstract void finishMovement();

    public abstract boolean service();

    public abstract void repair();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineCapacity, engineCapacity) == 0 && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineCapacity);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineCapacity=" + engineCapacity +
                '}';
    }

}
