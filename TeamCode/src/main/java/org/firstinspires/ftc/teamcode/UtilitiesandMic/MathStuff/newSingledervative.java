package org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff;

/**
 * Created by Robi on 12/6/2017.
 */

public abstract class newSingledervative extends NumericalDifferentiation {

    protected newSingledervative(int deltaT) {
        super(deltaT, 3);
    }

    @Override
    protected double calculateDerivative() {
        return (y[0] - y[2])/(2 * deltaT);
    }
}
