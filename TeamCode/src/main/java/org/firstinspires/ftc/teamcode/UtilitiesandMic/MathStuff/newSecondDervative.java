package org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff;

/**
 * Created by Robi on 12/6/2017.
 */

public abstract class newSecondDervative extends NumericalDifferentiation {
    protected newSecondDervative(int deltaT) {
        super(deltaT, 5);
    }

    @Override
    protected double calculateDerivative() {
        return (y[1] - 2*y[2] + y[0])/(deltaT * deltaT);
    }
}
