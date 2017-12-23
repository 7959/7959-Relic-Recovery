package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.WheelControl.BasicDrive;

/**
 * Created by Robi on 12/23/2017.
 */

public class DrivingTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        BasicDrive drive = new BasicDrive(hardwareMap.dcMotor.get("Back Left"), hardwareMap.dcMotor.get("Back Right"), hardwareMap.dcMotor.get("Front Left"), hardwareMap.dcMotor.get("Front Right"));
        waitForStart();
        while (opModeIsActive()){
            if(!gamepad1.start) {
                drive.movebyCart(gamepad1.left_stick_x, gamepad1.left_stick_x, gamepad1.right_stick_x);
            } else if(gamepad1.a){
                drive.backLeftTest();
            } if(gamepad1.b){
                drive.backRightTest();
            } else if(gamepad1.y){
                drive.frontLeftTest();
            } else if (gamepad1.x){
                drive.frontRightTest();
            }
        }
    }
}
