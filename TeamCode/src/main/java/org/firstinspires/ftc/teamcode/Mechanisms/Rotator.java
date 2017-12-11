package org.firstinspires.ftc.teamcode.Mechanisms;


import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by Robi on 12/9/2017.
 */

public class Rotator {
    private DcMotor rotator;
    private final double rotatePower = .4;
    private AutoRotator autoRotator;
    public Rotator(DcMotor rotator){
        this.rotator = rotator;
        autoRotator = new AutoRotator();
    }
    public void rotate(){
        rotator.setPower(rotatePower);
    }
    public void reverse(){
        rotator.setPower(-rotatePower);
    }
    public void powerOff(){
        rotator.setPower(0);
    }

    @Deprecated
    public void autoRotate(boolean isReversed){


        if(!autoRotator.isAlive()){

            autoRotator.start(isReversed);
        }
    }
    @Deprecated
    private class AutoRotator extends Thread{
        private boolean isReversed;
        public void start(boolean isReversed){
            this.isReversed = isReversed;

            super.start();
        }
        @Override
        public void run() {
            rotator.setPower(isReversed ? -rotatePower : rotatePower);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            rotator.setPower(0);
            return;
        }
    }
}
