package org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff;

import org.firstinspires.ftc.teamcode.RobotControl;

/**
 * Created by Robi on 11/16/2017.
 */

public abstract class dervativeFinder extends Thread {


    
    public dervativeFinder(int deltaT){
        this.deltaT = deltaT;
    }
    
    public abstract double getData();
    private double dervative = 0;
    private double y0;
    private double y1;
    private double y2;
    private final int deltaT;

    public void init(){
        y0 = getData();
        try {
            Thread.sleep(deltaT);
        } catch (Exception e){

        }
        y1 = getData();
        try {
            Thread.sleep(deltaT);
        } catch (Exception e){

        }
        y2 = getData();
        try {
            Thread.sleep(deltaT);
        } catch (Exception e){

        }
    }
    public void run(){


        //Uses the second difference formula to estimate the derivative at x1,y1
        while(RobotControl.opMode.opModeIsActive()){
            dervative = (y0 - y2)/(2 * deltaT);
            try {
                Thread.sleep(deltaT);
            } catch (Exception e){

            }
            y0 = y1;
            y1 = y2;
            y2 = getData();

        }
    }
    public double getDervative(){
        return dervative;
    }


}
