package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarDaoImpl implements CarDao {

    @Override
    public List<Car> getCars(List<Car> carList, int count) {
        if (count >= 5) {
            return carList;
        }
        return carList.stream().limit(count).collect(Collectors.toList());
    }
}