import java.lang.Math;

public class Vec2{
    double x, y; 

    public Vec2(double xIn, double yIn)
    {
        x = xIn;
        y = yIn;
    }

    public void MoveAngle(double _spd, double _angle)
    {
        _angle = Math.toDegrees(_angle);

        x += (_spd * Math.cos(_angle));
        y += (_spd * Math.sin(_angle));
    }

    public void printloc(String name, double rot){
        System.out.printf(name + ": X: %f/Y: %f/ rotation: %f\n", x, y, rot);
    }

}