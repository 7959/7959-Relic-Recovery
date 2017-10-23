package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.Mechanisms.Claws.SoftwareServoController;
import org.firstinspires.ftc.teamcode.Mechanisms.HorizontalMovement;
import org.firstinspires.ftc.teamcode.Mechanisms.ParrellagramLift;
import org.firstinspires.ftc.teamcode.Sensors.ColorDistanceSensor;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.PosEstimater;
import org.firstinspires.ftc.teamcode.WheelControl.BasicWheels;
import org.firstinspires.ftc.teamcode.WheelControl.Wheels;
import org.firstinspires.ftc.teamcode.WheelControl.WheelsImu;


/**
 * Created by Robi on 10/20/2017.
 */

public class RobotMain {
    public final static DistanceUnit distanceUnit = DistanceUnit.METER;
    public final static BNO055IMU.AccelUnit accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
    public final static AngleUnit angleUnit = AngleUnit.RADIANS;
    public InertiaMeasurementUnit imu;
    public static HardwareMap hwMap;
    Telemetry tele;
    public Wheels drive;
    public HorizontalMovement chassisPinion;
    public ParrellagramLift lift;
    public ColorDistanceSensor jewelArm;
    public SoftwareServoController Glyphclaw;



    LinearOpMode opMode;
    public Thread findPos;

    public static Orientation ori;
    public static Position pos;
    public static Velocity vel;
    public static Acceleration accel;

    public RobotMain(LinearOpMode opMode, HardwareMap hwMap, Telemetry tele){
        //May implent starting position later, but for now it all relative
        ori = new Orientation();
        //pos = new Position();
        vel = new Velocity();
        accel = new Acceleration();






        this.opMode = opMode;
        this.hwMap = hwMap;
        this.tele = tele;



        imu = new InertiaMeasurementUnit(this.hwMap);

        //jewelArm = new ColorDistanceSensor(this.hwMap, "Color Distance");

        //lift = new ParrellagramLift(this.hwMap);



        //chassisPinion = new HorizontalMovement(this.hwMap,"Right Pinion","Left Pinion", DcMotorSimple.Direction.FORWARD, DcMotorSimple.Direction.FORWARD);

        //drive = new WheelsImu(imu, this.hwMap);

        //Glyphclaw = new SoftwareServoController(this.hwMap, "Claw Left", "Claw Right");
        //Glyphclaw.setOpenpos(0,0);
        //Glyphclaw.setClosePos(1,1);



        //findPos = new Thread(new PosEstimater(drive, imu, this.opMode));

    }
    public void run(){
        imu.startIntegration(0,0,0);
        findPos.start();
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
