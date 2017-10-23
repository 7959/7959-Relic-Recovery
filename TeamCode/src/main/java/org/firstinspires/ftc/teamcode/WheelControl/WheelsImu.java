package org.firstinspires.ftc.teamcode.WheelControl;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;

/**
 * Created by Robi on 10/12/2017.
 */


public class WheelsImu extends WheelsEncoded {
    final double powerAngleRatio = Math.PI/100;
    InertiaMeasurementUnit imu;
    public WheelsImu(InertiaMeasurementUnit Imu,HardwareMap HwMap){
        super(HwMap);
        imu = Imu;
    }

    @Override
    public void movebyCart(double[] Velvector, double desiredAngle) {
        double anglularVelocity;
        anglularVelocity = (imu.getHeading() - desiredAngle) * powerAngleRatio;

        super.movebyCart(Velvector, anglularVelocity);
    }

    @Override
    public void movebyPolar(double[] Velvector, double desiredAngle) {
        double AngularVelocity;
        AngularVelocity = (imu.getHeading() - desiredAngle) *powerAngleRatio;
        super.movebyPolar(Velvector, AngularVelocity);
    }
}
