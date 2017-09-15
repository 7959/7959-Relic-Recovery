package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;

import java.util.Map;

/**
 * Created by Robi on 9/15/2017.
 */

public abstract class RobotControl extends LinearOpMode {
    public class Wheels{
        DcMotor[][] bottomMotors;
        //We are creating an array for our motors, it will allow use to for statements easily to control the motors;
        //[0][0] is the back left motor and we will treat the rest as if the array values were Xs and Ys Ex. bottomMotor[1][0] is top


        Wheels(){
            bottomMotors = new DcMotor[1][1];
            //Set direction of your motors x and y cordinates in the second part of function
            //Change 'F' to 'R' to reverse
            setDirection('F', 0, 0);
            setDirection('F', 0, 1);
            setDirection('F', 1, 0);
            setDirection('F', 1, 1);



            map();
        }
        private void map(){
            mapMotor(bottomMotors[0][0], "Back Left");
            mapMotor(bottomMotors[0][1], "Front Left");
            mapMotor(bottomMotors[1][0], "Back Right");
            mapMotor(bottomMotors[1][1], "Front Right");
        }

        //Avoid using this function
        public void directPower(int x, int y, double power){
            if((x == 0 || x == 1) && (y == 0 || y == 1)){
                bottomMotors[x][y].setPower(power);
            }
        }

        public void mapMotor(DcMotor motor, String name){
            motor = hardwareMap.dcMotor.get(name);
        }

        private void setDirection(Character direct, int x , int y){
            DcMotorSimple.Direction d;
            if(direct == 'F'){
                d = DcMotorSimple.Direction.FORWARD;
            } else if(direct == 'R'){
                d = DcMotorSimple.Direction.REVERSE;
            } else {
                d = null;
            }
            if((x == 1 || x == 0) && (x == 0 || x == 1) && (d != null))
            bottomMotors[x][y].setDirection(d);
        }
    }
    public class CameraControl{

    }

}
