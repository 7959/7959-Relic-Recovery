package org.firstinspires.ftc.teamcode.UtilitiesandMic;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Stack;
import java.util.concurrent.Callable;

/**
 * Created by Robi on 10/15/2017.
 */

public class TelemetryLogging {
    Telemetry tele;
    Acceleration acel;
    Velocity vel;
    Position pos;





    public InertiaMeasurementUnit imu;
    public TelemetryLogging(Telemetry t, InertiaMeasurementUnit imun){
        tele = t;


    }
    public void addline(String caption , TelemetryMethod info){
        tele.addLine(caption+ String.format(": %b", info.create()));
    }







    public void update(){

    }


    private <T> String convertToString(T info){
        return null;
    }


}
