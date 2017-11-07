package org.firstinspires.ftc.teamcode.TeleOpAlgorithms;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.WheelControl.WheelsImu;

/**
 * Created by Robi on 10/25/2017.
 *
 * TeleOp Program mostly the same has its superclass but has two drivers
 */

public class imuTeleOpDualGamepad extends imuTeleOpSingleGamepad {
    Gamepad gamepad2;

    //Constructor mostly same as superclass, but uses two gamepads.
    public imuTeleOpDualGamepad(RobotMain main, Gamepad gamepad1, Gamepad gamepad2) {
        this.main = main;
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
        this.main.drive = new WheelsImu(this.main.imu, this.main.hwMap);
    }

    //booleans allow for toggling
    private boolean isPressedToggleClaw;
    private boolean isCubeMode = true;


    //Overridden method allows two drivers and toggleable arm controls for the second driver
    @Override
    public void run() {
        drive(gamepad1);
        chassisPinionControl(gamepad2);
        liftControl(gamepad2);
        relicArmControl(gamepad2);

        //Toggleable button for switching between relic arm and glyph arm
        if(gamepad2.start && !isPressedToggleClaw){
            isCubeMode = !isCubeMode;
            isPressedToggleClaw = true;
        } else if(!gamepad2.start && isPressedToggleClaw) isPressedToggleClaw = false;
        if(isCubeMode)clawControl(gamepad2);
        else relicClawControl(gamepad2);


        main.tele.addData("Drive Mode", mode);
    }
}
