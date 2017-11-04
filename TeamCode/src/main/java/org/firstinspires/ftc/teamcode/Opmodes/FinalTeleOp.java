package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.VerticalMovement.ParrellagramLift;
import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.TeleOpAlgorithms.imuTeleOpDualGamepad;

/**
 * Created by Robi on 11/3/2017.
 */
@TeleOp(name = "Big boi TeleOp")
public class FinalTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        RobotMain main = new RobotMain(this,hardwareMap,telemetry);
        imuTeleOpDualGamepad control = new imuTeleOpDualGamepad(main,gamepad1,gamepad2);
        waitForStart();
        while (opModeIsActive()) control.run();
    }
}
