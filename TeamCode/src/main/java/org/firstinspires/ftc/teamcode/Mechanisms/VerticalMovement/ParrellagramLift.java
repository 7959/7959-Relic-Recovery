package org.firstinspires.ftc.teamcode.Mechanisms.VerticalMovement;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.Mechanisms.ServoControlAlgorithms.BasicClaw;

import static org.firstinspires.ftc.teamcode.RobotMain.hwMap;

/**
 * Created by Robi on 10/15/2017.
 *
 * Program to control the old lift.
 * No longer used post disassembly
 */


@Deprecated
public class ParrellagramLift {
    DcMotor lift;
    public BasicClaw Glyphclaw;

    //Hold power is the power required to have the net torque equal to zero on the lift.
    //This value was found through trial and error when testing the claw
    private final double holdPower = .3;

    //Constructor sets up the hardware map, and open and close positions of the claw
    public ParrellagramLift(HardwareMap hwmap){
        lift = hwmap.dcMotor.get("Arm");
        Glyphclaw = new BasicClaw(hwMap, "Claw Left", "Claw Right");
        Glyphclaw.setOpenPos(0,0);
        Glyphclaw.setClosePos(1,1);
        lift.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    //Inputs the hold power to the lift
    public void holdPos(){
        lift.setPower(holdPower);
    }


    //Adds power to go up or down on the lift. Parameter is multiplied by .7 to scale the values from 0-1
    public void lift(double power){
        lift.setPower(holdPower + (power * .7));
    }

    //Set power directly. Only used for testing purposes.
    public void overridePower(double power){
        lift.setPower(power);
    }

    //Close the claw
    public void closeClaw(){
        Glyphclaw.close();
    }
    //Open the claw
    public void openClaw(){
        Glyphclaw.open();
    }

    //Moves the claw 18 degrees off of the closed position
    public void slightClose(){
        Glyphclaw.servo1.setPosition(.8);
        Glyphclaw.servo2.setPosition(.1);
    }

}
