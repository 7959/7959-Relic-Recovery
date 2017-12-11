package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 11/20/2017.
 */

public class LinearExtension {

    public DcMotor pulleyMotor;
    public DcMotor retractMotor;
    public LinearExtension(DcMotor pulleyMotor, DcMotor retractMotor){
        this.pulleyMotor = pulleyMotor;
        this.retractMotor = retractMotor;
        pulleyMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        retractMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    public void setPulleyMotorPower(double power){
        pulleyMotor.setPower(power);
    }
    public void extend(double power){
        retractMotor.setPower(-power * .4);
        pulleyMotor.setPower(power);
    }
    public void powerOff(){
        retractMotor.setPower(0);
        pulleyMotor.setPower(0);
    }
    public void retract(double power) {
        pulleyMotor.setPower(-power* .4);
        retractMotor.setPower(power);
    }
}
