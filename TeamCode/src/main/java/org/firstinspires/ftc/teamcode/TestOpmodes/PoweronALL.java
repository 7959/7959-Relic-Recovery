package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.WheelControl.BasicWheels;
import org.firstinspires.ftc.teamcode.WheelControl.Wheels;

/**
 * Created by Robi on 10/26/2017.
 */
@Disabled
@TeleOp(name = "powerAll")
public class PoweronALL extends LinearOpMode{
    @Override
    public void runOpMode() throws InterruptedException {
        Wheels drive = new BasicWheels(hardwareMap);
        waitForStart();
        double input[] = {0,0};
        waitForStart();
        drive.movebyCart(input, 1);
        sleep(5000);
    }
}
