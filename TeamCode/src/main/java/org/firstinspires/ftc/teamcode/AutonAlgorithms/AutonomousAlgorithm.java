package org.firstinspires.ftc.teamcode.AutonAlgorithms;

import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 11/6/2017.
 */

public abstract class AutonomousAlgorithm {

    final private RobotControl bot;
    final AutonTeam team;

    public AutonomousAlgorithm(RobotControl bot, AutonTeam team) {

        this.bot = bot;
        this.team = team;


    }

    public abstract void run();

    protected void jewelKnock() {
        if(team.isRed()){

        }
    }

    protected void driveToBox(){

    }
    protected void placeCube(){

    }
}