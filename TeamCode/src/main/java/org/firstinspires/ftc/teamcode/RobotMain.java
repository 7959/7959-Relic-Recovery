package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;



/**
 * Created by Robi on 10/20/2017.
 */

public class RobotMain {
    public final static DistanceUnit distanceUnit = DistanceUnit.METER;
    public final static BNO055IMU.AccelUnit accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
    HardwareMap hwMap;


    public RobotMain(HardwareMap hwMap){
        this.hwMap = hwMap;
    }


}
