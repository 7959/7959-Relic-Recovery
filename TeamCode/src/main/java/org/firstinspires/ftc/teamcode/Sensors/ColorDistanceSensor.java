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
    public ColorSensor colorSensor;
    public DistanceSensor OptDistance;



    public ColorDistanceSensor(HardwareMap hwmap, String name){
        colorSensor = hwmap.colorSensor.get(name);
        OptDistance = hwmap.get(DistanceSensor.class, name);
    }


    public boolean isRed(){
        if(colorSensor.red() > colorSensor.blue())
            return true;
        else return false;
    }
    public boolean isBlue(){
        return !isRed();
    }

    public double getDistance(){
        return OptDistance.getDistance(RobotControl.distanceUnit);
    }

}
