package org.firstinspires.ftc.teamcode.UtilitiesandMic;

import org.firstinspires.ftc.teamcode.RobotControl;

import static com.qualcomm.hardware.bosch.BNO055IMU.AngleUnit.DEGREES;

/**
 * Created by Robi on 11/1/2017.
 */

public enum AutonTeam {



    REDCORNER, BLUECORNOR, REDMIDDLE, BLUEMIDDLE;


    //Adjusts motor input  for different team orientations
    public double[] wheelInput(double x, double y){
        double power[] = new double[2];
        switch (this){
            case REDCORNER: power[0] = x;
            case BLUECORNOR: power[0] = x * -1;
            case BLUEMIDDLE: power[0] = x * -1;
            case REDMIDDLE: power[0] = x;
        }
        power[1] = y;
        return power;
    }



    //The angle relative for the Glyph Boxes
    public double boxAngle(){
        switch (this){
            case BLUEMIDDLE: switch (RobotControl.angleUnit){
                case DEGREES: return 180;
                case RADIANS: return Math.PI;
            }
            case REDMIDDLE: switch (RobotControl.angleUnit){
                case DEGREES: return 180;
                case RADIANS: return 180;
            }
            case BLUECORNOR: switch (RobotControl.angleUnit){
                case DEGREES: return 90;
                case RADIANS: return Math.PI/ 2;
            }
            case REDCORNER: switch (RobotControl.angleUnit){
                case DEGREES: return -90;
                case RADIANS: return -Math.PI /2;
            }


            default: return 0;
        }
    }

    public boolean isRed(){
        switch (this){
            case REDCORNER:
            case REDMIDDLE:{
                return true;
            }

            case BLUECORNOR:
            case BLUEMIDDLE:{
                return false;
            }
            default: return false;
        }
    }


    @Override
    public String toString() {
        switch (this){
            case REDCORNER: return "Red Corner";
            case BLUECORNOR: return "Blue Corner";
            case REDMIDDLE: return "Red Middle";
            case BLUEMIDDLE: return "Blue Middle";
            default: return "Team Not Chosen";
        }
    }

}
