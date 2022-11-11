import java.awt.*;
import java.lang.Math;


public abstract class Car implements Movable{
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected Vec2 location;
    protected double rotation;
    

    public Car(int doorNumber, Color col, double engineSTR, String name){
        nrDoors = doorNumber;
        color = col;
        enginePower = engineSTR;
        modelName = name;
        location = new Vec2(100, 100);
        rotation = 0;
    }

    public void Move(){
       location.MoveAngle(getCurrentSpeed(), rotation);
    }

    public void TurnRight()
    {
        rotation --;
        rotation = rotation % 360;
    }

    public void TurnLeft()
    {
        rotation ++;
        rotation = rotation % 360;
    }

    public void printloc()
    {
        location.printloc(modelName, rotation);
    }
    public double clamp(double _val){
        double _min = 0;
        double _max = 1;

        return Math.max(Math.min(_val, _max), _min);
    }

    public double clamp(double _val, double _min, double _max){
        return Math.max(Math.min(_val, _max), _min);
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
	    currentSpeed = 0.0;
    }

    public void stopEngine(){
	    currentSpeed = 0;
    }
    
    public double speedFactor(){
        return enginePower * 0.01;
    }

    public void incrementSpeed(double amount){
	    currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }

    public void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }


    public void gas(double amount){
        incrementSpeed(clamp(amount));
    }


    public void brake(double amount){
        decrementSpeed(clamp(amount));
    }
}