package web.service;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {
    private final List<Car> carList;

    {
        carList = new ArrayList<>();

        carList.add(new Car("Mazda", 6, "Red"));
        carList.add(new Car("Lada", 2101, "Yellow"));
        carList.add(new Car("BMW", 535, "Black"));
        carList.add(new Car("Porsche", 911, "White"));
        carList.add(new Car("Audi", 100, "Blue"));
    }

    @Override
    public List<Car> getCars(int count) {
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}
