package org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff;

import org.firstinspires.ftc.teamcode.RobotControl;

/**
 * Created by Robi on 11/16/2017.
 */

public class dervativeFinder extends Thread {

    public interface dataInput{//Maybe switch to float, check how hard on CPU
        double getData();
        double DeltaT();
    }

    dataInput input;
    public dervativeFinder(dataInput input){
        this.input = input;
    }
    private double dervative = 0;
    private double prevValue = 0;
    private double currentValue = 0;
    private double deltaT = 0;
    public void run(){

        while(RobotControl.opMode.opModeIsActive()){
            
        }
    }
    public double getDervative(){
        return dervative;
    }


}
