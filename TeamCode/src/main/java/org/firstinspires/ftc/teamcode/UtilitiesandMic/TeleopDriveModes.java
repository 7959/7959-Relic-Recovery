package org.firstinspires.ftc.teamcode.UtilitiesandMic;

/**
 * Created by Robi on 11/13/2017.
 */

public enum TeleopDriveModes {
    SLOW(.33,.33), NORMAL(.5, .5), FAST(.9, .9);
    final double powerRatio;
    final double turnRatio;

    TeleopDriveModes(double powerRatio, double turnRatio){
        this.powerRatio = powerRatio;
        this.turnRatio = turnRatio;
    }

    public double[] powerInput(double x, double y){
        double input[] = {x * powerRatio, y * powerRatio};
        return input;
    }
    public double turnInput(double turn){
        return turnRatio * turn;
    }



}
