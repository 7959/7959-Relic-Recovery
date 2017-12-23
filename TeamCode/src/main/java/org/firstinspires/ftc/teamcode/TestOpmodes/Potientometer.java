package org.firstinspires.ftc.teamcode.TestOpmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Mechanisms.GlyphHandler;

/**
 * Created by Robi on 12/20/2017.
 */
@TeleOp(name = "Potientometer Test")
public class Potientometer extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        GlyphHandler handler = new GlyphHandler(hardwareMap.analogInput.get("Potentiometer"));
        waitForStart();
        while (opModeIsActive()){
            telemetry.addData("Rotation percentage", handler.getRotation());
            telemetry.addData("Voltage", handler.potentiometer.getVoltage());
            telemetry.addData("Max Voltage", handler.potentiometer.getMaxVoltage());
            telemetry.update();
        }
    }
}
