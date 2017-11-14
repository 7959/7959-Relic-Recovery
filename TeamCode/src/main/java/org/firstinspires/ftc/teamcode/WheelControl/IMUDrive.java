package org.firstinspires.ftc.teamcode.WheelControl;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;

/**
 * Created by Robi on 11/12/2017.
 */

public class IMUDrive extends WheelControl{
    InertiaMeasurementUnit imu;
    public IMUDrive(InertiaMeasurementUnit imu, HardwareMap hardwareMap){
        super(hardwareMap);
        this.imu = imu;
    }

    //This variable multiplies with the power adjustment to make motors run at full power
    //in the corresponding direction if the angle is 2PI/2 off scaling accordingly to smaller angles.
    private final double anglePowerRatio = 3/(2 * Math.PI);


    //This variation of movebyCart is similar to the one in BasicDrive
    //But instead of a turn magnitude input, it is a direct angle input
    //Run within a loop to hold a angle
    @Override
    public void movebyCart(double x, double y, double angle) {

        double reAdjustPower = (angle - imu.getHeading());

        MotorWheels[0][0].setPower(y + x + reAdjustPower * anglePowerRatio);
        MotorWheels[1][0].setPower(y -x - reAdjustPower * anglePowerRatio);
        MotorWheels[0][1].setPower(y - x + reAdjustPower *anglePowerRatio);
        MotorWheels[1][1].setPower(y + x - reAdjustPower * anglePowerRatio);
    }

    public void basicMove(double x, double y, double turnMag){
        MotorWheels[0][0].setPower(y + x + turnMag);
        MotorWheels[1][0].setPower(y -x - turnMag);
        MotorWheels[0][1].setPower(y - x + turnMag);
        MotorWheels[1][1].setPower(y + x - turnMag);
    }
    public void basicMove(double[] input, double turnMag){
        MotorWheels[0][0].setPower(input[1] + input[0] + turnMag);
        MotorWheels[1][0].setPower(input[1] - input[0] - turnMag);
        MotorWheels[0][1].setPower(input[1] - input[0] + turnMag);
        MotorWheels[1][1].setPower(input[1] + input[0] - turnMag);
    }



}
