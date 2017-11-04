package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.RobotMain;


/**
 * Created by Robi on 10/23/2017.
 */
@Disabled
@TeleOp(name = "MainTest")
public class TestMain extends LinearOpMode {
    DcMotor MotorWheels[][] = new DcMotor[2][2];
    @Override
    public void runOpMode() throws InterruptedException {
        MotorWheels[0][0] = hardwareMap.dcMotor.get("Back Left");
        MotorWheels[1][0] = hardwareMap.dcMotor.get("Back Right");
        MotorWheels[0][1] = hardwareMap.dcMotor.get("Front Left");
        MotorWheels[1][1] = hardwareMap.dcMotor.get("Front Right");
        waitForStart();
        while(opModeIsActive()){

        }
    }
}
