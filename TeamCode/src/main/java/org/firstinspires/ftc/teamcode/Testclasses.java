package org.firstinspires.ftc.teamcode;

import com.qualcomm.ftccommon.ClassManagerFactory;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Robi on 10/9/2017.
 */

public class Testclasses extends LinearOpMode {
    DcMotor drive[][] = new DcMotor[2][2];

    @Override
    public void runOpMode() throws InterruptedException {

        drive[1][0] = hardwareMap.dcMotor.get("name");




        Wheels test = new Wheels(drive);
    }
}
