package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.RobotControl;

/**
 * Created by Robi on 11/23/2017.
 */

public class Lift {
    private DcMotor motorR;
    private DcMotor motorL;//1440 encoder counts per rotation

    private RobotControl bot;

    private double counterTorque = 0;

    private double desiredAngle = 0;//Angle Relative to start

    public Lift(RobotControl bot){
        this.bot = bot;

        motorR = RobotControl.opMode.hardwareMap.dcMotor.get("Right Lift");
        motorL = RobotControl.opMode.hardwareMap.dcMotor.get("Left Lift");

        motorR.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorL.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        motorR.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motorL.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }



    public void holdPos(){
        motorR.setPower(.2);//Base off encoder counts later
        motorL.setPower(.2);//test and change later
    }

}
