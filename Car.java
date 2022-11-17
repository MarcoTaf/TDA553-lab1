import java.awt.*;
import java.lang.Math;


public abstract class Car implements Movable{
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Vec2 location;
    private double rotation;
    

    public Car(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.location = new Vec2(100, 100);
        this.rotation = 0;
    }

    public void Move(){
       location.MoveAngle(getCurrentSpeed(), rotation);
    }

    public void TurnRight()
    {
        rotation = CarMath.betterMod(rotation - 1, 360);
    }

    public void TurnLeft()
    {
        rotation = CarMath.betterMod(rotation + 1, 360);
    }

    public void printloc()
    {
        location.printloc(modelName, rotation);
    }

    public double getRotation()
    {
        return rotation;
    }

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    setCurrentSpeed(0.1);
    }

    public void stopEngine(){
	    setCurrentSpeed(0);
    }
    
    public double speedFactor(){
        return enginePower * 0.01;
    }

    public void setCurrentSpeed(double speed){
        currentSpeed = CarMath.clamp(speed, 0, getEnginePower());
    }

    public void incrementSpeed(double amount){
	    setCurrentSpeed(Math.max(Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower),
                                getCurrentSpeed()));
    }
    
    public void decrementSpeed(double amount){
        setCurrentSpeed(Math.min(Math.max(getCurrentSpeed() - speedFactor() * amount,0),
                                getCurrentSpeed()));
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        incrementSpeed(CarMath.clamp(amount));
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(CarMath.clamp(amount));
    }

    public static class CarMath{ 
        public static double clamp(double _val, double _min, double _max){
            return Math.max(Math.min(_val, _max), _min);
        }

        public static double clamp(double _val){
            double _min = 0;
            double _max = 1;
            return Math.max(Math.min(_val, _max), _min);
        }
    
        public static double betterMod(double val, double mod)//Why can mod do negative numbers???
        {
            if (mod < 0)
            {
                throw new IllegalArgumentException("You cannot have a negative mod m80", null);
            }
    
            val = val % mod;
            while (val < 0)
            {
                val += mod;
            }
    
            return val;
        }

    }
}