package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Mechanisms.MotorSync;
import org.firstinspires.ftc.teamcode.Mechanisms.ServoSync;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.WheelControl.IMUDrive;
import org.firstinspires.ftc.teamcode.WheelControl.WheelControl;

/**
 * Created by Robi on 11/13/2017.
 */

public class RobotControl {
    public static AngleUnit angleUnit = AngleUnit.RADIANS;
    public static DistanceUnit distanceUnit = DistanceUnit.CM;



    public InertiaMeasurementUnit imu;
    public static LinearOpMode opMode;
    public IMUDrive drive;
    public MotorSync parrelLift;
    public MotorSync pinions;

    public RobotControl(LinearOpMode opMode){
        this.opMode = opMode;

        imu = new InertiaMeasurementUnit(opMode.hardwareMap);

        parrelLift = parLiftmap();

        pinions =liftPinions();

        drive = new IMUDrive(imu, opMode.hardwareMap);
    }

    private MotorSync parLiftmap(){
        DcMotor motorR = opMode.hardwareMap.dcMotor.get("Right Lift");
        DcMotor motorL = opMode.hardwareMap.dcMotor.get("Left Lift");
        MotorSync lift = new MotorSync(motorR, motorL);

        lift.setDirection(true, false);//Directions are shots in the dark. Test and change
        lift.setMotorMode(DcMotor.RunMode.RUN_TO_POSITION);
        return lift;
    }

    private MotorSync liftPinions(){
        CRServo pinionL = opMode.hardwareMap.crservo.get("Left Pinion");
        CRServo pinionR = opMode.hardwareMap.crservo.get("Right Pinion");

        MotorSync pinions = new MotorSync(pinionR,pinionL);
        pinions.setDirection(true, false);
        return pinions;

    }





}
