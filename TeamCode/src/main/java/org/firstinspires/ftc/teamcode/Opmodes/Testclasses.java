package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.WheelControl.BasicWheels;
import org.firstinspires.ftc.teamcode.WheelControl.Wheels;
import org.firstinspires.ftc.teamcode.WheelControl.WheelsImu;

/**
 * Created by Robi on 10/9/2017.
 */

public class Testclasses extends LinearOpMode {
    DcMotor drive[][] = new DcMotor[2][2];
    InertiaMeasurementUnit imu = new InertiaMeasurementUnit(hardwareMap);


    @Override
    public void runOpMode() throws InterruptedException {

        Wheels test = new WheelsImu(imu, hardwareMap);

        waitForStart();
        double input[] = {0, 0};
    }
}
