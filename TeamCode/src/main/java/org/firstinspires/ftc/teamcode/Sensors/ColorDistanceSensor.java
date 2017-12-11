package org.firstinspires.ftc.teamcode.Sensors;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.RobotMain;

/**
 * Created by Robi on 10/12/2017.
 */

public class ColorDistanceSensor {
    private ColorSensor colorSensor;
    private DistanceSensor OptDistance;



    public ColorDistanceSensor(HardwareMap hwmap, String name){
        colorSensor = hwmap.colorSensor.get(name);
        OptDistance = hwmap.get(DistanceSensor.class, name);
    }

    public int getRed(){
        return colorSensor.red();
    }
    public int getBlue(){
        return colorSensor.blue();
    }


    public boolean isRed(){
        if(colorSensor.red() >= colorSensor.blue())
            return true;
        else return false;
    }
    public boolean isBlue(){
        if(colorSensor.red() < colorSensor.blue())
            return true;
        else return false;
    }

    public double getDistance(){
        return OptDistance.getDistance(RobotControl.distanceUnit);
    }

}
