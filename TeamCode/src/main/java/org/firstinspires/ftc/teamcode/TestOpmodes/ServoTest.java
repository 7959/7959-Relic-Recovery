package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.Claw;

/**
 * Created by Robi on 12/14/2017.
 */
@TeleOp(group = "Test", name = "TwoServoTest")
public class ServoTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Directions","Name the servos you need to test 'Servo1' and 'Servo2'");
        telemetry.addData("Controls", "Joysticks control position of servos");
        telemetry.update();
        waitForStart();
        Claw claw = new Claw(hardwareMap.servo.get("Servo1"),hardwareMap.servo.get("Servo2"));
        while (opModeIsActive()){
            claw.setPos(input(gamepad1.left_stick_y), input(gamepad1.right_stick_y));
            telemetry.addData("Servo1", claw.getServo1() * 180 + "Degrees");
            telemetry.addData("Servo2", claw.getServo2() * 180 + "Degrees");
            telemetry.update();
        }
    }
    private double input(double input){
        if(input > 0){
            return input;
        } else {
            return  Math.abs(input) * .5;
        }
    }
}
