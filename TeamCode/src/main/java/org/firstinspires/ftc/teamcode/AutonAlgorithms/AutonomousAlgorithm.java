package org.firstinspires.ftc.teamcode.AutonAlgorithms;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.Sensors.FindMark;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;

/**
 * Created by Robi on 11/6/2017.
 */

public abstract class AutonomousAlgorithm {


    //Objects to be initialized in subclasses Constructors
    RobotMain main;
    AutonTeam team;

    public abstract void run();


    protected Boolean wentTowardBox;
    protected void jewelKnock(){
     /*   main.JewelArm.open();
        boolean isRed;
        switch (team){
            case REDCORNER: isRed = true;
            case REDMIDDLE: isRed = true;
                default: isRed = false;
        }
        main.opMode.sleep(500);
        if(isRed && main.JewelSensor.isRed()) {
            main.drive.overrideDrive(team.wheelInput(-.1, 0), 0);
            wentTowardBox = false;
        } else if(!isRed && main.JewelSensor.isRed()) {
            main.drive.overrideDrive(team.wheelInput(-.1, 0), 0);
            wentTowardBox = true;
        } else if(isRed){
            main.drive.overrideDrive(team.wheelInput(.1, 0), 0);
            wentTowardBox = true;
        } else {
            main.drive.overrideDrive(team.wheelInput(.1,0), 0);
            wentTowardBox = true;
        }
        main.opMode.sleep(500);
        main.drive.overrideDrive(team.wheelInput(0,0),0);
    }


    //Drive to the box. If it is a corner, there will be a slight direction in the y
    //if it is a middle it will go straight left/right
    protected void driveToBox(){
        if(team == AutonTeam.REDCORNER || team == AutonTeam.BLUECORNOR) {


            if (wentTowardBox == null) {
                main.drive.overrideDrive(team.wheelInput(.1, .1), 0);
                main.opMode.sleep(1500);
            } else if (wentTowardBox) {
                main.drive.overrideDrive(team.wheelInput(.1, .1), 0);
                main.opMode.sleep(1000);
            } else if (!wentTowardBox) {
                main.drive.overrideDrive(team.wheelInput(.1, .1), 0);
                main.opMode.sleep(2000);
            }


        }
         else if (wentTowardBox == null) {
            main.drive.overrideDrive(team.wheelInput(.1, 0), 0);
            main.opMode.sleep(1500);
        } else if (wentTowardBox) {
            main.drive.overrideDrive(team.wheelInput(.1, 0), 0);
            main.opMode.sleep(1000);
        } else if (!wentTowardBox) {
            main.drive.overrideDrive(team.wheelInput(.1, 0), 0);
            main.opMode.sleep(2000);
        }

        main.drive.overrideDrive(team.wheelInput(0,0),0);
*/
    }






    //Makes a new instance of the FindMark Thread and starts it
    FindMark pictographFinder;
    protected void setPictographFinder(){
        pictographFinder = new FindMark(main.hwMap, main);
        pictographFinder.start();
    }




    //Places a cube in the glyph in the respective column
    protected void placecube(){
        switch (main.target){

            case LEFT:{

            }

            case RIGHT:{

            }

            case CENTER:{

            }
            default:{

            }


        }
    }



    }
