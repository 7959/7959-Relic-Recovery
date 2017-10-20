package org.firstinspires.ftc.teamcode.UtilitiesandMic;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Animatable;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

/**
 * Created by Robi on 10/12/2017.
 */
@Autonomous(name = "COLORS")
public class Colors extends LinearOpMode {

    float COLOOOOORS[] = {0F, 0F, 0F};
    final float COLOOOOORStoreference[] = COLOOOOORS;
    int y = randstart();
    int x = randstart();
    int z = randstart();



    public void runOpMode() throws InterruptedException {

        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);
        waitForStart();
        while(opModeIsActive()){
        Color.RGBToHSV((int) (Math.random()*5*255),
                (int) (Math.random()*5*255),
                (int) ((Math.random()*5* 255)),
                COLOOOOORS);
        relativeLayout.post(new Runnable() {
            public void run() {
                relativeLayout.setBackgroundColor(Color.HSVToColor(0xff, COLOOOOORStoreference));
            }
        });
            x = scale(x);
            y = scale(y);
            z = scale(z);
            sleep(250);
    }


        relativeLayout.post(new Runnable() {
            public void run() {
                relativeLayout.setBackgroundColor(Color.TRANSPARENT);
            }
        });
        Animatable j;


    }

    int randstart(){
        return (int)Math.random() * 5;
    }
    int scale(int input){
        if(input >= 5){
            return 1;
        } else
            return input+1;
    }
}
