package org.firstinspires.ftc.teamcode.UtilitiesandMic;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cCompassSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.WheelControl.Wheels;
import org.firstinspires.ftc.teamcode.WheelControl.WheelsEncoded;

/**
 * Created by Robi on 10/16/2017.
 */

public class PosEstimater extends Thread {
    Velocity vel;
    Position estimate;
    public Acceleration imuAccel;
    public Velocity imuVel;
    public Position imuPos;

    Wheels encoders;

    LinearOpMode opmode;
    InertiaMeasurementUnit imu;
    private double imuWeight = 0;
    private double encoderWeight = 0;
    private double cameraWeight= 0;
    public PosEstimater(Wheels wheelsEncoded, InertiaMeasurementUnit imu, LinearOpMode opMode){
        this.imu = imu;
        this.encoders = wheelsEncoded;
        this.opmode = opMode;
    }
    public void setWeights(double imuWeight, double encoderWeight, double cameraWeight){
        this.imuWeight = imuWeight;
        this.encoderWeight = encoderWeight;
        this.cameraWeight = cameraWeight;
    }


    public void run(){
        while(opmode.opModeIsActive()){
            imuPos = imu.getPos();
            estimate.x +=imuPos.x * imuWeight;
            estimate.y +=imuPos.y * imuWeight;
            estimate.z +=imuPos.z * imuWeight;
            //Add other sections later
        }
    }
}
