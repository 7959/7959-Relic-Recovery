package org.firstinspires.ftc.teamcode.Sensors;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 10/12/2017.
 */

public class ColorSens {
    final int Threshold = 3;
    public ColorSensor sensor;
    HardwareMap hmap;

    public static final String name = "ColorDistance";


    /**
     * REMINDER:
     * Name must match optical distance sensor.
     *
     */
    public ColorSens(HardwareMap hwmap){
        sensor = hwmap.colorSensor.get(name);
    }


    public boolean isRed(){
        if(sensor.red() >= Threshold)
            return true;
        else return false;
    }
    public boolean isBlue(){
        if(sensor.blue() >= Threshold)
            return true;
        else return false;
    }

}
