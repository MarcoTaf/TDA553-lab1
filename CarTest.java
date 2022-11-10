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
        }
        }
}