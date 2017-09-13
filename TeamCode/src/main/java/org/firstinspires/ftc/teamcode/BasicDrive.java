package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Robi on 9/13/2017.
 */
@TeleOp(name = "Test")
public class BasicDrive extends LinearOpMode{
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    @Override
    public void runOpMode() throws InterruptedException {
        frontLeft = hardwareMap.dcMotor.get("front Left");
        frontRight = hardwareMap.dcMotor.get("front Right");
        backLeft = hardwareMap.dcMotor.get("back Left");
        backRight = hardwareMap.dcMotor.get("back Right");

        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.x) backLeft.setPower(1);
            else backLeft.setPower(0);
            if (gamepad1.b) backRight.setPower(1);
            else backRight.setPower(0);
            if (gamepad1.y) frontLeft.setPower(1);
            else frontLeft.setPower(0);
            if (gamepad1.a) frontRight.setPower(1);
            else frontRight.setPower(0);
        }
    }
}
