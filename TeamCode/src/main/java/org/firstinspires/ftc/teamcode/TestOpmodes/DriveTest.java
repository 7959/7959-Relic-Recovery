package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.LinearExtension;
import org.firstinspires.ftc.teamcode.WheelControl.BasicDrive;
import org.firstinspires.ftc.teamcode.WheelControl.WheelControl;

/**
 * Created by Robi on 12/9/2017.
 */
@Disabled
@TeleOp(name = "driveTest")
public class DriveTest extends LinearOpMode {
    @Override
    public void runOpMode() {
        BasicDrive drive = new BasicDrive(hardwareMap.dcMotor.get("Back Left"), hardwareMap.dcMotor.get("Back Right"),hardwareMap.dcMotor.get("Front Left"), hardwareMap.dcMotor.get("Front Right"));
        LinearExtension linearExtension = new LinearExtension(hardwareMap.dcMotor.get("Pulley Motor"), hardwareMap.dcMotor.get("Retract Motor"));
        waitForStart();
        while (opModeIsActive()){
            if(gamepad1.dpad_down){
                linearExtension.extend(.5);
            } else if(gamepad1.dpad_up){
                linearExtension.retract(.5);
            } else linearExtension.powerOff();


            if (gamepad1.a){
                drive.frontRightTest();
            } else if(gamepad1.b){
                drive.frontLeftTest();
            } else if(gamepad1.y){
                drive.backLeftTest();
            } else if(gamepad1.x){
                drive.backRightTest();
            } else drive.powerOff();
        }
    }
}
