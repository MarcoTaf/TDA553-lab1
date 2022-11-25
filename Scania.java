import java.awt.*;

public class Scania extends Truck implements Flatbed {
    private int angle;
    private Boolean raised;

    public Scania() {
        super(2, Color.red, 300, "Scania");
        this.angle = 0; 
        this.raised = false;
    }

    public void rasie() {
        while (this.angle < 70) {
            this.angle += 1;
        }
        isRaised();
    }

    public void lower() {
        while (this.angle > 0) {
            this.angle -= 1;
        }
        isLowered();
    }

    public void isLowered() {
        if (this.angle != 0) {
            this.raised = false;
        }
    }

    public void isRaised() {
        if (this.angle == 0) {
            this.raised = true;
        }
    }
    protected int getAngle() {
        return this.angle;
    }

    public Boolean getFlatbedStatus() {
        return this.raised;

    }


}
