package org.firstinspires.ftc.teamcode.OldCode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 10/14/2017.
 */
@Deprecated
public class DoubServ implements ClawInterface {
    public Servo leftS;
    public Servo rightS;
    double rightstart;
    double leftstart;
    double rightstop;
    double leftstop;
    final double pinionGearRad = 10.4;
    final double minDistance = 91;
    public DoubServ(HardwareMap hw, String name, String name2, double startR, double startL, double stopR, double stopL){
        rightstart = startR;
        leftstart = startL;
        rightstop = stopR;
        leftstop = stopL;


        leftS = hw.servo.get(name);
        rightS = hw.servo.get(name2);
        final boolean isOne = false;
    }
    public void close(){
        leftS.setPosition(leftstop);
        rightS.setPosition(rightstop);
    }
    public void open(){
        leftS.setPosition(leftstart);
        rightS.setPosition(rightstart);
    }
    public double getPos(){
        return leftS.getPosition()* pinionGearRad + rightS.getPosition()* pinionGearRad + minDistance;
    }
}
