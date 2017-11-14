package org.firstinspires.ftc.teamcode.WheelControl;

import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 11/12/2017.
 */

public class BasicDrive extends WheelControl {

    public BasicDrive(HardwareMap hardwareMap){
        super(hardwareMap);
    }



    //We used to use trig to calculate motor powers, but when optimizing this. We realized it isn't worth the processing power
    @Override
    public void movebyCart(double x, double y, double turnMag) {
        MotorWheels[0][0].setPower(y + x + turnMag);
        MotorWheels[1][0].setPower(y -x - turnMag);
        MotorWheels[0][1].setPower(y - x + turnMag);
        MotorWheels[1][1].setPower(y + x - turnMag);
    }

}
