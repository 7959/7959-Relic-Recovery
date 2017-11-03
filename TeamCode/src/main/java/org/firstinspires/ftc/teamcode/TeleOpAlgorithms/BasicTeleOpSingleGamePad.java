package org.firstinspires.ftc.teamcode.TeleOpAlgorithms;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.WheelControl.BasicWheels;
import org.firstinspires.ftc.teamcode.WheelControl.Wheels;

/**
 * Created by Robi on 10/24/2017.
 */

public class BasicTeleOp {
    protected RobotMain main;
    protected Gamepad gamepad1;
    protected Gamepad gamepad2;

    


    public BasicTeleOp(RobotMain main, Gamepad gamepad1, Gamepad gamepad2){
        this.main = main;
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
        this.main.drive = new BasicWheels(main.hwMap);
    }
    public void run(){

        drive();
        chassisPinionControl();

    }

    protected void chassisPinionControl(){
        if(gamepad2.dpad_up)
            main.chassisPinion.setPower(1);
        else if(gamepad2.dpad_down)
            main.chassisPinion.setPower(-1);
        else main.chassisPinion.setPower(0);
    }

    protected void drive(){
        double input[] = {gamepad1.left_stick_x, gamepad2.left_stick_y};
        main.drive.movebyCart(input, gamepad1.right_stick_x);
    }





}
