package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff.dervativeFinder;


/**
 * Created by Robi on 10/23/2017.
 */

@TeleOp(name = "testDervative")
public class TestMain extends LinearOpMode {

    ModernRoboticsI2cRangeSensor rangeSensor;
    @Override
    public void runOpMode() {
        dervativeFinder finder = new dervativeFinder(new dervativeFinder.dataInput() {
            @Override
            public double getData() {
                return rangeSensor.getDistance(DistanceUnit.CM);
            }

            @Override
            public double DeltaT() {
                try{
                    Thread.sleep(50);
                }catch (Exception e){

                }
                return 50;
            }
        });
        waitForStart();
        while(opModeIsActive()){
            telemetry.addData("Estimated range dervative", finder.getDervative());
            telemetry.update();
        }
    }
}
