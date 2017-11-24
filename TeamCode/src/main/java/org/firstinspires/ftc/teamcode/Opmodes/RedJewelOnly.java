package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonAlgorithms.AutonomousAlgorithm;
import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 11/24/2017.
 */

public class RedJewelOnly extends LinearOpMode {


    @Override
    public void runOpMode(){
        RobotControl bot = new RobotControl(this);
        AutonomousAlgorithm auton = new AutonomousAlgorithm(bot, AutonTeam.REDMIDDLE) {
            @Override
            public void run() {
                jewelKnock();
            }
        };


    }
}
