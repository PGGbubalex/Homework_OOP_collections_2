import Driver.Driver_B;
import Driver.Driver_C;
import Driver.Driver_D;
import MultiplicationTable.Example;
import Passport.Passport;
import TransoptEnum.BodyType;
import TransoptEnum.CapacityType;
import TransoptEnum.LoadCapacity;
import Transport.*;
import Passport.PassportList;

import java.time.LocalDate;
import java.util.*;

public class Test {
    public static void main(String[] args) {


        Products banana = new Products("Банан", 3, 1);
        Products apple = new Products("Яблоко", 2, 2);
        Products peach = new Products("Персик", 12.2f, 3);
        Products orange = new Products("Апельсин", 14.5f, 4);

        ProductList shopList1 = new ProductList();
        shopList1.addProduct(apple);
        shopList1.addProduct(peach);
        shopList1.addProduct(orange);
        shopList1.addProduct(banana);

//        System.out.println(shopList1);

        ProductList shopList2 = new ProductList();
        shopList2.addProduct(banana);
        shopList2.addProduct(apple);
        shopList2.addProduct(peach);
        shopList2.addProduct(orange);

//        System.out.println(shopList2);

        Recipe salad = new Recipe("Салат", 123, shopList2);

        Recipe salad2 = new Recipe("Салат 2", 170, shopList2);

        Recipe salad3 = new Recipe("Салат", 170, shopList2);

        RecipeList recipeList = new RecipeList();
        recipeList.addRecipe(salad);
        recipeList.addRecipe(salad2);
//        recipeList.addRecipe(salad3);

        System.out.println(recipeList);

        System.out.println("===========================================");


        Random random = new Random();
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 20) {
            numbers.add(random.nextInt(1000));
        }
        System.out.println(numbers);



        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer number = iterator.next();
            if (number % 2 == 1) {
                iterator.remove();
            }
        }
        System.out.println(numbers);

        System.out.println("-----------------------------------------");

        Sponsor sponsor1 = new Sponsor("Спонсор 1", 2000000);
        Sponsor sponsor2 = new Sponsor("Спонсор 2", 1800000);
        Sponsor sponsor3 = new Sponsor("Спонсор 3", 3400000);

        Mechanic mechanic1 = new Mechanic<PassengerCars>("Петр", "Васильев", "Компания 1");
        Mechanic mechanic2 = new Mechanic<PassengerCars>("Иван", "Васильев", "Компания 2");
        Mechanic mechanic3 = new Mechanic<PassengerCars>("Иван", "Васильев", "Компания 2");
        Mechanic mechanic4 = new Mechanic<Trucks>("Андрей", "Васильев", "Компания 1");
        Mechanic mechanic5 = new Mechanic<Trucks>("Сергей", "Васильев", "Компания 3");
        Mechanic mechanic6 = new Mechanic<TheBuses>("Виктор", "Васильев", "Компания 3");



        PassengerCars kamaz = new PassengerCars("Камаз", "65117", 11.8, BodyType.SEDAN);
        kamaz.addDriver(new Driver_B<>("Иванов Иван Иванович", "Б", 8));
        kamaz.addSponsor(sponsor1, sponsor2);
        kamaz.addMechanic(mechanic1, mechanic2, mechanic3);

        PassengerCars mercedes = new PassengerCars("Мерседес", "actros l", 15.6, BodyType.HATCHBACK);
        mercedes.addDriver(new Driver_B<>("Максимова Светлана Игоревна", "Б", 13));
        mercedes.addSponsor(sponsor3);
        mercedes.addMechanic(mechanic2);

        PassengerCars freightliner = new PassengerCars("Freightliner ", "Coronado", 14.0, BodyType.SUV);
        freightliner.addDriver(new Driver_B<>("Хейфец Виктор Лазаревич", "Б", 1));
        freightliner.addSponsor(sponsor1);
        freightliner.addMechanic(mechanic1);

        System.out.println("=======================================================");

        Trucks tesla = new Trucks("Tesla", "Truck", 0, LoadCapacity.N1);
        tesla.addDriver(new Driver_C<>("Петров Петр Петрович", "С", 7));
        tesla.addMechanic(mechanic4);
        tesla.addSponsor(sponsor2,sponsor3);

        System.out.println("=======================================================");

        TheBuses yutong = new TheBuses("Yutong", "U12", 0, CapacityType.EXTRA_LARGE);
        yutong.addDriver(new Driver_D<>("Федеров Федор Федорович", "Д",10));
        yutong.addMechanic(mechanic5,mechanic6);
        yutong.addSponsor(sponsor1,sponsor2,sponsor3);

        System.out.println("////////////////////////////////////////////////////");

        List<Car> cars = List.of(
                kamaz, mercedes, freightliner,
                tesla,
                yutong
        );
        for (Car car : cars) {
            carInfo(car);
        }

        System.out.println("=====================================");

        ServiceStation serviceStation = new ServiceStation();
        serviceStation.addPassenger(kamaz);
        serviceStation.addTruck(tesla);
        serviceStation.service();
        serviceStation.service();

        System.out.println("=====================================");

        Set<Example> examples = new HashSet<>();

        Random random1 = new Random();

        while (examples.size() < 15) {
            Example example = new Example(random1.nextInt(10), (random1.nextInt(10)));
            examples.add(example);
            System.out.println(example);
        }

        System.out.println("=====================================");

        Set<Passport> passports = new HashSet<>();

        passports.add(new Passport("1231", "Иван", "Иванов", "Иванович", LocalDate.now().minusYears(25)));
        passports.add(new Passport("1234", "Иван", "Иванов", "Иванович", LocalDate.now().minusYears(24)));

        PassportList passportList = new PassportList(passports);

        System.out.println(passportList);
    }

    private static void carInfo(Car car) {
        System.out.println("Автомобиль: " + car.getBrand() + " "  + car.getModel());
        System.out.println("Водитель: " + car.getDrivers());
        System.out.println("Cпонсоры: " + car.getSponsors());
        System.out.println("Механики: " + car.getMechanics());
    }
}
