package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;

/**
 * Created by Robi on 9/13/2017.
 */
@TeleOp(name = "Test")
public class TestDrive extends LinearOpMode{
    DcMotor driveWheels[][] = new DcMotor[2][2];
    Acceleration acel;
    Velocity vel;
    Position pos;

    @Override
    public void runOpMode() throws InterruptedException {
        InertiaMeasurementUnit imu = new InertiaMeasurementUnit(hardwareMap);

        while(!isStopRequested() && !opModeIsActive()) {
            telemetry.addData("cal", imu.imu.getCalibrationStatus());
            telemetry.update();
        }
        imu.retreiveAcelData();
        acel = InertiaMeasurementUnit.acel;
        vel = InertiaMeasurementUnit.vel;
        pos = InertiaMeasurementUnit.pos;
        waitForStart();
        imu.startIntegration(0,0,0);
        while (opModeIsActive()) {
            imu.retreiveAcelData();
            imu.retreiveVelData();
            imu.retreivePosData();
            vel = imu.getVel();
            pos = imu.getPos();

            telemetry.addData("cal", imu.imu.getCalibrationStatus());
            telemetry.addData("ori", imu.getHeading());
            telemetry.addData("ac", imu.imu.getLinearAcceleration().xAccel);
            telemetry.addData("velX", vel.xVeloc);
            telemetry.addData("velY", vel.yVeloc);
            telemetry.addData("velZ", vel.zVeloc);
            telemetry.addData("AcelX", acel.xAccel);
            telemetry.addData("AcelY", acel.yAccel);
            telemetry.addData("AcelZ", acel.zAccel);

            telemetry.addData("posx", pos.x);
            telemetry.addData("posy", pos.y);
            telemetry.addData("posz", pos.z);

            telemetry.update();

        }


    }
}
