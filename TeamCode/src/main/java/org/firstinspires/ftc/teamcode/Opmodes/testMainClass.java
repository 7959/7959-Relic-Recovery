package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;
import org.firstinspires.ftc.teamcode.WheelControl.WheelsImu;

/**
 * Created by Robi on 11/1/2017.
 */
@Autonomous(name = "Debug")
public class testMainClass extends LinearOpMode {
    private RobotMain main;
    @Override
    public void runOpMode() {
        main = new RobotMain(this,hardwareMap, telemetry, AutonTeam.BLUECORNOR);
        main.drive = new WheelsImu(main.imu, hardwareMap);

        waitForStart();
        while (opModeIsActive()){

        }

    }
}
