package org.firstinspires.ftc.teamcode.Mechanisms.VerticalMovement;

/**
 * Created by Robi on 10/14/2017.
 */

public interface PulleyInterface {

    /**
     * Put in constants later
     */
    double PulleyRadius = 1;
    int maxPos = 0;
    double encoderradiansratio = 1;
    void setPos(int pos);
    double getPos();
}
