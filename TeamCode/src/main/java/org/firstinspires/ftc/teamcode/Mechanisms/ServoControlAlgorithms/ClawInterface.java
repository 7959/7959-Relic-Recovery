package org.firstinspires.ftc.teamcode.Mechanisms.Claws;

import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 10/14/2017.
 */
@Deprecated
public interface ClawInterface {
    void close();

    void open();

    double getPos();
}
