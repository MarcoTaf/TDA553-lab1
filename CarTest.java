import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CarTest{
    public static void main(String[] args) {
        Scania scania = new Scania();
        scania.rasie();
        System.out.println(scania.getAngle());
        scania.lower();
        System.out.println(scania.getAngle());
       
    }



    @Test
    public void stopEngineTest()
    {
        Volvo240 volvo = new Volvo240();
        assertEquals(0, volvo.getCurrentSpeed(), 0);
    }
    @Test
    public void compareCars()
    {
        Volvo240 car1 = new Volvo240();
        Volvo240 car2 = car1;
        assertEquals(car1, car2);
    }

    @Test
    public void counterTurnTest()
    {
        Volvo240 car1 = new Volvo240();
        Volvo240 car2 = new Volvo240();
        car1.TurnLeft();
        car1.TurnRight();
        assertEquals(car1.getRotation(), car2.getRotation(), 0);
    }

    @Test
    public void startEngineTest() {
    Volvo240 testVolvo240 = new Volvo240();
    testVolvo240.startEngine();
    testVolvo240.gas(0.5);
    testVolvo240.stopEngine();
    assertEquals(0, testVolvo240.getCurrentSpeed(), 0);
    }

    @Test
    public void canTheCarTurn() {
    Saab95 testSaab95 = new Saab95();
    testSaab95.TurnLeft();
    assertTrue(testSaab95.getRotation() != 0.0);
    }

    @Test
    public void carBrake() {
    Volvo240 Volvo240 = new Volvo240();
    Volvo240.startEngine();
    Volvo240.gas(0.5);
    Volvo240.brake(0.5);
    assertTrue(Math.floor(Volvo240.getCurrentSpeed()) < 1);
    }
  
    @Test
    public void truckGas() {
        Scania scania = new Scania();
        scania.gas(100);
        scania.getCurrentSpeed();
        assertTrue(scania.getCurrentSpeed() == 0);
    }
    
}