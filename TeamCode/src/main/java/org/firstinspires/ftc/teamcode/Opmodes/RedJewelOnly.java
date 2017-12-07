package org.firstinspires.ftc.teamcode.Opmodes;

<<<<<<< HEAD
=======
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
>>>>>>> 108dbbb71754384e8e3a3ade07e197248e50f1ca
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.AutonAlgorithms.AutonomousAlgorithm;
import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 11/24/2017.
 */
<<<<<<< HEAD

=======
@Autonomous(name = "Red Jewel")
>>>>>>> 108dbbb71754384e8e3a3ade07e197248e50f1ca
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
