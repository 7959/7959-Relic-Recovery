package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.AnalogInputController;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Robi on 12/13/2017.
 */

public class GlyphHandler {
    private MotorSync intake;
    private DcMotor arm;
    public AnalogInput potentiometer;
    private final double maxVoltage;
    public GlyphHandler(/*DcMotor intakeR, DcMotor intakeL, DcMotor arm,*/ AnalogInput potentiometer){
        this.potentiometer = potentiometer;
        //this.arm = arm;
        //intake = new MotorSync(intakeR, intakeL);
        maxVoltage = potentiometer.getMaxVoltage();
    }

    public double getRotation(){
       return 100 * potentiometer.getVoltage() / maxVoltage;
    }


    public void directArmPower(double power){
        arm.setPower(power);
    }

    public void setintakePower(double power){
        intake.setPower(power);
    }





}
