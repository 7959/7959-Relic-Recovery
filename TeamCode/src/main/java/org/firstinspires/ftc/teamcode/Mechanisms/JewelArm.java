package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.Sensors.ColorDistanceSensor;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 12/6/2017.
 */

public class JewelArm {
    private Servo sweepServo;
    public Servo servo;
    private final double downPos = .5;
    private final double upPos = 0;

    private final double readyToFIRE = .1;
    private boolean isRed = false;
    private int sweepTimeInterval = 100;

    public JewelArm(Servo sweepServo, Servo servo) {
        this.sweepServo = sweepServo;
        this.servo = servo;
    }
    public void setTeam(AutonTeam team){
    }
    public void sweep(ColorDistanceSensor sensor, AutonTeam team) {
        sweepServo.setPosition(readyToFIRE);
        
            RobotControl.opMode.sleep(500);
        
        servo.setPosition(.7);
        
            RobotControl.opMode.sleep(1500);
        
        if (team.isRed()) {
            if (sensor.isRed()) sweepServo.setPosition(0);
            if (sensor.isBlue()) sweepServo.setPosition(.8);
        } else {
            if (sensor.isBlue()) sweepServo.setPosition(0);
            if (sensor.isRed()) sweepServo.setPosition(.8);
        }
        
            RobotControl.opMode.sleep(1000);
        
        servo.setPosition(.2);
        
            RobotControl.opMode.sleep(250);
        
        initPos();
        
            RobotControl.opMode.sleep(500);
        
    }
    public void initPos(){
        servo.setPosition(.1);
        sweepServo.setPosition(.9);

    }



}