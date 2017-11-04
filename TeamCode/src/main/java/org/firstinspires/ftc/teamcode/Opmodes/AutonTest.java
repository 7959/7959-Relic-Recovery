package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonAlgorithms.ActualAuton;
import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 11/2/2017.
 */
@Autonomous(name = "autonTest")
public class AutonTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        RobotMain main = new RobotMain(this,hardwareMap,telemetry, AutonTeam.REDCORNER);
        ActualAuton auton = new ActualAuton(main, AutonTeam.REDCORNER);
        waitForStart();
        auton.run();
    }
}
