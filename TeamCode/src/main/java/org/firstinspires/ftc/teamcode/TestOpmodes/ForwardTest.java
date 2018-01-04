package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.WheelControl.BasicDrive;

/**
 * Created by Robi on 12/29/2017.
 */
@Autonomous(name = "Forward Test")
public class ForwardTest extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        BasicDrive drive = new BasicDrive(hardwareMap.dcMotor.get("Back Left"), hardwareMap.dcMotor.get("Back Right"), hardwareMap.dcMotor.get("Front Left"), hardwareMap.dcMotor.get("Front Right"));
        waitForStart();
        while (opModeIsActive()){
            drive.movebyCart(0,1,0);
        }
    }
}
