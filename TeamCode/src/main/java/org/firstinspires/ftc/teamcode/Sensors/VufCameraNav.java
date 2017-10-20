package org.firstinspires.ftc.teamcode.Sensors;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.configuration.Utility;

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;

/**
 * Created by Robi on 10/14/2017.
 */

public class VufCameraNav extends VufCameraBasic {
    protected OpenGLMatrix lastLocation = null;
    public VufCameraNav(HardwareMap hwmap){
        super(hwmap);
    }
    public double[] getPos(){
        return null;
    }
}
