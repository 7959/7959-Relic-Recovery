package org.firstinspires.ftc.teamcode;

/**
 * Created by Robi on 9/14/2017.
 */

public class TestAuton extends RobotControl {
    Wheels drive;
    @Override
    public void runOpMode() throws InterruptedException {
        drive.directPower(0,0,1);

    }
}
