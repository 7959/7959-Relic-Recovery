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
    }
    public void savePositions(int ServoIndex, double[] positions){
        for(int i = 0; i < positions.length;i++){
            this.positions[ServoIndex][i] = positions[i];
        }
    }

    public void gotoPos(int index){
        for(int i = 0; i < servos.length;i++){
            servos[i].setPosition(positions[i][index]);
        }
    }
}
