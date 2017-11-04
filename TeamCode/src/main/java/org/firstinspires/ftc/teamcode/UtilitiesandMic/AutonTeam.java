package org.firstinspires.ftc.teamcode.UtilitiesandMic;

/**
 * Created by Robi on 11/1/2017.
 */

public enum AutonTeam {
    REDCORNER, BLUECORNOR, REDMIDDLE, BLUEMIDDLE;


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
