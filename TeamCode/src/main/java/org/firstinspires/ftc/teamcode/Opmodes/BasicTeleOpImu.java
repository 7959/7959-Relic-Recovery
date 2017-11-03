package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.TeleOpAlgorithms.BasicTeleOpSingleGamePad;
import org.firstinspires.ftc.teamcode.WheelControl.Wheels;
import org.firstinspires.ftc.teamcode.WheelControl.WheelsImu;

/**
 * Created by Robi on 10/27/2017.
 */
@TeleOp(name = "TeleopImu")
public class BasicTeleOp extends LinearOpMode {

    @Override
    public void runOpMode(){
        RobotMain main = new RobotMain(this,hardwareMap,telemetry);
        Wheels drive = new WheelsImu(main.imu, hardwareMap);
        BasicTeleOpSingleGamePad control = new BasicTeleOpSingleGamePad(main, gamepad1);
        waitForStart();
        while (opModeIsActive()){
            control.run();
        }
    }
}
