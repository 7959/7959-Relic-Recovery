package org.firstinspires.ftc.teamcode.Sensors;

import android.view.View;

import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * Created by Robi on 10/12/2017.
 */

public class OptDistance {
    DistanceSensor opt;
    public OptDistance(HardwareMap hwmap){
        opt = hwmap.get(DistanceSensor.class, ColorSens.name);
    }
    public double getDistance(){
        return opt.getDistance(DistanceUnit.MM);
    }
}
