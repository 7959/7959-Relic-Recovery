package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Robi on 10/9/2017.
 */

public class WheelsEncoder extends Wheels {

    public WheelsEncoder(DcMotor[][] m){
        MotorWheels = m;
        setDirection();
        setEncoders(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
