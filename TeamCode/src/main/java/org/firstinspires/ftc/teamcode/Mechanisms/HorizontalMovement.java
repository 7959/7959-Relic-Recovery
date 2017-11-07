package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 10/14/2017.
 *
 * Basic Program to control the rack and pinions on the chassis
 */

public class HorizontalMovement {
    CRServo servo1;
    CRServo servo2;

    //Constructor intialized servos with the hardwaremap and names
    public HorizontalMovement(HardwareMap hw, String name1, String name2, DcMotor.Direction dir1, DcMotor.Direction dir2){
        servo1 = hw.crservo.get(name1);
        servo2 = hw.crservo.get(name2);
        servo1.setDirection(dir1);
        servo2.setDirection(dir2);
        servo2.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    //sets powers
    public void setPower(double power){

        //** 1 may be negative
        servo1.setPower(power);
        servo2.setPower(power);
    }
}
