package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.WheelControl.IMUDrive;
import org.firstinspires.ftc.teamcode.WheelControl.WheelControl;

/**
 * Created by Robi on 11/13/2017.
 */

public class RobotControl {
    public static AngleUnit angleUnit = AngleUnit.RADIANS;
    public static DistanceUnit distanceUnit = DistanceUnit.CM;



    public InertiaMeasurementUnit imu;
    public LinearOpMode opMode;
    public IMUDrive drive;

    public RobotControl(LinearOpMode opMode){
        this.opMode = opMode;

        imu = new InertiaMeasurementUnit(opMode.hardwareMap);

        drive = new IMUDrive(imu, opMode.hardwareMap);
    }





}
