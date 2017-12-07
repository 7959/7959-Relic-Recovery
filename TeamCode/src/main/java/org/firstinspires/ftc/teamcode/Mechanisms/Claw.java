package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 12/5/2017.
 */

public class Claw {
    private Servo servo1;
    private Servo servo2;

    public Claw(Servo servo1, Servo servo2){
        this.servo1 = servo1;
        this.servo2 = servo2;
        servo1.scaleRange(0,180);
        servo2.scaleRange(0,180);
    }
    public void setPos(double pos1, double pos2){
        servo1.setPosition(pos1);
        servo2.setPosition(pos2);
    }

}
