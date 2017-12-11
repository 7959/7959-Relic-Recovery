package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonAlgorithms.AutonomousAlgorithm;
import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 12/10/2017.
 */
@Autonomous(name = "Red Mid")
public class RedMiddle  extends LinearOpMode{
    @Override
    public void runOpMode(){
        RobotControl bot = new RobotControl(this);
        AutonomousAlgorithm auton = new AutonomousAlgorithm(bot, AutonTeam.REDMIDDLE) {
            @Override
            public void run() {
                jewelKnock();
                park();
            }
        };
        bot.jewelArm.initPos();
        waitForStart();
        auton.run();
    }
}
