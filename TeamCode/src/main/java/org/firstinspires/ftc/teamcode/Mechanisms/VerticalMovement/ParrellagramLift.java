package org.firstinspires.ftc.teamcode.Mechanisms.VerticalMovement;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Mechanisms.ServoControlAlgorithms.BasicClaw;
import org.firstinspires.ftc.teamcode.Mechanisms.ServoControlAlgorithms.SoftwareServoController;

import static org.firstinspires.ftc.teamcode.RobotMain.hwMap;

/**
 * Created by Robi on 10/15/2017.
 */

public class ParrellagramLift {
    DcMotor lift;
    public BasicClaw Glyphclaw;
    private final double holdPower = .3;
    public ParrellagramLift(HardwareMap hwmap){
        lift = hwmap.dcMotor.get("Arm");
        Glyphclaw = new BasicClaw(hwMap, "Claw Left", "Claw Right");
        Glyphclaw.setOpenPos(0,0);
        Glyphclaw.setClosePos(1,1);
        lift.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void holdPos(){
        lift.setPower(holdPower);
    }
    public void lift(double power){
        lift.setPower(holdPower + (power * .7));
    }
    public void overridePower(double power){
        lift.setPower(power);
    }
    public void closeClaw(){
        Glyphclaw.close();
    }
    public void openClaw(){
        Glyphclaw.open();
    }

}
