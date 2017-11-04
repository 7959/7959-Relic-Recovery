package org.firstinspires.ftc.teamcode.Mechanisms.ServoControlAlgorithms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.TeleOpAlgorithms.BasicTeleOpSingleGamePad;

/**
 * Created by Robi on 11/2/2017.
 */

public class BasicClaw {
    public Servo servo1;
    public Servo servo2;
    private double closePos1;
    private double closePos2;
    private double openPos1;
    private double openPos2;

    public BasicClaw(HardwareMap hwMap, String name1, String name2){
        servo1 = hwMap.servo.get(name1);
        servo2 = hwMap.servo.get(name2);
    }

    public void setClosePos(double serv1, double serv2){
        closePos1 = serv1;
        closePos2 = serv2;
    }
    public void setOpenPos(double serv1, double serv2){
        openPos1 = serv1;
        openPos2 = serv2;
    }
    public void close(){
        servo1.setPosition(closePos1);
        servo2.setPosition(closePos2);
    }
    public void open(){
        servo1.setPosition(openPos1);
        servo2.setPosition(openPos2);
    }

}
