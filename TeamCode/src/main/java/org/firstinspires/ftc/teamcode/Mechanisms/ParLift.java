package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 11/18/2017.
 */

public class ParLift {
    private DcMotor Motor;

    final double holdPower = .2;
    private double targetPos = 0;
    public ParLift(HardwareMap map, DcMotor.RunMode mode){
        Motor = map.dcMotor.get("Parallelogram Lift");
        Motor.setMode(mode);
        Motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setPower(double power){
        Motor.setPower(power);
    }
    public void setPos(int pos){
        Motor.setTargetPosition(pos);
    }
    public void holdPower(){
        Motor.setPower(holdPower);
    }

    @Deprecated
    private class angleHolder extends Thread{
        public double motorPower = 0;
        public double angleRatio = .01;
        @Override
        public void run() {
        }
    }
}
