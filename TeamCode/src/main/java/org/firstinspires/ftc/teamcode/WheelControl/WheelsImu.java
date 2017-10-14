package org.firstinspires.ftc.teamcode.WheelControl;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;

/**
 * Created by Robi on 10/12/2017.
 */

public class WheelsImu extends BasicWheels {

    InertiaMeasurementUnit imu;
    public WheelsImu(InertiaMeasurementUnit Imu,HardwareMap HwMap){
        super(HwMap);
        imu = Imu;
    }

    @Override
    public void movebyCart(double[] Velvector, double desiredAngle) {
        double anglularVelocity;
        anglularVelocity = (Math.toDegrees(imu.getHeading() - desiredAngle)) / 100;

        super.movebyCart(Velvector, anglularVelocity);
    }

    @Override
    public void movebyPolar(double[] Velvector, double desiredAngle) {
        double AngularVelocity;
        AngularVelocity = (Math.toDegrees(imu.getHeading()) - desiredAngle) / 100;
        super.movebyPolar(Velvector, AngularVelocity);
    }
}
