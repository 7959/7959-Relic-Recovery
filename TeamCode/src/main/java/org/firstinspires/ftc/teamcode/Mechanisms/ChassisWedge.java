package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Opmodes.OpMode7959;

/**
 * Created by Robi on 12/14/2017.
 */

public class ChassisWedge {
    private Servo wedgeServo;
    private ColorSensor colorSensor;
    private DistanceSensor distanceSensor;

    public ChassisWedge(Servo wedgeServo, ColorSensor colorSensor, DistanceSensor distanceSensor){
        this.wedgeServo = wedgeServo;
        this.colorSensor = colorSensor;
        this.distanceSensor = distanceSensor;
    }
    public void up(){
        wedgeServo.setPosition(0);
    }
    //TODO Test servo Posiions
    public void down(){
        wedgeServo.setPosition(.5);
    }

    public void wedgeServoPos(double pos){
        wedgeServo.setPosition(pos);
    }
    public int getRed(){
        return colorSensor.red();
    }
    public int getBlue(){
        return colorSensor.blue();
    }

    public double getDistance(){
        return distanceSensor.getDistance(OpMode7959.distanceUnit);
    }

    public boolean sideinFront(){//TODO find sensor distance needed
        return getDistance() > 2 ? true : false;
    }
}
