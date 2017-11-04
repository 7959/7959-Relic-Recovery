package org.firstinspires.ftc.teamcode.WheelControl;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;

/**
 * Created by Robi on 10/12/2017.
 */


public class WheelsImu extends WheelsEncoded {
    //private final double powerAngleRatio = 1/(Math.PI/100);
    InertiaMeasurementUnit imu;
    public WheelsImu(InertiaMeasurementUnit Imu,HardwareMap HwMap){
        super(HwMap);
        imu = Imu;
    }

    @Override
    public void movebyCart(double[] Velvector, double desiredAngle) {
        double anglularVelocity;
        anglularVelocity = (imu.getHeading() - desiredAngle);
        super.movebyCart(Velvector, anglularVelocity);
    }

    @Override
    public void movebyPolar(double[] Velvector, double desiredAngle) {
        double AngularVelocity;
        AngularVelocity = (imu.getHeading() - desiredAngle) /100;
        super.movebyPolar(Velvector, AngularVelocity);
    }

    @Override
    public void overrideDrive(double[] Velvector, double AngularVelocity) {
        super.movebyCart(Velvector, AngularVelocity);
    }
}
