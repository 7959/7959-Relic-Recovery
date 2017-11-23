package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.TeleOpAlgorithms.TeleOpControl;
import org.firstinspires.ftc.teamcode.TeleOpAlgorithms.imuTeleOpDualGamepad;

/**
 * Created by Robi on 11/3/2017.
 *
 * TeleOp Program for the most complex possible way
 * TeleOp Subclasses for LinearOpMode in this program are only used to call from the
 * TeleOpAlgorithms Package.
 *
 */
@TeleOp(name = "Big boi TeleOp")
public class FinalTeleOp extends LinearOpMode {
    @Override
    public void runOpMode() {
        //initialize all the classes
        RobotControl robotControl = new RobotControl(this);

        //initialize controls
        TeleOpControl inputControl = new TeleOpControl(gamepad1,gamepad2,robotControl);


        waitForStart();

        //Pull the tail back from autonomous
       // main.JewelArm.setServo(.65);

        //Continually run the control program in the algorithm

    }
}
