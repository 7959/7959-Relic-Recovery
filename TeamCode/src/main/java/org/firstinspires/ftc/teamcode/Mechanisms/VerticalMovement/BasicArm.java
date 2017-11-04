package org.firstinspires.ftc.teamcode.Mechanisms.VerticalMovement;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 11/2/2017.
 */

public class BasicArm {
    DcMotor arm;
    private final double holdPower = -.3;
    public BasicArm(HardwareMap hwmap, String name){
        arm = hwmap.dcMotor.get(name);
    }
    public void holdPos(){
        arm.setPower(holdPower);
    }
    public void lift(double power){
        arm.setPower(power);
    }
}
