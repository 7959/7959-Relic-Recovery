package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.AnalogOutput;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Robi on 12/14/2017.
 */
@TeleOp(group = "Test", name = "MotorTest")
public class Motortest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Directions", "Name two motors 'Motor1' and 'Motor2'");
        telemetry.addData("Controls", "Joysticks control motor power");

        telemetry.update();
        waitForStart();
        DcMotor motor1 = hardwareMap.dcMotor.get("Motor1");
        DcMotor motor2 = hardwareMap.dcMotor.get("Motor2");
        while (opModeIsActive()){

            motor1.setPower(gamepad1.left_stick_y);
            motor2.setPower(gamepad1.right_stick_y);
            telemetry.addData("Motor1Power", motor1.getPower() * 100 + "%");
            telemetry.addData("Motor2Power", motor2.getPower() * 100 + "%");
            telemetry.update();
        }
    }

}
