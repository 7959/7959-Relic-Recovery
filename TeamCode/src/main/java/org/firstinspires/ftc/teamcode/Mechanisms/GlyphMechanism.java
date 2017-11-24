package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 11/23/2017.
 */

public class GlyphMechanism {
    Servo rotationServo;
    private final double defaultPos = 0;
    private final double flippedPos = 1;
    Servo[] Claw1 = new Servo[2];
    Servo[] Claw2 = new Servo[2];

    public GlyphMechanism(HardwareMap hardwareMap){
        rotationServo = hardwareMap.servo.get("Claw Rotate");
        rotationServo.setPosition(defaultPos);

        Claw1[0] = hardwareMap.servo.get("Bottom Claw Left");
        Claw1[1] = hardwareMap.servo.get("Bottom Claw Right");

        Claw2[0] = hardwareMap.servo.get("Top Claw Left");
        Claw2[1] = hardwareMap.servo.get("Top Claw Right");
    }

    private boolean isFlipped = false;


    public void rotate(){
        if(isFlipped){
            rotationServo.setPosition(defaultPos);
        } else  rotationServo.setPosition(flippedPos);

        isFlipped = !isFlipped;

    }


    public void rotate(double pos){
        rotationServo.setPosition(pos);
    }


    public void claw1Control(ClawPositions position){
        Claw1[0].setPosition(position.pos);
        Claw1[1].setPosition(1-position.pos);
    }

    public void claw1Control(double position){
        Claw1[0].setPosition(position);
        Claw1[1].setPosition(1-position);
    }



    public void claw2Control(ClawPositions position){
        Claw2[0].setPosition(position.pos);
        Claw2[1].setPosition(1-position.pos);
    }


    public void claw2Control(double position){
        Claw2[0].setPosition(position);
        Claw2[1].setPosition(1-position);
    }



    public enum ClawPositions{
        OPEN(1), CLOSED(0), RELEASE(.2);
        public final double pos;

        ClawPositions(double pos) {
            this.pos = pos;
        }


    }



}
