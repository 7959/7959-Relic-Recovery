package org.firstinspires.ftc.teamcode.Sensors;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;

/**
 * Created by Robi on 10/14/2017.
 */

public class VufCameraAdv extends VufCameraBasic {
    protected OpenGLMatrix lastLocation = null;
    public VufCameraAdv(HardwareMap hwmap){
        super(hwmap);
    }
    public double[] getPos(){

    }
}
