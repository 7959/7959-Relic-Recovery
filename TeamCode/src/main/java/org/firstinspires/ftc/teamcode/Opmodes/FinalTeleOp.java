package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.UtilitiesandMic.TeleopDriveModes;

/**
 * Created by Robi on 11/3/2017.
 *
 * TeleOp Program for the most complex possible way
 * TeleOp Subclasses for LinearOpMode in this program are only used to call from the
 * TeleOpAlgorithms Package.
 *
 */
@TeleOp(name = "Big boi TeleOp")
public class FinalTeleOp extends OpMode7959 {
    @Override
    public void runOpMode() {

        //initialize all the classes
        setUp(this);

        //initialize controls
        
        
        while (opModeIsActive()){
            drive(gamepad1.left_stick_x,gamepad1.left_stick_y, gamepad1.right_stick_x,gamepad1.left_bumper, gamepad1.right_bumper, gamepad1.right_trigger > .1, gamepad1.left_trigger > .1, gamepad1.start);
            intakeToggle(gamepad2.back);
            wedgeControl(gamepad1.y);

        }
        
        
        
        //Continually run the control program in the algorithm

    }

    private TeleopDriveModes driveMode = TeleopDriveModes.NORMAL;
    private byte targetAngle = -1;
    private double[] savedAngles = new double[3];
    private boolean isPressed = false;
    private boolean isSlow = false;
    private void drive(double moveX, double moveY, double rotateButton, boolean angleSaveButton, boolean boostButton, boolean angle1Button, boolean angle2Button, boolean modeChangeButton){

        //Saves angles at drivers request, and sets target angle at drivers request
        if(angleSaveButton && angle1Button) savedAngles[0] = imu.getHeading();
        else if(angleSaveButton && angle2Button) savedAngles[1] = imu.getHeading();
        else if(angle1Button) targetAngle = 0;
        else if(angle2Button) targetAngle = 1;
        else targetAngle = -1;

        //Speed changing
        if(boostButton) driveMode = driveMode.FAST;
        else{
            if(isSlow) driveMode = driveMode.SLOW;
            else driveMode = driveMode.NORMAL;
        }
        if(modeChangeButton && !isPressed){
            isSlow = !isSlow;
            isPressed = true;
        } else if(!modeChangeButton && isPressed) isPressed = false;


        //Drive
        if(targetAngle != -1){
            drive.movebyCart((driveMode.powerInput(moveX, moveY)), savedAngles[targetAngle]);
        } else drive.basicMove(driveMode.powerInput(moveX, moveY), driveMode.turnInput(rotateButton));

    }

    private boolean isIntakePressed = false;
    private boolean intakeActive = false;
    private void intakeToggle(boolean button){
        if(button && !isIntakePressed){
            intakeActive = !isIntakePressed;
            isIntakePressed = true;
        } else if(!button && isIntakePressed) isIntakePressed = false;
        if(intakeActive) intake.setPower(1);
        else intake.setPower(0);
    }

    private boolean isWedgePressed = false;
    private boolean isWedgeDown = false;
    private void wedgeControl(boolean toggleButton){
        if(toggleButton && !isWedgePressed){
            isWedgeDown = !isWedgeDown;
            isWedgePressed = true;
        } else if(!toggleButton && isWedgePressed) isWedgePressed = false;
    }
}
