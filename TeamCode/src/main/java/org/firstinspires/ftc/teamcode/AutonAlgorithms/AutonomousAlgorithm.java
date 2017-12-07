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

    public AutonomousAlgorithm(final RobotControl bot, AutonTeam team) {
        this.bot = bot;
        this.team = team;
        dervativeFinder = new SecondDervativeFinder(50){

            @Override
            public double getData() {
                return bot.rangeSensor.getDistance(DistanceUnit.CM);
            }
        };
        dervativeFinder.init();

    }

    public abstract void run();

    protected void jewelKnock() {

        if(team.isRed()){

        }

    }

    protected void driveToBox(){
        while(bot.opMode.opModeIsActive() && dervativeFinder.getDervative() < 5){
        }
    }
    protected void placeCube(){

    }
}