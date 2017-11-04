package org.firstinspires.ftc.teamcode.TestOpmodes;

import android.graphics.drawable.VectorDrawable;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.matrices.VectorF;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.RobotUtilities;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.WheelControl.Wheels;
import org.firstinspires.ftc.teamcode.WheelControl.WheelsImu;

/**
 * Created by Robi on 10/13/2017.
 */
@Disabled
@TeleOp(name = "imuDrive")
public class TeleOpDrive extends LinearOpMode {
    final double turnsensitivity = Math.PI/32;
    @Override
    public void runOpMode() throws InterruptedException {
        InertiaMeasurementUnit imu = new InertiaMeasurementUnit(hardwareMap);
        Wheels drive = new WheelsImu(imu, hardwareMap);
        waitForStart();
        double angle = 0;
        double input[] = new double[2];

        waitForStart();
        while (opModeIsActive()){

            input[0] = gamepad1.left_stick_x;
            input[1] = gamepad1.left_stick_y;

            angle = RobotUtilities.fixRads(angle + (gamepad1.right_stick_x * turnsensitivity));
            drive.movebyCart(input, angle);

        }


    }
}
