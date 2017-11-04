package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.TeleOpAlgorithms.BasicTeleOpSingleGamePad;

/**
 * Created by Robi on 10/26/2017.
 */
@Disabled
@TeleOp(name = "whTest")
public class TeleOpWheelTest extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        //RobotMain main = new RobotMain(this, hardwareMap, telemetry);
        DcMotor MotorWheels[][] = new DcMotor[2][2];

        //MotorWheels[0][0] = hardwareMap.dcMotor.get("Back Left");
        MotorWheels[1][0] = hardwareMap.dcMotor.get("Back Right");
        //MotorWheels[0][1] = hardwareMap.dcMotor.get("Front Left");
        //MotorWheels[1][1] = hardwareMap.dcMotor.get("Front Right");
       // BasicTeleOpSingleGamePad control = new BasicTeleOpSingleGamePad(main, gamepad1);
        waitForStart();
        while(opModeIsActive()){
            //MotorWheels[1][1].setPower(1);
            //Thread.sleep(1000);
            /*MotorWheels[0][1].setPower(0);
*/
           // MotorWheels[0][1].setPower(1);
            //Thread.sleep(1000);
            //MotorWheels[0][1].setPower(0);

           // MotorWheels[0][0].setPower(1);
           // Thread.sleep(1000);
           // MotorWheels[0][1].setPower(0);

            //MotorWheels[1][0].setPower(1);
            //Thread.sleep(1000);
            //MotorWheels[0][1].setPower(0);
        }
    }
}
