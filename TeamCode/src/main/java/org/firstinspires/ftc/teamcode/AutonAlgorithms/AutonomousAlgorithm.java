package org.firstinspires.ftc.teamcode.AutonAlgorithms;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff.NumericalDifferentiation;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff.SecondDervativeFinder;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff.newSecondDervative;

/**
 * Created by Robi on 11/6/2017.
 */

public abstract class AutonomousAlgorithm {

    final private RobotControl bot;
    final private LinearOpMode opMode;
    final AutonTeam team;
    NumericalDifferentiation dervativeFinder;



    //Method to be implemented in Corresponding Opmodes
    public abstract void run();

    public AutonomousAlgorithm(RobotControl bot, AutonTeam team) {
        this.bot = bot;
        this.team = team;
        this.opMode = bot.opMode;
    }

    //Tells the JewelArm class the team it is on, and the sensor to use.
    protected void jewelKnock() {
        bot.jewelArm.setTeam(team);
        bot.jewelArm.sweep(bot.JewelSensor, team);
    }


    protected void park(){
        switch (team){
            case REDMIDDLE:{
                bot.drive.basicMove(0,-.3, 0);
                bot.opMode.sleep(2000);
                break;
            }
            case REDCORNER:{
                bot.drive.basicMove(.1,-.3,0);
                bot.opMode.sleep(2500);
                break;
            }
            case BLUEMIDDLE:{
                bot.drive.basicMove(0,.3,0);
                bot.opMode.sleep(2000);
                break;
            }
            case BLUECORNOR:{
                bot.drive.basicMove(.1,.3,0);
                bot.opMode.sleep(2500);
                break;
            }
            default:{
                return;
            }
        }
        bot.drive.powerOff();

    }
    protected void driveTillBoxSide(double drive[], double angle){
        while(opMode.opModeIsActive() && dervativeFinder.getDervative() < 5){
            bot.drive.movebyCart(drive, angle);
        }
        bot.drive.powerOff();
    }

    protected void driveTillBoxSide(double x, double y, double angle){
        while(opMode.opModeIsActive() && dervativeFinder.getDervative() < 5){
            bot.drive.movebyCart(x,y, angle);
        }
        bot.drive.powerOff();

    }

    protected void driveToBox(){
        switch (team){
            case BLUEMIDDLE:{
                for(int i = 0; i < 3 && opMode.opModeIsActive();i++)
                driveTillBoxSide(team.wheelInput(0,.2), 0);


                break;
            }
            case BLUECORNOR:{


                break;
            }
            case REDMIDDLE:{
                for(int i = 0; i < 3 && opMode.opModeIsActive();i++)
                    driveTillBoxSide(team.wheelInput(0,.2), 0);

                break;
            }
            case REDCORNER:{


                break;
            }
        }
        bot.drive.powerOff();
    }


    protected void placeCube(){

    }
}