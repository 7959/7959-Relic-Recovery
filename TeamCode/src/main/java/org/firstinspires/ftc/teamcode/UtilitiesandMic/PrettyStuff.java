package org.firstinspires.ftc.teamcode.UtilitiesandMic;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.RobotControl;

/**
 * Created by Robi on 11/14/2017.
 */

public class PrettyStuff extends Thread {

    final View relativeLayout;

    float HSVcolor[] = {0F, .5F, .5F};

    final float[] HSVreference = {0, 0, 0};

    final int timeInteval;

    final float rateOfChange;

    public PrettyStuff(HardwareMap hardwareMap, int timeInteval, float rateOfChange){
        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        this.relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);
        this.timeInteval = timeInteval;
        this.rateOfChange = rateOfChange;
    }

    private float changeHue(float toChange, float rate){
        if(toChange + rate > 360) toChange = 0;
        toChange += rate;
        return toChange;
    }

    @Override
    public void run(){

        while(RobotControl.opMode.opModeIsActive()){

            HSVcolor[0] = changeHue(HSVcolor[0], rateOfChange);



            relativeLayout.post(new Runnable() {
                public void run() {
                    relativeLayout.setBackgroundColor(Color.HSVToColor(HSVcolor));
                }
            });
            try {
                Thread.sleep(timeInteval);
            } catch (Exception e){
            }


        }
    }
}
