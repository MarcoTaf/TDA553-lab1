import java.awt.Color;
import java.util.*;

public class CarTransporter extends Truck implements Flatbed {
    private Boolean raised;
    private int carCapacity;
    private Stack<Car> carLoader = new Stack<Car>();
    

    public CarTransporter() {
        super(2, Color.black, 300, "Saab95");
        this.raised = false;
        this.carCapacity = 6;
    }

    public void rasie() {
        this.raised = true;
    }
    public void lower()  {
        this.raised = false;
    }
    
    public Boolean getFlatbedStatus() {
        return this.raised;
    }
    //TODO
    public void loadCar() {
        if (carLoader.size() < carCapacity) {
        }
    
    }
    //TODO
    public void deloadCar() {

    }

    //TODO
    private void getNearbyCars() {


    }

}
