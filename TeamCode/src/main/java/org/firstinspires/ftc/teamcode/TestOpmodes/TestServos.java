package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Mechanisms.Claws.ClawInterface;
import org.firstinspires.ftc.teamcode.Mechanisms.Claws.DoubServ;
import org.firstinspires.ftc.teamcode.Mechanisms.HorizontalMovement;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.WheelControl.BasicWheels;

/**
 * Created by Robi on 10/18/2017.
 */
@TeleOp(name = "Servo Test")
public class TestingAndDebugging extends LinearOpMode {
    final double startR = 0;
    final double startL = 0;
    final double stopR = 1;
    final double stopL = 1;
    @Override
    public void runOpMode() throws InterruptedException {
       // BasicWheels drive = new BasicWheels(hardwareMap);
        ClawInterface cubeHandler = new DoubServ(hardwareMap,"ClawServoR","ClawServoL",startR,startL,stopR,stopL);
        HorizontalMovement pinions = new HorizontalMovement(hardwareMap,"Pinion1", "Pinion2", DcMotor.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);
        waitForStart();

        while (opModeIsActive()){
           /* if(gamepad1.dpad_up){
                cubeHandler.close();
            }
            if(gamepad1.dpad_down){
                cubeHandler.open();
            }*/
            if(gamepad1.dpad_right){
                pinions.setPower(1);
            }else if(gamepad1.dpad_left){
                pinions.setPower(-1);
            } else pinions.setPower(0);


        }
    }
}
