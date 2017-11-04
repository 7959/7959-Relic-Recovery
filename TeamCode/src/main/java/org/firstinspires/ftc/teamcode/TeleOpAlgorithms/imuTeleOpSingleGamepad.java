package org.firstinspires.ftc.teamcode.TeleOpAlgorithms;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.WheelControl.BasicWheels;
import org.firstinspires.ftc.teamcode.WheelControl.WheelsImu;

import static org.firstinspires.ftc.teamcode.TeleOpAlgorithms.BasicTeleOpSingleGamePad.driveMode.SLOW;

/**
 * Created by Robi on 10/25/2017.
 */

public class imuTeleOpSingleGamepad extends BasicTeleOpSingleGamePad {


    public imuTeleOpSingleGamepad(){

    }

    public imuTeleOpSingleGamepad(RobotMain main, Gamepad gamepad1){
        this.main = main;
        this.gamepad1 = gamepad1;
        this.main.drive = new WheelsImu(main.imu,main.hwMap);
    }


    public double savedAngles[] = {0,0,0,0};
    protected double turnIncrease = .8;
    @Override
    protected void drive(Gamepad controller) {


        if(controller.dpad_right && controller.left_bumper) savedAngles[0] = main.imu.getHeading();
        if(controller.dpad_up && controller.left_bumper) savedAngles[1] = main.imu.getHeading();
        if(controller.dpad_left && controller.left_bumper) savedAngles[2] = main.imu.getHeading();
        if(controller.dpad_up && controller.left_bumper) savedAngles[3] = main.imu.getHeading();


        if(controller.right_bumper) mode = driveMode.FAST;
        else{
            if(isSlow) mode = SLOW;
            else mode = driveMode.NORMAL;
        }
        if(controller.start && !isPressed){
            isSlow = !isSlow;
            isPressed = true;
        } else if(!controller.start && isPressed) isPressed = false;

        double input[] = {controller.left_stick_x, controller.left_stick_y};
        switch (mode){
            case SLOW:{
                input[0] *= .33;
                input[1] *= .33;
                turnIncrease =  .5;
            }
            case NORMAL:{
                input[0] *= .66;
                input[1] *= .66;
                turnIncrease = .8;
            }
            case FAST:{
                input[0] *= 1;
                input[1] *= 1;
                turnIncrease = 1;
            }
        }

        if(controller.a && controller.dpad_right) main.drive.movebyCart(input, savedAngles[0]);
        else if (controller.a && controller.dpad_up) main.drive.movebyCart(input, savedAngles[1]);
        else if (controller.a && controller.dpad_left) main.drive.movebyCart(input, savedAngles[2]);
        else if (controller.a && controller.dpad_down) main.drive.movebyCart(input, savedAngles[3]);
        else main.drive.overrideDrive(input, controller.right_stick_x * turnIncrease);
        //desiredAngle += controller.right_stick_x * main.turnsensitivity;
    }

}
