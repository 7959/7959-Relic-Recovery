package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Robi on 12/31/2017.
 */

public class Outtake {
    private final DcMotor linearMotor;
    private final DcMotor rotateMotor;

    //1440

    public Outtake(DcMotor linearMotor, DcMotor rotateMotor){

        this.linearMotor = linearMotor;
        this.rotateMotor = rotateMotor;
        linearMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        linearMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        linearMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public void setLinearMotorPower(double power){
        linearMotor.setPower(power);
    }
    public void goToPosition(int position){
        linearMotor.setTargetPosition(position);
    }

}
