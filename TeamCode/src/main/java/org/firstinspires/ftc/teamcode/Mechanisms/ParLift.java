package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 11/18/2017.
 */
@Deprecated
public class ParLift {
    private DcMotor leftMotor;
    private DcMotor rightMotor;
    private double targetPos = 0;
    public ParLift(HardwareMap map){
        leftMotor = map.dcMotor.get("ParLeft");
        rightMotor = map.dcMotor.get("ParRight");
        leftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        rightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void setPower(double power){
        leftMotor.setPower(power);
        rightMotor.setPower(power);
    }
    public void setPos(int pos){
        leftMotor.setTargetPosition(pos);
        rightMotor.setTargetPosition(pos);
    }
    private class angleHolder extends Thread{
        public double motorPower = 0;
        public double angleRatio = .01;
        @Override
        public void run() {
        }
    }
}
