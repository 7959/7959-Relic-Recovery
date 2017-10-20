package org.firstinspires.ftc.teamcode.UtilitiesandMic;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cCompassSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;

/**
 * Created by Robi on 10/16/2017.
 */

public class PosEstimater implements Runnable {
    Acceleration acel;
    Velocity vel;
    public Position pos;
    public Position imuPos;
    LinearOpMode opmode;
    InertiaMeasurementUnit imu;
    PosEstimater(Acceleration a, InertiaMeasurementUnit imu, LinearOpMode opMode){
        this.imu = imu;
        acel = a;
        this.opmode = opMode;
    }
    public void run(){
        while(opmode.opModeIsActive()){
            imuPos = imu.getPos();




        }
    }
}
