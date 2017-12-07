package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Sensors.ColorDistanceSensor;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 12/6/2017.
 */

public class JewelArm {
    private CRServo sweepServo;
    public Servo servo;
    private final double downPos = .5;
    private final double upPos = 0;
    private boolean isRed = false;
    private int sweepTimeInterval = 100;
    private LinearOpMode opMode;
    private crServoTimeMove crServoControl;

    public JewelArm(CRServo sweepServo, Servo servo, LinearOpMode opMode) {
        this.sweepServo = sweepServo;
        this.servo = servo;
        crServoControl = new crServoTimeMove(sweepServo);
        this.opMode = opMode;
    }
    public void setTeam(AutonTeam team){
        if(!team.isRed()) {
            crServoControl.invertPower();
            isRed = false;
        } else isRed = true;
    }
    public void sweep(ColorDistanceSensor sensor){
        servo.setPosition(downPos);
        opMode.sleep(250);
        if(isRed){
            if(sensor.isRed()){
                crServoControl.invertPower();
            }
        } else {
            if(!sensor.isRed()){
                crServoControl.invertPower();
            }
        }
        crServoControl.start();

    }


    private class crServoTimeMove extends Thread {
        private CRServo servo;
        private double power = 1;
        public crServoTimeMove(CRServo servo){
            this.servo = servo;
        }


        @Override
        public void run() {
            servo.setPower(power);
            try {
                Thread.sleep(sweepTimeInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            servo.setPower(0);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            servo.setPower(-power);
            try {
                Thread.sleep(sweepTimeInterval);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            servo.setPower(0);
        }

        public void invertPower() {
            this.power *= -1;
        }

    }
}