package service;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class WinnerCarsSelector {

    private int maxDistance = 0;
    private List<String> winnerCars = new ArrayList<String>();

    public List<String> selectWinnerCars(List<Car> cars) {
        for (Car currentCar : cars) {
            judgeWinnerCar(currentCar);
        }
        return winnerCars;
    }

    private void judgeWinnerCar(Car currentCar) {
        if (isEqualToMaxDistance(currentCar)) {
            winnerCars.add(currentCar.getCarName());
        }
        if (isBiggerThanMaxDistance(currentCar)) {
            updateWinnerStatus(currentCar);
        }
    }

    private boolean isEqualToMaxDistance(Car currentCar) {
        return maxDistance == currentCar.getCurrentDistance();
    }

    private boolean isBiggerThanMaxDistance(Car currentCar) {
        return maxDistance < currentCar.getCurrentDistance();
    }

    private void updateWinnerStatus(Car currentCar) {
        maxDistance = currentCar.getCurrentDistance();
        winnerCars = new ArrayList<String>(List.of(currentCar.getCarName()));
    }

}
