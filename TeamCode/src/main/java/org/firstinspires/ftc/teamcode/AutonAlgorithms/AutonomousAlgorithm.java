package org.firstinspires.ftc.teamcode.AutonAlgorithms;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff.SecondDervativeFinder;

/**
 * Created by Robi on 11/6/2017.
 */

public abstract class AutonomousAlgorithm {

    final private RobotControl bot;
    final AutonTeam team;
    SecondDervativeFinder dervativeFinder;



    //Method to be implemented in Corresponding Opmodes
    public abstract void run();

    public AutonomousAlgorithm(final RobotControl bot, AutonTeam team) {
        this.bot = bot;
        this.team = team;

        //Sets up the numerical differentiation algorithm
        dervativeFinder = new SecondDervativeFinder(50){
            @Override
            public double getData() {
                return bot.rangeSensor.getDistance(DistanceUnit.CM);
            }
        };
        dervativeFinder.init();

    }


    //Tells the JewelArm class the team it is on, and the sensor to use.
    protected void jewelKnock() {
        bot.jewelArm.setTeam(team);
        bot.jewelArm.sweep(bot.JewelSensor);
    }

    protected void driveTillBoxSide(double drive[], double angle){
        while(bot.opMode.opModeIsActive() && dervativeFinder.getDervative() < 5){
            bot.drive.movebyCart(drive, angle);
        }
    }

    protected void driveTillBoxSide(double x, double y, double angle){
        while(bot.opMode.opModeIsActive() && dervativeFinder.getDervative() < 5){
            bot.drive.movebyCart(x,y, angle);
        }
    }

    protected void driveToBox(){
        switch (team){
            case BLUEMIDDLE:
            case BLUECORNOR:
            case REDMIDDLE:
            case REDCORNER:
        }
    }


    protected void placeCube(){

    }
}