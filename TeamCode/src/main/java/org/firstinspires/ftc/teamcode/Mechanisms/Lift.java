package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.RobotControl;

/**
 * Created by Robi on 11/23/2017.
 */

public class Lift {
    private DcMotor motorR;
    private DcMotor motorL;//1440 encoder counts per rotation


    private double counterTorque = 0;
    private double powerPerCount = 720 * .001;//power multiply by the difference of encoder count and


    private final double holdPower = .2;

    private double desiredAngle = 0;//Angle Relative to start
    private final int maxEncoderPower = 300;//360 counts at 90 degrees relative to straight down to zero. it is just a guess today.

    public Lift(RobotControl bot){
        motorR = RobotControl.opMode.hardwareMap.dcMotor.get("Right Lift");
        motorL = RobotControl.opMode.hardwareMap.dcMotor.get("Left Lift");

        motorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

    }

    public void holdPos(){
        setPower(holdPower);//Base off encoder counts later test and change later
    }
    public void setPower(double power){
        motorL.setPower(power);
        motorR.setPower(power);
    }

    public void holdPosbyPos(){
        double power;

        power = Math.abs(maxEncoderPower - motorR.getCurrentPosition() * powerPerCount);

        setPower(power);
    }


}
