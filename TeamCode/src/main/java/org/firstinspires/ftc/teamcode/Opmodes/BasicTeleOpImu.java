package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.Sensors.FindMark;
import org.firstinspires.ftc.teamcode.TeleOpAlgorithms.BasicTeleOpSingleGamePad;
import org.firstinspires.ftc.teamcode.TeleOpAlgorithms.imuTeleOpDualGamepad;
import org.firstinspires.ftc.teamcode.WheelControl.Wheels;
import org.firstinspires.ftc.teamcode.WheelControl.WheelsImu;
import org.firstinspires.ftc.teamcode.TeleOpAlgorithms.imuTeleOpSingleGamepad;

/**
 * Created by Robi on 10/27/2017.
 */
@TeleOp(name = "TeleopImu")
public class BasicTeleOpImu extends LinearOpMode {

    @Override
    public void runOpMode(){
        RobotMain main = new RobotMain(this,hardwareMap,telemetry);
        imuTeleOpSingleGamepad control = new imuTeleOpSingleGamepad(main, gamepad1);
        //FindMark findPictoGraph = new FindMark(hardwareMap, main);
        waitForStart();
        //findPictoGraph.start();
        while (opModeIsActive()){
            telemetry.addData("Mark", main.target);
            control.run();
            telemetry.update();
        }
    }
}
