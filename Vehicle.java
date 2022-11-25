import java.awt.*;
import java.lang.Math;


public abstract class Vehicle implements Movable{
    private double enginePower; // Engine power of the Vehicle
    private double currentSpeed; // The current speed of the Vehicle
    private Color color; // Color of the Vehicle
    private String modelName; // The Vehicle model name
    private Vec2 location;
    private double rotation;
    private Boolean engineOn;

    public Vehicle(Color color, double enginePower, String modelName){
        this.color = color;
        this.enginePower = enginePower;
        this.engineOn = false;
        this.modelName = modelName;
        this.location = new Vec2(100, 100);
        this.rotation = 0;
        
    }

    public void Move(){
       location.MoveAngle(getCurrentSpeed(), rotation);
    }

    public void TurnRight()
    {
        rotation = VehicleMath.betterMod(rotation - 1, 360);
    }

    public void TurnLeft()
    {
        rotation = VehicleMath.betterMod(rotation + 1, 360);
    }

    public void printloc()
    {
        location.printloc(modelName, rotation);
    }

    public double getRotation()
    {
        return rotation;
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
        this.engineOn = true;
    }

    public void stopEngine(){
	    setCurrentSpeed(0);
        this.engineOn = false;
    }
    
    public double speedFactor(){
        return enginePower * 0.01;
    }

    private void setCurrentSpeed(double speed){
        currentSpeed = VehicleMath.clamp(speed, 0, getEnginePower());
    }

    private void incrementSpeed(double amount){
	    setCurrentSpeed(Math.max(Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower),
                                getCurrentSpeed()));
    }
    
    private void decrementSpeed(double amount){
        setCurrentSpeed(Math.min(Math.max(getCurrentSpeed() - speedFactor() * amount,0),
                                getCurrentSpeed()));
    }

    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (this.engineOn == true) {
        incrementSpeed(VehicleMath.clamp(amount));
        System.out.println(getCurrentSpeed());
    }
    }

    // TODO fix this method according to lab pm
    public void brake(double amount){
        decrementSpeed(VehicleMath.clamp(amount));
        System.out.println(getCurrentSpeed());
    }

    public static class VehicleMath{ 
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