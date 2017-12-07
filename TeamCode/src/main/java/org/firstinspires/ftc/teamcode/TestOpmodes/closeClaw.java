package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.Claw;

/**
 * Created by Robi on 12/6/2017.
 */
@TeleOp(name = "CloseClaw")
public class closeClaw extends LinearOpMode{
    @Override
    public void runOpMode() {
        Claw claw = new Claw(hardwareMap.servo.get("Servo1"),hardwareMap.servo.get("Servo2"));

        waitForStart();
        while (opModeIsActive()){
            claw.setPos(.5,.5);

        }
    }
}
