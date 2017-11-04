package org.firstinspires.ftc.teamcode.TeleOpAlgorithms;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.WheelControl.BasicWheels;

/**
 * Created by Robi on 10/25/2017.
 */

public class BasicTeleOpDualGamePad extends BasicTeleOpSingleGamePad {
    protected Gamepad gamepad2;


    public BasicTeleOpDualGamePad(){

    }

    public BasicTeleOpDualGamePad(RobotMain main, Gamepad gamepad1, Gamepad gamepad2){
        this.main = main;
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
        //this.main.drive = new BasicWheels(main.hwMap);
    }

    @Override
    public void run() {
        drive(gamepad1);
        chassisPinionControl(gamepad2);
        liftControl(gamepad2);
        relicArmControl(gamepad2);
        relicClawControl(gamepad2);
        main.tele.addData("Drive Mode", mode);
    }

}
