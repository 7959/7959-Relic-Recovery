package org.firstinspires.ftc.teamcode.WheelControl;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 10/9/2017.
 */
@Deprecated
public class WheelsEncoded extends BasicWheels {

    /**
     * This subclass of BasicWheels is intended for encoded motors
     * Constructor sets motor encoders to use
     * TeleOpDrive methods will be inherited since there is no difference between DCMotor.setPower syntax
     * When the motor is encoded or not.
     */
    public WheelsEncoded(HardwareMap hwMap){
        super(hwMap);
        setEncoders(DcMotor.RunMode.RUN_USING_ENCODER);
    }



    public String toString(){
        return "Encoded Drive";
    }

}
