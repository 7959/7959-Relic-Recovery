package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 12/12/2017.
 */

public class JewelArm {
    Servo sweepServo;
    Servo downServo;
    ColorSensor sensor;
    
    public JewelArm(Servo sweepServo, Servo downServo, ColorSensor sensor){
        this.sweepServo = sweepServo;
        this.downServo = downServo;
        this.sensor = sensor;
    }

    
    public void setPos(double... input) {
        sweepServo.setPosition(input[0]);
        downServo.setPosition(input[1]);
    }

    public void sweep(boolean isRight){
        if(isRight){
            sweepServo.setPosition(1);
        } else  sweepServo.setPosition(0);
    }

    
    public boolean jewelisRed(){
        if(sensor.red() > sensor.blue()) return true;
        else return false;
    }

    
    private final double initPos = 0;//TODO find init positions
    private final double initPosSweep = .5;
    
    public void init() {
        downServo.setPosition(initPos);
        downServo.setPosition(initPosSweep);
    }
}
