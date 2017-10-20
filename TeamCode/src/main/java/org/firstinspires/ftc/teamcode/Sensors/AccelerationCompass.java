package org.firstinspires.ftc.teamcode.Sensors;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cCompassSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;

/**
 * Created by Robi on 10/16/2017.
 */

public class AccelerationCompass {
    public ModernRoboticsI2cCompassSensor acelSensor;
    public Acceleration acel;
    public AccelerationCompass(HardwareMap hw){
        acelSensor = hw.get(ModernRoboticsI2cCompassSensor.class, "compass");
    }
    public boolean isCal(){
        return acelSensor.isCalibrating();
    }
    public void retreivedata(){
        acel = acelSensor.getAcceleration();
    }
    public double getxAcel(){
        retreivedata();
        return acel.xAccel;
    }
    public double getyAcel(){
        retreivedata();
        return acel.yAccel;
    }
    public double getzAcel(){
        retreivedata();
        return acel.zAccel;
    }

}
