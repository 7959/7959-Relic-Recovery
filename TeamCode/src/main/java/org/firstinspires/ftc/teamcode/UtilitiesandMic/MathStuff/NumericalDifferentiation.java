package org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff;

import org.firstinspires.ftc.teamcode.RobotControl;

/**
 * Created by Robi on 12/6/2017.
 */

public abstract class NumericalDifferentiation extends Thread{


    protected NumericalDifferentiation(int deltaT, int functionValueAmount) {
        this.deltaT = deltaT;
        this.functionValueAmount = functionValueAmount;
    }

    protected abstract double getData();

    protected abstract double calculateDerivative();
    private double dervative = 0;

    protected double y[];
    protected final int deltaT;

    protected final int functionValueAmount;


    private void init(){
        y = new double[functionValueAmount];
        for(int i = 0;i < y.length;i++){
            y[i] = getData();
            try {
                Thread.sleep(deltaT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void run(){
        while(RobotControl.opMode.opModeIsActive()){
            init();
            dervative = calculateDerivative();
            try {
                Thread.sleep(deltaT);
            } catch (Exception e){

            }

            for(int i = 0;i < y.length;i++){
                if(i != y.length-1){
                    y[i] = y[i+1];
                } else y[i] = getData();
            }

        }
    }

    public double getDervative(){
        return dervative;
    }

}
