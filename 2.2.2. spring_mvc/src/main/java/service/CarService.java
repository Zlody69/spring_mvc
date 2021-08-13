package service;

import model.Car;

import java.util.List;

public class CarService {

    private List<Car> carList;

    public CarService(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getNumbCarList(int number){
        if(number >= carList.size()){
            return carList;
        }
        return carList.subList(0, number);
    }

    public List<Car> getCarList() {
        return carList;
    }
}
