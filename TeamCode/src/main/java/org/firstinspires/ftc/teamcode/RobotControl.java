package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.internal.android.dex.Code;

import java.util.Map;

/**
 * Created by Robi on 9/15/2017.
 */

public abstract class RobotControl extends LinearOpMode {
    CodeError codeError;




    public class Wheels{
        DcMotor[][] bottomMotors = new DcMotor[1][1];
        //We are creating an array for our motors, it will allow use to for statements easily to control the motors;
        //[0][0] is the back left motor and we will treat the rest as if the array values were Xs and Ys Ex. bottomMotor[1][0] is top

        public void init(){

            //Set direction of your motors x and y cordinates in the second part of function
            //Change 'F' to 'R' to reverse
            setDirection('F', 0, 0);
            setDirection('F', 0, 1);
            setDirection('F', 1, 0);
            setDirection('F', 1, 1);


            resetEncoders();
            map();
        }
        private void resetEncoders(){
            for(int i = 0;i < 2;i++){
                for(int p = 0; p < 2 ;p++){
                    bottomMotors[i][p].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    bottomMotors[i][p].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
                }
            }
        }
        private void map(){
            mapMotor(bottomMotors[0][0], "Back Left");
            mapMotor(bottomMotors[0][1], "Front Left");
            mapMotor(bottomMotors[1][0], "Back Right");
            mapMotor(bottomMotors[1][1], "Front Right");
        }
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
            switch (direct){
                case 'F':
                    d = DcMotorSimple.Direction.FORWARD;
                    break;
                case 'R':
                    d = DcMotorSimple.Direction.REVERSE;
                    break;
                default: d = null;
            }
            if((x == 1 || x == 0) && (x == 0 || x == 1) && (d != null)) {
                bottomMotors[x][y].setDirection(d);
            } else codeError.endOpMode("Directions not set correctly");
        }
    }
    public class CodeError{
        public void endOpMode(String message){
            telemetry.addData("Error", message);
            telemetry.update();
            requestOpModeStop();
        }
    }


    public class Claw{
        final private double openPos = 0;
        final private double closePos = 1;
        private String hardwarename;
        private String hardwarename2;
        private boolean isOne;
        public boolean isOpen;
        Servo s;
        Servo ss;
        Claw(String name){
            isOne = true;
            hardwarename = name;
        }
        Claw(String name, String secondname){
            isOne = false;
            hardwarename = name;
            hardwarename2 = secondname;
        }
        public void init(){

            s = hardwareMap.servo.get(hardwarename);
            if(!isOne){
                s = hardwareMap.servo.get(hardwarename);
                ss = hardwareMap.servo.get(hardwarename2);
            }
            if(s.getPosition() == openPos) isOpen = true;
            else isOpen = false;
        }
        public void close(){
            isOpen = false;
            s.setPosition(closePos);
            if(!isOne){
                ss.setPosition(closePos);
            }
        }
        public void open(){
            isOpen = true;
            s.setPosition(openPos);
            if(!isOne) ss.setPosition(openPos);
        }


    }


}
