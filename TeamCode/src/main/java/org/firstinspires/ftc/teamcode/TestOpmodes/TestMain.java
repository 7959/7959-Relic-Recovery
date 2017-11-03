package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.RobotMain;


/**
 * Created by Robi on 10/23/2017.
 */
@TeleOp(name = "MainTest")
public class TestMain extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        RobotMain main = new RobotMain(this, hardwareMap, telemetry);
        waitForStart();
        main.imu.startIntegration(0,0,0);
        while(opModeIsActive()){
            main.imu.retreiveAcelData();
            main.imu.retreiveVelData();
            main.imu.retreivePosData();
            main.imu.retreiveOriData();

            telemetry.addData("Acel", main.accel.toUnit(DistanceUnit.METER).toString());
            telemetry.addData("Vel", main.vel.toUnit(DistanceUnit.METER).toString());
            telemetry.addData("Pos", main.pos.toUnit(DistanceUnit.METER).toString());
            telemetry.addData("Ori", main.ori.toString());
            telemetry.addData("Acel time", main.imu.acel.acquisitionTime);
            telemetry.update();
        }
    }
}
