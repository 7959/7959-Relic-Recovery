package org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff;

import org.firstinspires.ftc.teamcode.RobotControl;

/**
 * Created by Robi on 11/16/2017.
 */

public abstract class dervativeFinder extends Thread {

<<<<<<< HEAD
    public interface dataInput{//Maybe switch to float, check how hard on CPU
        double getData();
    }

    dataInput input;
    public dervativeFinder(int deltaT,dataInput input){
        this.input = input;
=======

    
    public dervativeFinder(int deltaT){
>>>>>>> 108dbbb71754384e8e3a3ade07e197248e50f1ca
        this.deltaT = deltaT;
    }
    
    public abstract double getData();
    private double dervative = 0;
    private double y0;
    private double y1;
    private double y2;
    private final int deltaT;

    public void init(){
<<<<<<< HEAD
        y0 = input.getData();
=======
        y0 = getData();
>>>>>>> 108dbbb71754384e8e3a3ade07e197248e50f1ca
        try {
            Thread.sleep(deltaT);
        } catch (Exception e){

        }
<<<<<<< HEAD
        y1 = input.getData();
=======
        y1 = getData();
>>>>>>> 108dbbb71754384e8e3a3ade07e197248e50f1ca
        try {
            Thread.sleep(deltaT);
        } catch (Exception e){

        }
<<<<<<< HEAD
        y2 = input.getData();
=======
        y2 = getData();
>>>>>>> 108dbbb71754384e8e3a3ade07e197248e50f1ca
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
<<<<<<< HEAD
            y2 = input.getData();
=======
            y2 = getData();
>>>>>>> 108dbbb71754384e8e3a3ade07e197248e50f1ca

        }
    }
    public double getDervative(){
        return dervative;
    }


}
