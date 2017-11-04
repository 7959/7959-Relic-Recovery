package org.firstinspires.ftc.teamcode.TeleOpAlgorithms;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.WheelControl.WheelsImu;

/**
 * Created by Robi on 10/25/2017.
 */

public class imuTeleOpDualGamepad extends imuTeleOpSingleGamepad {
    Gamepad gamepad2;

    public imuTeleOpDualGamepad(RobotMain main, Gamepad gamepad1, Gamepad gamepad2) {
        this.main = main;
        this.gamepad1 = gamepad1;
        this.gamepad2 = gamepad2;
        this.main.drive = new WheelsImu(this.main.imu, this.main.hwMap);
    }
    private boolean isPressedToggleClaw;
    private boolean isCubes = true;
    @Override
    public void run() {
        drive(gamepad1);
        chassisPinionControl(gamepad2);
        liftControl(gamepad2);
        relicArmControl(gamepad2);
        if(gamepad2.start && !isPressedToggleClaw){
            isCubes = !isCubes;
            isPressedToggleClaw = true;
        } else if(!gamepad2.start && isPressedToggleClaw) isPressedToggleClaw = false;
        if(isCubes)clawControl(gamepad2);
        else relicClawControl(gamepad2);
        main.tele.addData("Drive Mode", mode);
    }
}
