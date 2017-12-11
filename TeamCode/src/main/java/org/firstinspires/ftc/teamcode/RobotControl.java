package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Hardware;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Mechanisms.Claw;
import org.firstinspires.ftc.teamcode.Mechanisms.JewelArm;
import org.firstinspires.ftc.teamcode.Mechanisms.LinearExtension;
import org.firstinspires.ftc.teamcode.Mechanisms.MotorSync;
import org.firstinspires.ftc.teamcode.Mechanisms.ParLift;
import org.firstinspires.ftc.teamcode.Mechanisms.Rotator;
import org.firstinspires.ftc.teamcode.Sensors.ColorDistanceSensor;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.Sensors.Sensors;
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
    //public Claw botGylph;
    public Claw relicClaw;
    public ParLift parLift;
    public Servo relicRotator;
    public ModernRoboticsI2cRangeSensor rangeSensor;
    public LinearExtension linearExtension;
    public JewelArm jewelArm;
    public ColorDistanceSensor JewelSensor;
    public Rotator rotator;
    public RobotControl(LinearOpMode opMode){

        //Initialized all the mechanisms classes
        this.opMode = opMode;
        HardwareMap hardwareMap = opMode.hardwareMap;


        jewelArm = new JewelArm(hardwareMap.servo.get("Sweep Servo"), hardwareMap.servo.get("Jewel Arm"));

        rotator = new Rotator(hardwareMap.dcMotor.get("Glyph Rotator"));

        JewelSensor = new ColorDistanceSensor(hardwareMap, "Jewel Sensor");


        imu = new InertiaMeasurementUnit(hardwareMap);

        //topGylph = new Claw(hardwareMap.servo.get("Top Claw Left"), hardwareMap.servo.get("Top Claw Right"));
        //opMode.telemetry.addData("5","");
        //opMode.telemetry.update();

        topGylph = new Claw(hardwareMap.servo.get("Top Claw Left"), hardwareMap.servo.get("Top Claw Right"));

        topGylph.setClosePos(.5,.5);
        topGylph.setOpenPos(0, .9);

        //botGylph = new Claw(hardwareMap.servo.get("Bottom Claw Left"), hardwareMap.servo.get("Bottom Claw Right"));

        //botGylph.setClosePos(.4,.6);
        //botGylph.setOpenPos(0,1);

        relicClaw = new Claw(hardwareMap.servo.get("Relic Claw Left"), hardwareMap.servo.get("Relic Claw Right"));

        //glyphRotator = hardwareMap.servo.get("Claw Rotator");

        //relicRotator = hardwareMap.servo.get("Relic Rotator");

        linearExtension = new LinearExtension(hardwareMap.dcMotor.get("Pulley Motor"), hardwareMap.dcMotor.get("Retract Motor"));



        parLift = new ParLift(hardwareMap.dcMotor.get("Parallelogram Lift"));

       // pinions = liftPinions();

        drive = new IMUDrive(imu, hardwareMap.dcMotor.get("Back Left"), hardwareMap.dcMotor.get("Back Right"),hardwareMap.dcMotor.get("Front Left"), hardwareMap.dcMotor.get("Front Right"));

    }


    /*private MotorSync liftPinions(){
        CRServo pinionL = hardwareMap.crservo.get("Left Pinion");
        CRServo pinionR = hardwareMap.crservo.get("Right Pinion");

        MotorSync pinions = new MotorSync(pinionR,pinionL);
        pinions.setDirection(true, false);
        return pinions;
    }
*/




}
