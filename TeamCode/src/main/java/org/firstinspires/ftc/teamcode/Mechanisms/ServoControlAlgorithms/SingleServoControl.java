package org.firstinspires.ftc.teamcode.Mechanisms.ServoControlAlgorithms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 11/2/2017.
 */

public class SingleServoControl {
    Servo servo;
    private double closePos;
    private double openPos;


    public SingleServoControl(HardwareMap hwMap, String name){
        servo = hwMap.servo.get(name);
    }

    public void setClosePos(double closePos) {
        this.closePos = closePos;
    }

    public void setOpenPos(double openPos) {
        this.openPos = openPos;
    }
    public void close(){
        servo.setPosition(closePos);
    }
    public void open(){
        servo.setPosition(openPos);
    }
    public void setServo(double pos){
        servo.setPosition(pos);
    }
}
