package org.firstinspires.ftc.teamcode.UtilitiesandMic;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.qualcomm.hardware.bosch.BNO055IMU;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.RobotMain;

/**
 * Created by Robi on 10/20/2017.
 */

public class AccelerationIntegrator implements BNO055IMU.AccelerationIntegrator {
    
    private Acceleration Accel;
    private Velocity Vel;
    private Position Pos;

    private final DistanceUnit distanceUnit = RobotMain.distanceUnit;


    private Acceleration prevAcel;
    private Velocity prevVel;
    private BNO055IMU.Parameters parameters;

    @Override
    public void initialize(@NonNull BNO055IMU.Parameters parameters, @Nullable Position initialPosition, @Nullable Velocity initialVelocity) {
        this.parameters = parameters;
        this.Pos = initialPosition;
        this.Vel = initialVelocity;

        Accel = new Acceleration(distanceUnit,0,0,0,0);
        prevVel = new Velocity(distanceUnit,0,0,0,0);
        prevAcel = new Acceleration(distanceUnit,0,0,0,0);
    }

    @Override
    public Acceleration getAcceleration() {
        return this.Accel == null ? new Acceleration(distanceUnit,0,0,0,0) : Accel;
    }

    @Override
    public Velocity getVelocity() {
        return this.Accel == null ? new Velocity(distanceUnit,0,0,0,0) : Vel;
    }


    @Override
    public Position getPosition() {
        return this.Pos == null ? new Position(distanceUnit,0,0,0,0) : Pos;
    }

    @Override
    public void update(Acceleration linearAcceleration){
        Accel = linearAcceleration;
        if(Accel.acquisitionTime == 0) return;
        double t = Accel.acquisitionTime - prevAcel.acquisitionTime;

        Vel.xVeloc += (Accel.xAccel + prevAcel.xAccel) * .5 * t;
        Vel.yVeloc += (Accel.yAccel + prevAcel.yAccel) * .5 * t;
        Vel.zVeloc += (Accel.zAccel + prevAcel.zAccel) * .5 * t;

        Pos.x += (Vel.xVeloc + Vel.xVeloc) * .5 * t;
        Pos.y += (Vel.yVeloc + Vel.yVeloc) * .5 * t;
        Pos.z += (Vel.zVeloc + Vel.zVeloc) * .5 * t;

        prevAcel = Accel;
        prevVel = Vel;
    }
    public void reset(){
        Pos = new Position(distanceUnit,0,0,0,0);
        Vel = new Velocity(distanceUnit,0,0,0,0);
    }
}
