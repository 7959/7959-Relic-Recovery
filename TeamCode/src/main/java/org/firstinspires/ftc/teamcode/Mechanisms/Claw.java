package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 12/5/2017.
 */

public class Claw {
    private Servo servo1;
    private Servo servo2;

    private double closePos[];
    private double openPos[];

    public Claw(Servo servo1, Servo servo2){
        this.servo1 = servo1;
        this.servo2 = servo2;

    }
    public void setPos(double pos1, double pos2){
        servo1.setPosition(pos1);
        servo2.setPosition(pos2);
    }

    public void close(){
        servo1.setPosition(closePos[0]);
        servo2.setPosition(closePos[1]);
    }

    public void open(){
        servo1.setPosition(openPos[0]);
        servo2.setPosition(openPos[1]);
    }
    public double getServo1(){
        return servo1.getPosition();
    }

    public double getServo2(){
        return servo2.getPosition();
    }


    public void setClosePos(double... closePos) {
        this.closePos = closePos;
    }

    public void setOpenPos(double... openPos){
        this.openPos = openPos;
    }
}
