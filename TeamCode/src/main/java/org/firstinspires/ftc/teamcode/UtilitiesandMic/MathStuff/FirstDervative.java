package org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff;

/**
 * Created by Robi on 11/23/2017.
 */

public class FirstDervative implements NumericalDervative{

    //

    private FunctionalInterface receiveData;
    @Override
    public void init(FunctionalInterface receiveData) {
        this.receiveData = receiveData;
    }

    double firstNum;
    double secondNum;


    @Override
    public double get() {
        return 0;
    }

    @Override
    public void stop() {

    }

    @Override
    public void start() {

    }
}
