package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 10/22/2017.
 */

public class ParrellagramLift {
    DcMotor arm;

    final double startAngle = 0;//fill in later

    final double angleEncoderRatio = 1;

    public ParrellagramLift(HardwareMap hwMap) {
        arm = hwMap.dcMotor.get("Arm");
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setPos(double angle){
        arm.setTargetPosition((int)(startAngle* angleEncoderRatio* angle));
    }



}
