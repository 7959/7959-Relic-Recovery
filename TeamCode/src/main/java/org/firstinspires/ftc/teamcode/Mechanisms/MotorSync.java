package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

/**
 * Created by Robi on 11/20/2017.
 */

public class MotorSync {
    //This class links CRServos and Motors to have the same powers
    //As well as share modes
    private DcMotor[] motors;
    private CRServo[] servos;

    public MotorSync(DcMotor... motors){
        this.motors = motors;
    }
    public MotorSync(CRServo... servos){
        this.servos = servos;
    }

    public void setMotorMode(DcMotor.RunMode mode){
        for(DcMotor motor: motors){
            motor.setMode(mode);
        }
    }
    public void setDirection(boolean... isForward){
        for(int i = 0;i < motors.length;i++){
            if(isForward[i]){
                motors[i].setDirection(DcMotorSimple.Direction.FORWARD);
            } else motors[i].setDirection(DcMotorSimple.Direction.REVERSE);
        }

        for(int i = 0;i < servos.length;i++){
            if(isForward[i]){
                servos[i].setDirection(DcMotorSimple.Direction.FORWARD);
            } else servos[i].setDirection(DcMotorSimple.Direction.REVERSE);
        }


    }

    public void setPower(double power){
        for(DcMotor motor: motors){
            motor.setPower(power);
        }
    }



    public void runToPosition(int... Position){
        for(int i = 0;i < motors.length;i++){
            motors[i].setTargetPosition(Position[i]);
        }
    }


}
