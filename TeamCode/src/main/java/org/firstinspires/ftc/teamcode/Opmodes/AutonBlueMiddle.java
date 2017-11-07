package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonAlgorithms.ActualAuton;
import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 11/3/2017.
 * Autonomous Program for Blue Middle.
 * Autonomous Subclasses for LinearOpMode in this program are only used to call from the
 * AutonAlgorithms Package.
 */
@Autonomous(name = "BlueMiddle")
public class AutonBlueMiddle extends LinearOpMode{
    @Override
    public void runOpMode() {
        //Initializes all the classes
        RobotMain main = new RobotMain(this, hardwareMap, telemetry, AutonTeam.BLUEMIDDLE);

        //Initialize the Autonomous class
        ActualAuton auton = new ActualAuton(main, AutonTeam.BLUEMIDDLE);
        waitForStart();
        //START!
        auton.run();
    }
}
