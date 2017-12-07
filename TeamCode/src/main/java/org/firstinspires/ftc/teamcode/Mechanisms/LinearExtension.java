package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 11/20/2017.
 */

public class LinearExtension {

    public DcMotor pulleyMotor;
    public DcMotor retractMotor;
    public LinearExtension(HardwareMap hwMap){
        pulleyMotor = hwMap.dcMotor.get("Pulley Motor");
        retractMotor = hwMap.dcMotor.get("Retract Motor");
    }
    public void setPulleyMotorPower(double power){
        pulleyMotor.setPower(power);
    }
    public void extend(double power){
        retractMotor.setPower(-(power * 1.1));
        pulleyMotor.setPower(power);
    }
    public void retract(double power) {
        pulleyMotor.setPower(-(power * 1.1));
        retractMotor.setPower(power);
    }
}
