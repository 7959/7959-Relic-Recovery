package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonAlgorithms.ActualAuton;
import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 11/3/2017.
 */
@Autonomous(name = "RedCornor")
public class AutonRedCorner extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        RobotMain main = new RobotMain(this, hardwareMap, telemetry, AutonTeam.REDCORNER);
        ActualAuton auton = new ActualAuton(main, AutonTeam.REDCORNER);
        waitForStart();
        auton.run();
    }
}
