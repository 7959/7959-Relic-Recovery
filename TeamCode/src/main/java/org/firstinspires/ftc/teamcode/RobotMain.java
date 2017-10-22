package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.TelemetryLogging;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.TelemetryMethod;


/**
 * Created by Robi on 10/20/2017.
 */

public class RobotMain {
    public final static DistanceUnit distanceUnit = DistanceUnit.METER;
    public final static BNO055IMU.AccelUnit accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
    public final static AngleUnit angleUnit = AngleUnit.RADIANS;
    InertiaMeasurementUnit imu;
    //TelemetryLogging telemetry;
    HardwareMap hwMap;
    Telemetry tele;
    
    Orientation ori;
    Position pos;
    Velocity vel;
    Acceleration accel;

    public RobotMain(HardwareMap hwMap, Telemetry tele){
        this.hwMap = hwMap;
        this.tele = tele;
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
