package org.firstinspires.ftc.teamcode.UtilitiesandMic;

import org.firstinspires.ftc.teamcode.Opmodes.OpMode7959;

/**
 * Created by Robi on 11/1/2017.
 */

public enum AutonTeam {



    REDCORNER(1, 1), BLUECORNOR(1, 1), REDMIDDLE(1, 1), BLUEMIDDLE(1, 1);// Find sign changes after tests
    final int xMultiple;
    final int yMultiple;


    AutonTeam(int xMultiple, int yMultiple) {
        this.xMultiple = xMultiple;
        this.yMultiple = yMultiple;
    }

    //Adjusts motor input  for different team orientations
    public double[] wheelInput(double x, double y){
        double power[] = {
                x * xMultiple, y * yMultiple
        };

        return power;
    }
    final double boxAngle = boxAngle();

    //The angle relative for the Glyph Boxes
    private double boxAngle(){
        switch (this){
            case BLUEMIDDLE: switch (OpMode7959.angleUnit){
                case DEGREES: return 90;
                case RADIANS: return Math.PI/2;
            }
            case REDMIDDLE: switch (OpMode7959.angleUnit){
                case DEGREES: return -90;
                case RADIANS: return -Math.PI/2;
            }
            case BLUECORNOR: switch (OpMode7959.angleUnit){
                case DEGREES: return 0;
                case RADIANS: return 0;
            }
            case REDCORNER: switch (OpMode7959.angleUnit){
                case DEGREES: return 180;
                case RADIANS: return Math.PI;
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
