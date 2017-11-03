package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.TeleOpAlgorithms.BasicTeleOpSingleGamePad;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.PosEstimater;

/**
 * Created by Robi on 10/27/2017.
 */
@TeleOp(name = "testTele")
public class TestTeleop extends LinearOpMode {

    protected final DcMotor.Direction frontLeftDir = DcMotorSimple.Direction.FORWARD;
    protected final DcMotor.Direction frontRightDir = DcMotorSimple.Direction.FORWARD;
    protected final DcMotor.Direction backLeftDir = DcMotorSimple.Direction.FORWARD;
    protected final DcMotor.Direction backRightDir = DcMotorSimple.Direction.FORWARD;

    @Override
    public void runOpMode() {

        DcMotor arm = hardwareMap.dcMotor.get("Arm");

        DcMotor MotorWheels[][] = new DcMotor[2][2];
        MotorWheels[0][0] = hardwareMap.dcMotor.get("Back Left");
        MotorWheels[1][0] = hardwareMap.dcMotor.get("Back Right");
        MotorWheels[0][1] = hardwareMap.dcMotor.get("Front Left");
        MotorWheels[1][1] = hardwareMap.dcMotor.get("Front Right");

        Servo arm1 = hardwareMap.servo.get("Claw Right");
        Servo arm2 = hardwareMap.servo.get("Claw Left");

        CRServo pinion1 = hardwareMap.crservo.get("Right Pinion");
        CRServo pinion2 = hardwareMap.crservo.get("Left Pinion");

        MotorWheels[0][0].setDirection(backLeftDir);
        MotorWheels[0][1].setDirection(backRightDir);
        MotorWheels[1][0].setDirection(frontLeftDir);
        MotorWheels[1][1].setDirection(frontRightDir);

        MotorWheels[0][0].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorWheels[0][1].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorWheels[1][0].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        MotorWheels[1][1].setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        arm.setDirection(DcMotorSimple.Direction.REVERSE);

        /*arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);*/

        //RobotMain main = new RobotMain(this, hardwareMap, telemetry);
        //BasicTeleOpSingleGamePad control = new BasicTeleOpSingleGamePad(main, gamepad1);
        pinion2.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        double powerFactor = .5;
        boolean isPressed = false;
        boolean isclosed = true;
        while(opModeIsActive()){

            if(gamepad1.right_trigger > .2){
                arm1.setPosition(0);
                arm2.setPosition(1);
            } else if(gamepad1.left_trigger > .2){
                arm1.setPosition(1);
                arm2.setPosition(0);
            }
            if(gamepad1.right_trigger > .2 && isPressed){

                isPressed = true;
                isclosed = !isclosed;
               // arm1.setPosition(1);
               // arm2.setPosition(0);
            } else if(isPressed && gamepad1.right_trigger <= .2){
                isPressed = false;
                //arm1.setPosition(0);
                //arm2.setPosition(1 );
            }

            if(gamepad1.dpad_up){
                pinion1.setPower(1);
                pinion2.setPower(1);
            } else if(gamepad1.dpad_down){
                pinion1.setPower(-1);
                pinion2.setPower(-1);
            } else {
                pinion1.setPower(0);
                pinion2.setPower(0);
            }
            if(gamepad1.right_bumper) powerFactor = .9;
        else powerFactor = .5;

            if(gamepad1.a){
                arm.setPower(.7);
            } else if(gamepad1.b && gamepad1.left_bumper) arm.setPower(0);
            else if(gamepad1.b) arm.setPower(.05);
            else arm.setPower(.3);

            MotorWheels[0][0].setPower(powerFactor*(-gamepad1.left_stick_y - gamepad1.left_stick_x +gamepad1.right_stick_x));
            MotorWheels[1][1].setPower(powerFactor*(gamepad1.left_stick_y + gamepad1.left_stick_x +gamepad1.right_stick_x));
            MotorWheels[0][1].setPower(powerFactor*(-gamepad1.left_stick_y + gamepad1.left_stick_x +gamepad1.right_stick_x));
            MotorWheels[1][0].setPower(powerFactor*(gamepad1.left_stick_y - gamepad1.left_stick_x +gamepad1.right_stick_x));
        }

    }
}
