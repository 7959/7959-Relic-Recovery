package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * Created by Robi on 12/29/2017.
 */
@TeleOp(group = "Test", name = "UltraSonic Test")
public class UltrasonicTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        final ModernRoboticsI2cRangeSensor rangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "Range Sensor");
        waitForStart();
        while (opModeIsActive()){
            telemetry.addData("Distance", rangeSensor.getDistance(DistanceUnit.CM) + "CM");
            telemetry.update();
        }
    }
}
