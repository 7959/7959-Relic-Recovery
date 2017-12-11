package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.LinearExtension;

/**
 * Created by Robi on 12/8/2017.
 */
@Disabled
@TeleOp(name = "extensiontest")
public class extensiontest extends LinearOpMode {
    @Override
    public void runOpMode() {
        LinearExtension extension = new LinearExtension(hardwareMap.dcMotor.get("Pulley Motor"), hardwareMap.dcMotor.get("Retract Motor"));
        double power = 0;
        waitForStart();
        while(opModeIsActive()){
            telemetry.addData("Power", power);
            if(gamepad1.dpad_down){
                power = gamepad1.right_stick_y;
            }
        if(gamepad1.a){
            extension.extend(power);
        } else if(gamepad1.b){
            extension.retract(power);
        } else extension.powerOff();

    }}
}
