package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.ParLift;
import org.firstinspires.ftc.teamcode.Mechanisms.Rotator;

/**
 * Created by Robi on 12/9/2017.
 */
@Disabled
@TeleOp(name = "testRotator")
public class ClawRotator extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Rotator rotator = new Rotator(hardwareMap.dcMotor.get("Glyph Rotator"));
        ParLift parLift = new ParLift(hardwareMap.dcMotor.get("Parallelogram Lift"));
        waitForStart();
        while (opModeIsActive()){

            if(gamepad1.left_bumper) {
                parLift.setPower(.8);
            } else if(gamepad1.right_bumper) parLift.setPower(0);
            else if(gamepad1.right_trigger > .1) {
                parLift.setPower(.05);
            } else parLift.holdPower();



            if(gamepad1.a){
                rotator.rotate();
            } else if(gamepad1.b){
                rotator.reverse();
            } else if(gamepad1.dpad_up){
                rotator.autoRotate(false);
            } else if(gamepad1.dpad_down){
                rotator.autoRotate(true);
            } else rotator.powerOff();
        }
    }
}
