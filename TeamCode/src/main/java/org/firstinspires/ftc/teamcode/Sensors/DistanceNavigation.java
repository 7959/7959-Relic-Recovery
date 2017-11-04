package org.firstinspires.ftc.teamcode.Sensors;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.RobotMain;

/**
 * Created by Robi on 11/1/2017.
 */

public class DistanceNavigation {
    public ColorDistanceSensor floorSensor;
    public ModernRoboticsI2cRangeSensor wallSensor;


    //Measure and replace later
    final double rangeSensorDistanceFromEdge = RobotMain.distanceUnit.toCm(5);
    final double threshold = 20;

    public DistanceNavigation(HardwareMap hwMap, String floorSensorName, String wallSensorName) {
        floorSensor = new ColorDistanceSensor(hwMap, floorSensorName);
        wallSensor = hwMap.get(ModernRoboticsI2cRangeSensor.class, wallSensorName);

    }

    //Gets distance in the standard unit of use in RobotMain
    public double getWallDistance(){
        return wallSensor.getDistance(RobotMain.distanceUnit) - RobotMain.distanceUnit.fromCm(rangeSensorDistanceFromEdge);
    }

    public boolean isLineFound(){
        if(floorSensor.colorSensor.alpha() >= threshold){
            return true;
        } else return false;
    }
}
