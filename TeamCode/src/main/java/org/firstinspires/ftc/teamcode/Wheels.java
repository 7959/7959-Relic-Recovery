package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

/**
 * Created by Robi on 10/9/2017.
 */

public class Wheels {
    /**
     * This class is the most basic function of drive.
     * Setting power here is not based off of anything.
     * This class will most likely be overwritten in a subclass
     * but can also be used as a last resort.
     */


    //Set the directions in this class. Will pass on to subclasses
    public final DcMotor.Direction frontLeftDir = DcMotorSimple.Direction.FORWARD;
    public final DcMotor.Direction frontRightDir = DcMotorSimple.Direction.FORWARD;
    public final DcMotor.Direction backLeftDir = DcMotorSimple.Direction.FORWARD;
    public final DcMotor.Direction backRightDir = DcMotorSimple.Direction.FORWARD;


    public DcMotor[][] MotorWheels;


    /**
     * Default Constructor, won't see much use.
     */
    public Wheels(){

    }

    /**Constructor sets up the direction, and use without encoders,
    // Subclasses will have more complex programs involving IMUs, encoders or both
    */
    public Wheels(DcMotor[][] motors){
        MotorWheels = motors;
        setEncoders(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        setDirection();
    }


    /**
     * Sets up encoders
     * Will be not be overwritten in subclasses
     */
    public void setEncoders(DcMotor.RunMode mode){


        /**
         * If the encoders are in use, this will reset the encoders prior to encoder usage
         */
        if(mode == DcMotor.RunMode.RUN_USING_ENCODER){
            for(int i = 0;i < 2;i++){
                for(int j = 0; j < 2 ;j++){
                    MotorWheels[i][j].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    MotorWheels[i][j].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                }
            }
        }


        /**
         * Sets the motor encoders behavior
         */
        for(int i = 0;i < 2;i++){
            for(int j = 0; j < 2 ;j++){
                MotorWheels[i][j].setMode(mode);
                MotorWheels[i][j].setMode(mode);
            }
        }

    }

    /**
     * sets direction based off of the previously defined directions
     * Will not be overwritten in subclasses
     */
    public void setDirection(){
        MotorWheels[0][0].setDirection(backLeftDir);
        MotorWheels[0][1].setDirection(backRightDir);
        MotorWheels[1][0].setDirection(frontLeftDir);
        MotorWheels[1][1].setDirection(frontRightDir);
    }

    public void movebyPolar(double xVel){

    }

    /**
     * Directly puts power into motor, testing use only
     */
    private void directPower(int x, int y, double power){
        if((x == 0 || x == 1) && (y == 0 || y == 1)){
            MotorWheels[x][y].setPower(power);
        }
    }

    /**
     * if this ever needs to be addressed as a string, this method will be there for it.
     //May be used to added drive type to telemetry, and will be overwritten in subclasses
     */
    public String toString() {
        return "Basic drive";
    }
}
