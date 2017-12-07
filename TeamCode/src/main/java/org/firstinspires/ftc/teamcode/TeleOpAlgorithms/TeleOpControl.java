package org.firstinspires.ftc.teamcode.TeleOpAlgorithms;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Mechanisms.ParLift;
import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.TeleopDriveModes;
import org.firstinspires.ftc.teamcode.WheelControl.IMUDrive;

/**
 * Created by Robi on 11/13/2017.
 */

public class TeleOpControl {
    private Gamepad gamepad1;
    private Gamepad gamepad2;
    private RobotControl bot;
    private TeleopDriveModes driveMode = TeleopDriveModes.NORMAL;


    public TeleOpControl(Gamepad gamepad1, Gamepad gamepad2, RobotControl bot){
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
        this.bot = bot;
    }

    public void run() {
        while (RobotControl.opMode.opModeIsActive()){
            drive(gamepad1);
            relicClawRototation(gamepad1);
            liftControl(gamepad2);
            gylphClawControl(gamepad2);
            relicExtension(gamepad2);
            relicClaw(gamepad2);
        }

    }


    //Index of which angle to use. If equal to -1, robot will not chase an angle.
    private byte targetAngle = -1;

    private double[] savedAngles = new double[3];
    private boolean isPressed = false;
    private boolean isSlow = false;

    private void drive(Gamepad gamepad){

        //Saves angles at drivers request, and sets target angle at drivers request
        if(gamepad.left_bumper && gamepad.right_trigger > .1) savedAngles[0] = bot.imu.getHeading();
        else if(gamepad.left_bumper && gamepad.left_trigger > .1) savedAngles[1] = bot.imu.getHeading();
        else if(gamepad.right_trigger > .1) targetAngle = 0;
        else if(gamepad.left_trigger > .1) targetAngle = 1;
        else targetAngle = -1;


        if(gamepad.right_bumper) driveMode = driveMode.FAST;
        else{
            if(isSlow) driveMode = driveMode.SLOW;
            else driveMode = driveMode.NORMAL;
        }
        if(gamepad.start && !isPressed){
            isSlow = !isSlow;
            isPressed = true;
        } else if(!gamepad.start && isPressed) isPressed = false;


        //Drive
        if(targetAngle != -1){
            bot.drive.movebyCart((driveMode.powerInput(gamepad.left_stick_x, gamepad.left_stick_y)), savedAngles[targetAngle]);
        } else bot.drive.basicMove(driveMode.powerInput(gamepad.left_stick_x, gamepad.left_stick_y), driveMode.turnInput(gamepad.right_stick_x));
    }


    private byte clawPos = 1;
    //1 is front 2 is flipped 3 is right angle
    private void gylphClawControl(Gamepad gamepad){
        if(gamepad.left_trigger > .1 && clawPos != 3){
            bot.botGylph.setPos(90,0);
            bot.topGylph.setPos(90,0);
        } else if(gamepad.left_trigger > .1 && clawPos == 3){
            bot.botGylph.setPos(0,0);
            bot.botGylph.setPos(0,0);
        }
        if(gamepad.right_trigger > .1 && clawPos == 1){
            bot.botGylph.setPos(0,90);
        } else if(gamepad.right_trigger > .1 && clawPos != 1){
            bot.topGylph.setPos(0,90);
        }
        if(gamepad.dpad_up){
            bot.glyphRotator.setPosition(1);
            clawPos = 1;
        } else if(gamepad.dpad_down){
            bot.glyphRotator.setPosition(0);
            clawPos = 2;
        } else if(gamepad.dpad_right){
            bot.glyphRotator.setPosition(.5);
            clawPos = 3;
        }


    }

    private void relicClawRototation(Gamepad gamepad){
        if(gamepad.dpad_up){
            bot.relicRotator.setPosition(1);
        } else if(gamepad.dpad_down){
            bot.relicRotator.setPosition(0);
        }
    }
    private void relicClaw(Gamepad gamepad){
        if(gamepad.right_bumper){
            bot.relicClaw.setPos(90,0);
        } else if(gamepad.left_bumper){
            bot.relicClaw.setPos(90,0);
        }
    }

    private void relicExtension(Gamepad gamepad){
        if(gamepad.x){
            bot.linearExtension.extend(.3);
        } else if(gamepad.y){
            bot.linearExtension.retract(.3);
        }
    }

    private void liftControl(Gamepad gamepad){
        if(gamepad.a){
            bot.parLift.setPower(.5);
        } else if (gamepad.b){
            bot.parLift.setPower(0);
        } else bot.parLift.holdPower();
    }




}
