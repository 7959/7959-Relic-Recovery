package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.Mechanisms.ServoControlAlgorithms.BasicClaw;
import org.firstinspires.ftc.teamcode.Mechanisms.ServoControlAlgorithms.SingleServoControl;
import org.firstinspires.ftc.teamcode.Mechanisms.VerticalMovement.BasicArm;
import org.firstinspires.ftc.teamcode.Mechanisms.VerticalMovement.ParrellagramLift;
import org.firstinspires.ftc.teamcode.Sensors.ColorDistanceSensor;
import org.firstinspires.ftc.teamcode.Sensors.DistanceNavigation;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.PosEstimater;
import org.firstinspires.ftc.teamcode.WheelControl.Wheels;



/**
 * Created by Robi on 10/20/2017.
 *
 * The Main class of the Robot.
 * All sensors, motors, and servos have connections to this class.
 * There are many static objects and variables so unit can easily be changed or to fix constants
 */

public class RobotMain {
    public final static DistanceUnit distanceUnit = DistanceUnit.METER;
    public final static BNO055IMU.AccelUnit accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
    public final static AngleUnit angleUnit = AngleUnit.RADIANS;
    public static RelicRecoveryVuMark target;
    public static AutonTeam team;


    public final static double turnsensitivity = Math.PI/64;


    public InertiaMeasurementUnit imu;
    public static HardwareMap hwMap;
    public static Telemetry tele;

    //initialize drive outside of this class
    public Wheels drive;
    public HorizontalMovement chassisPinion;
    public ParrellagramLift lift;
    public ColorDistanceSensor JewelSensor;
    public SingleServoControl JewelArm;
    public DistanceNavigation NavSensors;
    public BasicClaw relicClaw;
    public BasicArm RelicArm;


    public static LinearOpMode opMode;
    public PosEstimater posEstimater;

    public static Orientation ori;
    public static Position pos;
    public static Velocity vel;
    public static Acceleration accel;




    //Constructor for TeleOp
    public RobotMain(LinearOpMode opMode, HardwareMap hwMap, Telemetry tele){
        //May implent starting position later, but for now it all relative
        //ori = new Orientation();
        //pos = new Position();
        //vel = new Velocity();
        //accel = new Acceleration();


        this.opMode = opMode;
        this.hwMap = hwMap;
        this.tele = tele;
        RelicArm = new BasicArm(this.hwMap, "Relic Arm");

        JewelArm = new SingleServoControl(this.hwMap, "Jewel Arm");
        JewelArm.setClosePos(.65);
        JewelArm.setOpenPos(.1);

        relicClaw = new BasicClaw(this.hwMap, "Relic Claw Far", "Relic Claw Near");
        relicClaw.setOpenPos(0,1);
        relicClaw.setClosePos(1,0);

        imu = new InertiaMeasurementUnit(this.hwMap);

        lift = new ParrellagramLift(this.hwMap);
        lift.Glyphclaw.setClosePos(1,0);
        lift.Glyphclaw.setOpenPos(0,1);




        chassisPinion = new HorizontalMovement(this.hwMap,"Right Pinion","Left Pinion", DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);

        //findPos = new Thread(new PosEstimater(drive, imu, this.opMode));

    }

    //Constructor for Autonomous
    public RobotMain(LinearOpMode opMode, HardwareMap hwMap, Telemetry tele, AutonTeam team){
        this.team = team;
        this.opMode = opMode;
        this.hwMap = hwMap;
        this.tele = tele;

        JewelArm = new SingleServoControl(this.hwMap, "Jewel Arm");
        JewelArm.setClosePos(.65);
        JewelArm.setOpenPos(0);// could also be 1, test later
        JewelArm.close();

        relicClaw = new BasicClaw(this.hwMap, "Relic Claw Far", "Relic Claw Near");
        relicClaw.setOpenPos(0,1);
        relicClaw.setClosePos(1,0);

        imu = new InertiaMeasurementUnit(this.hwMap);

        JewelSensor = new ColorDistanceSensor(this.hwMap, "Color Distance");

        lift = new ParrellagramLift(this.hwMap);
        lift.Glyphclaw.setClosePos(1,0);
        lift.Glyphclaw.setOpenPos(0,1);

        NavSensors = new DistanceNavigation(this.hwMap, "Line Sensor", "Wall Sensor");



        chassisPinion = new HorizontalMovement(this.hwMap,"Right Pinion","Left Pinion", DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);
    }




    public void run(){
        imu. startIntegration(0,0,0);
        posEstimater.start();
    }

    public void SetTele(){
        tele.addLine()
                .addData("heading", new Func<String>() {
                    @Override public String value() {
                        return String.format(ori.firstAngle + ori.angleUnit.toString());
                    }
                })
                .addData("roll", new Func<String>() {
                    @Override public String value() {
                        return String.format(ori.secondAngle + ori.angleUnit.toString());
                    }
                })
                .addData("pitch", new Func<String>() {
                    @Override public String value() {
                        return String.format(ori.thirdAngle + ori.angleUnit.toString());
                    }
                });

    }


}
