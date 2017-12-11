package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonAlgorithms.AutonomousAlgorithm;
import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 12/6/2017.
 */

@Disabled
@Autonomous(name = "Debugging")
public class Autontesting extends LinearOpMode {
    @Override
    public void runOpMode() {
        RobotControl bot = new RobotControl(this);
        AutonomousAlgorithm auton = new AutonomousAlgorithm(bot, AutonTeam.REDMIDDLE) {
            @Override
            public void run() {
                return;
            }
        };
        waitForStart();
    }
}
