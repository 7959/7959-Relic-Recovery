package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 11/18/2017.
 */

public class ParLift {
    private DcMotor motor;

    final double holdPower = .1;

    public ParLift(DcMotor motor) {
        this.motor = motor;
        
    }

    public void setPower(double power) {
        motor.setPower(power);
    }


    public void holdPower() {
        motor.setPower(holdPower);
    }

}
