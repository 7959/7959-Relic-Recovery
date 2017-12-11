package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Mechanisms.Claw;

/**
 * Created by Robi on 12/6/2017.
 */
@Disabled
@TeleOp(name = "CloseClaw")
public class closeClaw extends LinearOpMode{
    @Override
    public void runOpMode() {
        Claw claw = new Claw(hardwareMap.servo.get("Relic Claw Right"),hardwareMap.servo.get("Relic Claw Left"));
        Servo testrot = hardwareMap.servo.get("Relic Rotator");
        CRServo supportServo = hardwareMap.crservo.get("Support Servo");
        supportServo.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();
        while (opModeIsActive()){
            supportServo.setPower(1);
            testrot.setPosition(0);
            claw.setPos(.8,.05);
        }
    }
}
