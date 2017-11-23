package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 11/20/2017.
 */

public class ServoSync {
    //This class Synchronizes servos to move together

    private Servo[] servos;
    private double[][] positions;
    public ServoSync(HardwareMap hardwareMap, Servo... servos){
        this.servos = servos;
        positions = new double[servos.length][];
    }


    public void savePositions(int ServoIndex, double[] positions){
        this.positions[ServoIndex] = positions;
    }

    public void gotoPos(int index){
        //Cycles through the servos, setting the positions
        for(int i = 0; i < servos.length;i++){
            servos[i].setPosition(positions[i][index]);
        }
    }
}
