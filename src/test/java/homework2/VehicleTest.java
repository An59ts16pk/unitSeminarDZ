package homework2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    public homework2.Car car;
    public homework2.Motorcycle motorcycle;

    @BeforeEach
    public void init() {
        car = new Car("Audi", "Q6", 2022);
        motorcycle = new Motorcycle("Honda", "CB1000R", 2021);
    }

    @Test
    @DisplayName("Объект Car является экземпляром транспортного средства")
    public void testCarInstanceVehicle() {
        assertInstanceOf(Vehicle.class, car);
    }

    @Test
    @DisplayName("Проверяем Car создаётся с 4 колёсами")
    public void testCarHasWheels() {
        assertEquals(4, car.getNumWheels());
    }

    @Test
    @DisplayName("Проверяем Motorcycle создаётся с 2 колёсами")
    public void testMotorcycleHasWheels() {
        assertEquals(2, motorcycle.getNumWheels());
    }

    @Test
    @DisplayName("Скорость тестового вождения Car - 60")
    public void testCarSpeed() {
        car.testDrive();
        assertEquals(60, car.getSpeed());
    }

    @Test
    @DisplayName("Скорость тестового вождения Motorcycle - 75")
    public void testMotorcycleSpeed() {
        motorcycle.testDrive();
        assertEquals(75, motorcycle.getSpeed());
    }

    @Test
    @DisplayName("Праверяем у Car после парковки скорость - 0")
    public void testCarSpeedAfterStop() {
        car.testDrive();
        car.park();
        assertEquals(0, car.getSpeed());
    }

    @Test
    @DisplayName("Праверяем у Motorcycle после парковки скорость - 0")
    public void testMotorcycleSpeedAfterStop() {
        motorcycle.testDrive();
        motorcycle.park();
        assertEquals(0, motorcycle.getSpeed());
    }
}