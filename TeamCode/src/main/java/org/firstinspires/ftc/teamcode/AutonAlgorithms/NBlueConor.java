package org.firstinspires.ftc.teamcode.AutonAlgorithms;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Sensors.ColorDistanceSensor;

/**
 * Created by Robi on 10/27/2017.
 */
@Autonomous(name = "SAFE RIGHT CONNOR")
public class NBlueConor extends LinearOpMode {
    protected final DcMotor.Direction frontLeftDir = DcMotorSimple.Direction.FORWARD;
    protected final DcMotor.Direction frontRightDir = DcMotorSimple.Direction.FORWARD;
    protected final DcMotor.Direction backLeftDir = DcMotorSimple.Direction.FORWARD;
    protected final DcMotor.Direction backRightDir = DcMotorSimple.Direction.FORWARD;
    /*
        protected final DcMotor.Direction frontLeftDir = DcMotorSimple.Direction.REVERSE;
        protected final DcMotor.Direction frontRightDir = DcMotorSimple.Direction.REVERSE;
        protected final DcMotor.Direction backLeftDir = DcMotorSimple.Direction.REVERSE;
        protected final DcMotor.Direction backRightDir = DcMotorSimple.Direction.REVERSE;*/
    DcMotor MotorWheels[][] = new DcMotor[2][2];
    @Override
    public void runOpMode() {
        DcMotor arm = hardwareMap.dcMotor.get("Arm");
        MotorWheels[0][0] = hardwareMap.dcMotor.get("Back Left");
        MotorWheels[1][0] = hardwareMap.dcMotor.get("Back Right");
        MotorWheels[0][1] = hardwareMap.dcMotor.get("Front Left");
        MotorWheels[1][1] = hardwareMap.dcMotor.get("Front Right");

        Servo arm1 = hardwareMap.servo.get("Claw Right");
        Servo arm2 = hardwareMap.servo.get("Claw Left");
        Servo JewelArm = hardwareMap.servo.get("Jewel Arm");
        CRServo pinion1 = hardwareMap.crservo.get("Right Pinion");
        CRServo pinion2 = hardwareMap.crservo.get("Left Pinion");

        ColorDistanceSensor CDSensor = new ColorDistanceSensor(hardwareMap, "Color Distance");

        MotorWheels[0][0].setDirection(backLeftDir);
        MotorWheels[0][1].setDirection(backRightDir);
        MotorWheels[1][0].setDirection(frontLeftDir);
        MotorWheels[1][1].setDirection(frontRightDir);

        MotorWheels[0][0].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorWheels[0][1].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorWheels[1][0].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorWheels[1][1].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        arm.setDirection(DcMotorSimple.Direction.REVERSE);

        /*RelicArm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RelicArm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RelicArm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RelicArm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);*/

        //RobotMain main = new RobotMain(this, hardwareMap, telemetry);
        //BasicTeleOpSingleGamePad control = new BasicTeleOpSingleGamePad(main, gamepad1);
        pinion2.setDirection(DcMotorSimple.Direction.REVERSE);
        JewelArm.scaleRange(0,1);
        JewelArm.setPosition(.6);

        waitForStart();


        JewelArm.setPosition(0);
        sleep(1000);
        if(CDSensor.isRed()){
            drive(1,0,0,.5);
            sleep(2000);
        } else {
            drive(-1,0,0,.5);
            sleep(1000);
            JewelArm.setPosition(.5);
            drive(0,0,0,0);
            sleep(1000);
            drive(1,0,0,.5);
            sleep(3000);
        }
        JewelArm.setPosition(.5);
        drive(0,0,0,0);
        pinion1.setPower(1);
        pinion2.setPower(1);
        sleep(10000);
    }

    private void drive(double x, double y, double turn, double powerFactor){
        MotorWheels[0][0].setPower(powerFactor*(-y - x +turn));
        MotorWheels[1][1].setPower(powerFactor*(y + x +turn));
        MotorWheels[0][1].setPower(powerFactor*(-y + x +turn));
        MotorWheels[1][0].setPower(powerFactor*(y - x +turn));
    }
}
