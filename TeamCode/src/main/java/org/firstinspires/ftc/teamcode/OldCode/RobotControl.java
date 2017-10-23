package org.firstinspires.ftc.teamcode.OldCode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

/**
 * Created by Robi on 9/15/2017.
 */
@Deprecated
public abstract class RobotControl extends LinearOpMode {
    RobotUtil robotUtil;
    ModernRoboticsI2cGyro Gyro; // Replace later
    final static DistanceUnit distanceUnit = DistanceUnit.INCH;
    final static int positioninterval = 1000;//in ms

    public class Wheels{
        public double Rdirection;
        public double Cdirection;
        public double speed;
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

        public void gyrodrivetime(double xVel,double yVel, double angle, double time){
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
        final double angletranslation = Math.PI/2;
        public void Controldrive(double xInput, double yInput, double AngularVelcoityInput){

            double mag = Math.sqrt(xInput*xInput + yInput*yInput);
            double theta = Math.atan2(yInput, xInput);

            double yVel = mag * Math.sin(theta- angletranslation);
            double xVel = mag * Math.cos(theta- angletranslation);

            bottomMotors[0][0].setPower(xVel + AngularVelcoityInput);
            bottomMotors[1][1].setPower(-xVel + AngularVelcoityInput);
            bottomMotors[1][0].setPower(yVel + AngularVelcoityInput);
            bottomMotors[1][0].setPower(-yVel + AngularVelcoityInput);

        }


        public void vectorDrivetime(double xVel, double yVel, double AngularVelocity, double time){
            //add in Gyroscopic correction later if time
            //Base vectors consist of the maximum linear velocity a each wheel as the x and y directions
            //Angular velocity is added by adding power in a single direction to every motor. Vectors x and y cancel out and it will rotate.
            //[0][0] pos x vector
            //[1][1] neg x
            //[0][1] neg y
            //[1][0] pos y
            Rdirection = Math.atan2(yVel, xVel) - angletranslation;
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
            if((x == 1 || x == 0) && (y == 0 || y == 1) && (d != null)) {
                bottomMotors[x][y].setDirection(d);
            } else robotUtil.endOpMode("Directions not set correctly");
        }
    }
    public class RobotUtil {
        public void endOpMode(String message) {
            telemetry.addData("Error", message);
            telemetry.update();
            requestOpModeStop();
        }
        
    }



    public class IMU{
        IMU(){
        }

        BNO055IMU imu;

        public void init(String name){
            //Setts parameters for our IMU sensor.(We use Radians and meters per sec per sec)
            BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
            parameters.angleUnit = BNO055IMU.AngleUnit.RADIANS;
            parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
            parameters.calibrationDataFile = "I don't have a file here yet, but imagine a .json file here";
            parameters.loggingEnabled = true;
            parameters.loggingTag = "IMU";
            parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

            //Map it on the hardware map
            imu = hardwareMap.get(BNO055IMU.class, name);

            //Initialize the parameters
            imu.initialize(parameters);
        }
        public void startIntegration(double x, double y, double z){
            imu.startAccelerationIntegration(new Position(distanceUnit,x,y,z,0), new Velocity(), positioninterval);
        }
        public double[] getaccel(){
            return new double[] {imu.getAcceleration().xAccel, imu.getAcceleration().yAccel , imu.getAcceleration().zAccel};
        }
        public double[] getPos(){
            return new double[] {imu.getPosition().x, imu.getPosition().y, imu.getPosition().z};
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

    void createTelemetry(){

    }


}
