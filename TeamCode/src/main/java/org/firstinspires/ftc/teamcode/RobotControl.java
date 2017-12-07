package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Mechanisms.Claw;
import org.firstinspires.ftc.teamcode.Mechanisms.JewelArm;
import org.firstinspires.ftc.teamcode.Mechanisms.LinearExtension;
import org.firstinspires.ftc.teamcode.Mechanisms.MotorSync;
import org.firstinspires.ftc.teamcode.Mechanisms.ParLift;
import org.firstinspires.ftc.teamcode.Sensors.ColorDistanceSensor;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.WheelControl.IMUDrive;

/**
 * Created by Robi on 11/13/2017.
 */

public class RobotControl {
    public static AngleUnit angleUnit = AngleUnit.RADIANS;
    public static DistanceUnit distanceUnit = DistanceUnit.CM;



    public InertiaMeasurementUnit imu;
    public static LinearOpMode opMode;
    public IMUDrive drive;
    public Claw topGylph;
    public Claw botGylph;
    public Claw relicClaw;
    public ParLift parLift;
    public MotorSync pinions;
    public Servo glyphRotator;
    public Servo relicRotator;
    public ModernRoboticsI2cRangeSensor rangeSensor;
    public LinearExtension linearExtension;
    public JewelArm jewelArm;
    public ColorDistanceSensor JewelSensor;
    public RobotControl(LinearOpMode opMode){

        //Initialized all the mechanisms classes
        this.opMode = opMode;

        rangeSensor = opMode.hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "Range Sensor");

        jewelArm = new JewelArm(opMode.hardwareMap.crservo.get("Sweep Servo"), opMode.hardwareMap.servo.get("Jewel Arm"), opMode);

        imu = new InertiaMeasurementUnit(opMode.hardwareMap);

        topGylph = new Claw(opMode.hardwareMap.servo.get("Top Claw Left"), opMode.hardwareMap.servo.get("Top Claw Right"));

        botGylph = new Claw(opMode.hardwareMap.servo.get("Bottom Claw Left"), opMode.hardwareMap.servo.get("Bottom Claw Right"));

        relicClaw = new Claw(opMode.hardwareMap.servo.get("Relic Claw Left"), opMode.hardwareMap.servo.get("Relic Claw Right"));

        glyphRotator = opMode.hardwareMap.servo.get("Claw Rotator");

        relicRotator = opMode.hardwareMap.servo.get("Relic Rotator");

        linearExtension = new LinearExtension(opMode.hardwareMap);


        parLift = new ParLift(opMode.hardwareMap, DcMotor.RunMode.RUN_USING_ENCODER);

        pinions = liftPinions();

        drive = new IMUDrive(imu, opMode.hardwareMap);

    }


    private MotorSync liftPinions(){
        CRServo pinionL = opMode.hardwareMap.crservo.get("Left Pinion");
        CRServo pinionR = opMode.hardwareMap.crservo.get("Right Pinion");

        MotorSync pinions = new MotorSync(pinionR,pinionL);
        pinions.setDirection(true, false);
        return pinions;
    }





}
