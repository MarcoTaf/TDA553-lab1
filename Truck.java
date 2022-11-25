import java.awt.*;

public abstract class Truck extends Vehicle{
    private int nrDoors;

    public Truck(int nrDoors, Color color, double enginePower, String modelName){
        super(color, enginePower, modelName);
        this.nrDoors = nrDoors;
    }
    public int getNrDoors(){
        return nrDoors;
    }
    @Override
    public double speedFactor() {
        return (getEnginePower() * 0.007);
    }
}
