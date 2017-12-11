package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Mechanisms.JewelArm;
import org.firstinspires.ftc.teamcode.Sensors.ColorDistanceSensor;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 12/9/2017.
 */
@Disabled
@Autonomous(name = "jeTest")
public class JewelTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        ColorDistanceSensor colorDistanceSensor = new ColorDistanceSensor(hardwareMap, "Jewel Sensor");
        JewelArm arm = new JewelArm(hardwareMap.servo.get("Sweep Servo"), hardwareMap.servo.get("Jewel Arm"));
        arm.initPos();
        waitForStart();
        while (opModeIsActive()){
            if(gamepad1.a){
                arm.sweep(colorDistanceSensor, AutonTeam.REDMIDDLE);
            } else if(gamepad1.b){
                arm.sweep(colorDistanceSensor, AutonTeam.BLUECORNOR);
            }
        }
    }
}
