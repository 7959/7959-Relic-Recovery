package org.firstinspires.ftc.teamcode.AutonAlgorithms;

import org.firstinspires.ftc.teamcode.RobotMain;

/**
 * Created by Robi on 10/27/2017.
 */

public abstract class BaseAuton {
    protected boolean isRed;
    protected RobotMain main;
    protected WheelControl driving = new WheelControl();

    protected class WheelControl extends Thread {
        private double input[] = {0, 0};
        private double DesiredAngle = 0;

        @Override
        public void run() {
            while (main.opMode.opModeIsActive())
                main.drive.movebyCart(input, DesiredAngle);
        }

        public void setInput(double input[]) {
            this.input = input;
        }

        public void setDesiredAngle(double angle) {
            this.DesiredAngle = angle;
        }
    }

    public BaseAuton(RobotMain main, boolean isRed) {
        this.main = main;
        this.isRed = isRed;
    }

    protected enum JewelColor {
        RED, BLUE, UNKNOWN
    }


    protected final long maxTime = 5000;


    protected JewelColor isJewelRight() {
        main.JewelArm.open();
        long timeinterval = System.currentTimeMillis() + maxTime;
        while (main.opMode.opModeIsActive() && timeinterval > System.currentTimeMillis()) {
            if (main.JewelSensor.isRed()) return JewelColor.RED;
            if (main.JewelSensor.isBlue()) return JewelColor.BLUE;
        }
        return JewelColor.UNKNOWN;
    }


    //Input isJewelRight
    protected void knockJewel(JewelColor color){
        double input[] = {0,0};
        if(color == JewelColor.RED){
            if(isRed) input[0] = .2;
            else input[0] = -.2;
        } else if(color == JewelColor.BLUE){
            if(isRed){
                input[0] = -.2;
            } else input[0] = .2;
        } else if(color == JewelColor.UNKNOWN){
            main.JewelArm.close();
        }
    }
}
