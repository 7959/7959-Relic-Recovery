package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 9/13/2017.
 */
@TeleOp(name = "Test")
public class TestDrive extends LinearOpMode{
    DcMotor frontLeft;
    DcMotor frontRight;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor driveWheels[][] = new DcMotor[2][2];

    @Override
    public void runOpMode() throws InterruptedException {
        double p;
        frontLeft = hardwareMap.dcMotor.get("front Left");
        frontRight = hardwareMap.dcMotor.get("front Right");
        backLeft = hardwareMap.dcMotor.get("back Left");
        backRight = hardwareMap.dcMotor.get("back Right");
        waitForStart();
        while (opModeIsActive()) {
            p = gamepad1.left_stick_x;
            if (gamepad1.x) backLeft.setPower(p);
            else backLeft.setPower(0);
            if (gamepad1.b) backRight.setPower(p);
            else backRight.setPower(0);
            if (gamepad1.y) frontLeft.setPower(p);
            else frontLeft.setPower(0);
            if (gamepad1.a) frontRight.setPower(p);
            else frontRight.setPower(0);
        }


    }
}
