package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonAlgorithms.ActualAuton;
import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 11/3/2017.
 */
@Autonomous(name = "BlueMiddle")
public class AutonBlueMiddle extends LinearOpMode{
    @Override
    public void runOpMode() {
        RobotMain main = new RobotMain(this, hardwareMap, telemetry, AutonTeam.BLUEMIDDLE);
        ActualAuton auton = new ActualAuton(main, AutonTeam.BLUEMIDDLE);
        waitForStart();
        auton.run();
    }
}
