package org.firstinspires.ftc.teamcode.Mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by Robi on 11/20/2017.
 */

public class RelicArm {

    public DcMotor pulleyMotor;
    public ServoSync relicClaw;
    public RelicArm(HardwareMap hwMap){
        pulleyMotor = hwMap.dcMotor.get("Pulley Motor");
        Servo far = hwMap.servo.get("Far Relic");
        Servo close = hwMap.servo.get("Close Relic");
        relicClaw = new ServoSync(hwMap, far, close);
        double[] savedPositionsfar = {0,.5,1};
        double[] savedPositionsclose = {1,.5,1};
        relicClaw.savePositions(0, savedPositionsfar);
        relicClaw.savePositions(1, savedPositionsclose);
    }
    public void setPulleyMotorPower(double power){
        pulleyMotor.setPower(power);

    }

}
