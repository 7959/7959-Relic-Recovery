package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gyroscope;
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
    ModernRoboticsI2cGyro Gyro; // Replace later

    public class Sensors{
        public void mapandcalgyro(String name){

        }
    }

    public class Wheels{
        public double Rdirection;
        public double Cdirection;
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
        public void gyrodrive(double xVel,double yVel, double angle, double time){
            double t = getRuntime() + time;
            double angletoturn;
            while(t > getRuntime()){
                angletoturn = Gyro.getIntegratedZValue() - angle;
                angletoturn = angletoturn/100;
                bottomMotors[0][0].setPower(xVel + angletoturn);
                bottomMotors[1][1].setPower(-xVel + angletoturn);
                bottomMotors[1][0].setPower(yVel + angletoturn);
                bottomMotors[1][0].setPower(-yVel + angletoturn);
            }
        }
        public void vectorDrivetime(double xVel, double yVel, double AngularVelocity, double time){
            //add in Gyroscopic correction later if time
            //Base vectors consist of the maximum linear velocity a each wheel as the x and y directions
            //Angular velocity is added by adding power in a single direction to every motor. Vectors x and y cancel out and it will rotate.
            //[0][0] pos x vector
            //[1][1] neg x
            //[0][1] neg y
            //[1][0] pos y
            Rdirection = Math.atan2(yVel, xVel) - 45;
            Cdirection = Math.atan2(yVel, xVel);
            double t = getRuntime()+ time;
            while(t > getRuntime()) {
                bottomMotors[0][0].setPower(xVel + AngularVelocity);
                bottomMotors[1][1].setPower(-xVel + AngularVelocity);
                bottomMotors[1][0].setPower(yVel + AngularVelocity);
                bottomMotors[1][0].setPower(-yVel + AngularVelocity);
            }
            stopMotors();
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
        public void stopMotors(){
            bottomMotors[0][0].setPower(0);
            bottomMotors[1][1].setPower(0);
            bottomMotors[1][0].setPower(0);
            bottomMotors[1][0].setPower(0);
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
