package org.firstinspires.ftc.teamcode.OldCode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
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
@Disabled
@Deprecated
@TeleOp(name = "testBoi")
public class ExtremeBasicTeleop extends LinearOpMode {

    /*protected final DcMotor.Direction frontLeftDir = DcMotorSimple.Direction.FORWARD;
    protected final DcMotor.Direction frontRightDir = DcMotorSimple.Direction.FORWARD;
    protected final DcMotor.Direction backLeftDir = DcMotorSimple.Direction.FORWARD;
    protected final DcMotor.Direction backRightDir = DcMotorSimple.Direction.FORWARD;
*/
    protected final DcMotor.Direction frontLeftDir = DcMotorSimple.Direction.REVERSE;
    protected final DcMotor.Direction frontRightDir = DcMotorSimple.Direction.REVERSE;
    protected final DcMotor.Direction backLeftDir = DcMotorSimple.Direction.REVERSE;
    protected final DcMotor.Direction backRightDir = DcMotorSimple.Direction.REVERSE;
    private enum mode{
        FAST, SLOW, NORMAL
    }
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
        Servo JewelArm = hardwareMap.servo.get("Jewel Arm");

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
        waitForStart();
        double powerFactor;
        boolean isPressed = false;
        boolean slowMode = false;
        mode CurrentMode = mode.NORMAL;
        JewelArm.setPosition(.6);

        double slowTurnFactor = 1;

        while(opModeIsActive()){
            if(!isPressed && gamepad1.start){
                slowMode = !slowMode;
                isPressed = true;
            } else if(isPressed && !gamepad1.start)isPressed = false;



            if(gamepad1.right_bumper){
                CurrentMode = mode.FAST;
            } else if(slowMode) CurrentMode = mode.SLOW;
            else CurrentMode = mode.NORMAL;

            if(gamepad1.right_trigger > .2){
                arm1.setPosition(0);
                arm2.setPosition(1);
            } else if(gamepad1.left_trigger > .2){
                arm1.setPosition(1);
                arm2.setPosition(0);
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

            if(gamepad1.y) arm.setPower(-.3);
            if(gamepad1.a && gamepad1.left_bumper) arm.setPower(.9);
            else if(gamepad1.a){
                arm.setPower(.7);
            } else if(gamepad1.b && gamepad1.left_bumper) arm.setPower(0);
            else if(gamepad1.b) arm.setPower(.05);
            else arm.setPower(.3);




            if(CurrentMode == mode.NORMAL){
                powerFactor = .5;
                slowTurnFactor = 1;
            } else if(CurrentMode == mode.SLOW){
                powerFactor = .2;
                slowTurnFactor = .5;
            } else if(CurrentMode == mode.FAST){
                powerFactor = .9;
                slowTurnFactor = 1;
            }
            telemetry.addData("Mode", CurrentMode);
            telemetry.update();

            MotorWheels[0][0].setPower(powerFactor*(-gamepad1.left_stick_y - gamepad1.left_stick_x +(gamepad1.right_stick_x * slowTurnFactor)));
            MotorWheels[1][1].setPower(powerFactor*(gamepad1.left_stick_y + gamepad1.left_stick_x +(gamepad1.right_stick_x * slowTurnFactor)));
            MotorWheels[0][1].setPower(powerFactor*(-gamepad1.left_stick_y + gamepad1.left_stick_x +(gamepad1.right_stick_x * slowTurnFactor)));
            MotorWheels[1][0].setPower(powerFactor*(gamepad1.left_stick_y - gamepad1.left_stick_x +(gamepad1.right_stick_x*slowTurnFactor)));
        }

    }
}
