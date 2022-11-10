import static java.lang.Math.sin;
import static java.lang.Math.cos;

public class Vec2{
    double x, y; 

    public Vec2(double xIn, double yIn)
    {
        x = xIn;
        y = yIn;
    }

    public MoveAngle(double _spd, double _angle)
    {
        x += (_spd * Math.cos(_angle));
        y += (_spd * Math.sin(_angle));
    }

}