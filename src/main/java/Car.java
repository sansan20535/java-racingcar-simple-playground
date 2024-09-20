public class Car {

    private String carName;
    private int currentDistance;

    public Car(String carName) {
        this.carName = carName;
        this.currentDistance = 0;
    }

    public void ride() {
        if (isGoOrStop(createRandomValue())) {
            this.currentDistance += 1;
        }
    }

    // Q : 아래 두 함수도 따로 클래스를 분리하는 것이 좋은 것인지...?
    private int createRandomValue() {
        return RandomValueCreator.createRandomValue();
    }

    private boolean isGoOrStop(final int randomValue) {
        return GoOrStopValidator.validateGoOrStop(randomValue);
    }
}
