package org.firstinspires.ftc.teamcode.Mechanisms.Claws;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 10/22/2017.
 */

public class SoftwareServoController {

    double openPos[];
    double closePos[];

    public Servo servo[];
    HardwareMap hwMap;
    public SoftwareServoController(HardwareMap hwMap,String... names){
        this.hwMap = hwMap;
        for(int i = 0; i < names.length;i++){
            servo[0] = this.hwMap.servo.get(names[i]);
        }
        openPos = new double[names.length];
        closePos = new double[names.length];
    }
    public void setOpenpos(double... openpos){
        this.openPos = openpos;
    }
    public void setClosePos(double... closePos){
        this.closePos = closePos;
    }
    public void open(){
        for(int i = 0; i < openPos.length;i++){
            servo[i].setPosition(openPos[i]);
        }
    }
    public void close(){
        for(int i = 0; i < openPos.length;i++){
            servo[i].setPosition(openPos[i]);
        }
    }


}
