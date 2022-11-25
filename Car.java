import java.awt.*;

public abstract class Car extends Vehicle{
    private int nrDoors;

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        super(color, enginePower, modelName);
        this.nrDoors = nrDoors;
    }
    public int getNrDoors(){
        return nrDoors;
    }
}
