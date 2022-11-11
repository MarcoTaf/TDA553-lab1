import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CarTest{
    public static void main(String[] args) {
        Saab95 saab = new Saab95();
        Volvo240 volvo = new Volvo240();
        
        volvo.startEngine();

        while (true){
            //saab.printloc();
            volvo.printloc();
            volvo.gas(0.5);
            volvo.TurnRight();
            volvo.Move();
            System.out.println("Km/h: " + volvo.getCurrentSpeed());
        }
        }

        @Test
        public void directionTest(){
            Volvo240 test_Volvo240 = new Volvo240();
            test_Volvo240.startEngine();
            test_Volvo240.gas(0.8);
            test_Volvo240.Move();    
            assertEquals(null, 0, 0, 0);;
        }

}