package org.firstinspires.ftc.teamcode.Mechanisms.VerticalMovement;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 10/14/2017.
 */

public class LinearLift implements PulleyInterface {
    DcMotor motor;
    public LinearLift(HardwareMap hw, String Motorname, DcMotor.Direction dir){
        motor = hw.dcMotor.get(Motorname);
        init(dir);
    }
    private void init(DcMotor.Direction dir){
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor.setDirection(dir);
        motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void setPos(int pos){
        if(maxPos >= pos) motor.setTargetPosition(pos);
        else if(maxPos < pos) motor.setTargetPosition(maxPos);
    }
    public double getPos(){
        return motor.getCurrentPosition() * encoderradiansratio * PulleyRadius;
    }
}
