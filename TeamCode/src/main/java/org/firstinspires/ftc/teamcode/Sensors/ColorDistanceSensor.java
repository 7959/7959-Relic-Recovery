package org.firstinspires.ftc.teamcode.Sensors;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.RobotMain;

/**
 * Created by Robi on 10/12/2017.
 */

public class ColorDistanceSensor {
    final int Threshold = 3;// Test and change later
    public ColorSensor sensor;
    public DistanceSensor OptDistance;
    HardwareMap hmap;



    /**
     * REMINDER:
     * Name must match optical distance sensor.
     *
     */
    public ColorDistanceSensor(HardwareMap hwmap, String name){
        sensor = hwmap.colorSensor.get(name);
        OptDistance = hwmap.get(DistanceSensor.class, name);
    }


    public boolean isRed(){
        if(sensor.red() >= Threshold)
            return true;
        else return false;
    }
    public boolean isBlue(){
        if(sensor.blue() >= Threshold)
            return true;
        else return false;
    }

    public double getDistance(){
        return OptDistance.getDistance(RobotMain.distanceUnit);
    }

}
