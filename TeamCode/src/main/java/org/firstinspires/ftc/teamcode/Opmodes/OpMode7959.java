package org.firstinspires.ftc.teamcode.Opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Mechanisms.ChassisWedge;
import org.firstinspires.ftc.teamcode.Mechanisms.JewelArm;
import org.firstinspires.ftc.teamcode.Mechanisms.MotorSync;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.RobotUtilities;
import org.firstinspires.ftc.teamcode.WheelControl.IMUDrive;

/**
 * Created by Robi on 12/12/2017.
 */

public abstract class OpMode7959 extends LinearOpMode{
    protected InertiaMeasurementUnit imu;
    protected MotorSync intake;
    protected JewelArm jewelArm;
    protected IMUDrive drive;
    protected ChassisWedge chassisWedge;
    public static final DistanceUnit distanceUnit = DistanceUnit.CM;
    public static final AngleUnit angleUnit = AngleUnit.RADIANS;

    protected void setUp(LinearOpMode opMode) {
        RobotUtilities.setOpMode(opMode);
        imu = new InertiaMeasurementUnit(hardwareMap);
        intake = new MotorSync(hardwareMap.dcMotor.get("Intake Right"), hardwareMap.dcMotor.get("Intake Left"));
        jewelArm = new JewelArm(hardwareMap.servo.get("Sweep Servo"), hardwareMap.servo.get("Jewel Servo"), hardwareMap.colorSensor.get("Jewel Sensor"));
        drive = new IMUDrive(imu, hardwareMap.dcMotor.get("Back Left"), hardwareMap.dcMotor.get("Back Right"), hardwareMap.dcMotor.get("Front Left"), hardwareMap.dcMotor.get("Front Right"));
        chassisWedge = new ChassisWedge(hardwareMap.servo.get("Wedge Servo"), hardwareMap.colorSensor.get("Wedge Sensor"), hardwareMap.get(DistanceSensor.class, "Wedge Sensor"));
        jewelArm.init();
        telemetry.setAutoClear(false);
    }


}
