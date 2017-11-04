package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.TeleOpAlgorithms.imuTeleOpDualGamepad;
import org.firstinspires.ftc.teamcode.TeleOpAlgorithms.imuTeleOpSingleGamepad;

/**
 * Created by Robi on 10/27/2017.
 */
@Disabled
@TeleOp(name = "imu test")
public class imuDriveTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotMain main = new RobotMain(this, hardwareMap, telemetry);
        imuTeleOpSingleGamepad control = new imuTeleOpSingleGamepad(main, gamepad1);
        waitForStart();
        while (opModeIsActive()) {
            control.run();
            telemetry.update();
        }
    }
}
