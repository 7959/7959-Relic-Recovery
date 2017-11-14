package org.firstinspires.ftc.teamcode.WheelControl;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;

/**
 * Created by Robi on 11/12/2017.
 */

public abstract class WheelControl {

    DcMotor[][] MotorWheels = new DcMotor[2][2];
    protected final DcMotor.Direction frontLeftDir = DcMotorSimple.Direction.REVERSE;
    protected final DcMotor.Direction frontRightDir = DcMotorSimple.Direction.REVERSE;
    protected final DcMotor.Direction backLeftDir = DcMotorSimple.Direction.REVERSE;
    protected final DcMotor.Direction backRightDir = DcMotorSimple.Direction.REVERSE;
    protected WheelControl(HardwareMap hardwareMap){
        MotorWheels[0][0] = hardwareMap.dcMotor.get("Back Left");
        MotorWheels[1][0] = hardwareMap.dcMotor.get("Back Right");
        MotorWheels[0][1] = hardwareMap.dcMotor.get("Front Left");
        MotorWheels[1][1] = hardwareMap.dcMotor.get("Front Right");
        setDirection();
        setZeroPowerBehavior();
        activateEncoders();
    }


    //Moves the robot through a vector inputted in cartesian points
    public abstract void movebyCart(double x, double y, double turnMag);


    //Allows inputs of arrays
    public void movebyCart(double vector[], double AngularVelocity){
        movebyCart(vector[0], vector[1], AngularVelocity);
    }

    //Sets the ZeroPointBehavior which will always be on brake
    private void setZeroPowerBehavior(){
        for(DcMotor[] motors :MotorWheels){
            for(DcMotor motor: motors){
                motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            }
        }
    }

    //Activates the encoders
    private void activateEncoders(){
        for(DcMotor[] motors: MotorWheels){
            for(DcMotor motor: motors){
                motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            }
        }
    }

    //Resets all encoders
    public void resetEncoders(){
        for(DcMotor[] motors: MotorWheels){
            for(DcMotor motor: motors){
                motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }
        }
        activateEncoders();
    }

    //Sets the directions of the wheels
    private void setDirection(){
        MotorWheels[0][0].setDirection(backLeftDir);
        MotorWheels[1][0].setDirection(backRightDir);
        MotorWheels[0][1].setDirection(frontLeftDir);
        MotorWheels[1][1].setDirection(frontRightDir);
    }
}
