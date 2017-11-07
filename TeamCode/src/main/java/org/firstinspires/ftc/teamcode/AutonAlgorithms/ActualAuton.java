package org.firstinspires.ftc.teamcode.AutonAlgorithms;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.teamcode.OldCode.RobotControl;
import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.Sensors.InertiaMeasurementUnit;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.RobotUtilities;
import org.firstinspires.ftc.teamcode.WheelControl.WheelsImu;

/**
 * Created by Robi on 11/2/2017.
 */

public class ActualAuton {
    AutonTeam team;
    RobotMain main;
    private double input[] = {0,0};

    public ActualAuton(RobotMain main, AutonTeam team){
        this.main = main;
        this.team = team;
        main.drive = new WheelsImu(main.imu, main.hwMap);
        this.main.JewelArm.close();
    }

    private class debuggingPrinting extends Thread{
        RobotMain main;
        public debuggingPrinting(RobotMain main){
            this.main = main;
        }
        @Override
        public void run() {
            while (main.opMode.opModeIsActive()){
                main.tele.addData("FloorSens", main.NavSensors.floorSensor.colorSensor.alpha());
                main.tele.addData("UltraSonic Distance", main.NavSensors.getWallDistance());
                main.tele.update();
            }
        }
    }

    public void run(){
        //main.RelicArm.lift(.2);
        //main.opMode.sleep(1000);
        //main.RelicArm.lift(.4285);
        debuggingPrinting debug = new debuggingPrinting(this.main);
        //main.lift.closeClaw();
        debug.start();
        switch (team){


            case REDCORNER: {
                JewelKnock();
                main.JewelArm.setServo(.65);
                main.drive.overrideDrive(RobotUtilities.toMotorInput(.5,.1),0);
                main.opMode.sleep(2500+ (moveWrongway ? 500 : 0));
                main.drive.overrideDrive(RobotUtilities.toMotorInput(0,0),0);
               /* main.drive.overrideDrive(RobotUtilities.toMotorInput(0,0), .3);
                main.opMode.sleep(3500);
                main.drive.overrideDrive(RobotUtilities.toMotorInput(0,0), 0);*/
                //main.JewelArm.setServo(0);
               // main.opMode.sleep(500);
                main.opMode.requestOpModeStop();
                main.opMode.sleep(30000);
            }


            case BLUECORNOR:{
                JewelKnock();
                main.JewelArm.setServo(.65);
                main.drive.overrideDrive(RobotUtilities.toMotorInput(-.5,.1),0);
                main.opMode.sleep(2500 +(moveWrongway ? 500 : 0));
                main.drive.overrideDrive(RobotUtilities.toMotorInput(0,0),0);

                main.opMode.requestOpModeStop();
                main.opMode.sleep(30000);
            }


            case REDMIDDLE: {
                JewelKnock();
                main.JewelArm.setServo(.65);
                main.drive.overrideDrive(RobotUtilities.toMotorInput(.5,0),0);
                main.opMode.sleep(1500 + (moveWrongway ? 500 : 0));
                main.drive.overrideDrive(RobotUtilities.toMotorInput(0,0),0);
                //driveOffPlatform(false);
                //driveuntilLine(.2, 0);
                main.opMode.requestOpModeStop();
                main.opMode.sleep(30000);
            }



            case BLUEMIDDLE: {
                JewelKnock();
                main.JewelArm.close();
                main.drive.overrideDrive(RobotUtilities.toMotorInput(-.5,-.1),0);
                main.opMode.sleep(1500 + (moveWrongway ? 500 : 0));
                main.drive.overrideDrive(RobotUtilities.toMotorInput(0,0),0);
                //driveOffPlatform(true);
                //driveuntilLine(.2,0);
                main.opMode.requestOpModeStop();
                main.opMode.sleep(30000);
            }



                default: main.opMode.requestOpModeStop();
        }

        main.opMode.requestOpModeStop();
    }

    protected void basicDrivetoZone(boolean isCorner){
        if(isCorner){
            main.drive.overrideDrive(RobotUtilities.toMotorInput(.5,0),0);
            main.opMode.sleep(2000);
            main.drive.overrideDrive(RobotUtilities.toMotorInput(0,0),0);
            resetIMU();
            main.opMode.sleep(500);
            double timeTillStop = System.currentTimeMillis() + 1000;
            while(main.opMode.opModeIsActive() && System.currentTimeMillis() < timeTillStop) main.drive.movebyCart(RobotUtilities.toMotorInput(0,0), 180);

        } else {
            main.drive.overrideDrive(RobotUtilities.toMotorInput(.5,0),0);
            main.opMode.sleep(2000);
            main.drive.overrideDrive(RobotUtilities.toMotorInput(0,0),0);
        }
        main.JewelArm.setServo(0);
        main.opMode.sleep(500);
    }

    boolean moveWrongway;
    protected void JewelKnock(){
        boolean isRed;
        if(team == AutonTeam.REDCORNER || team == AutonTeam.REDMIDDLE) isRed = true;
        else isRed = false;
        main.JewelArm.open();
        main.opMode.sleep(500);
        if(main.JewelSensor.isRed() && isRed){
            main.drive.movebyCart(RobotUtilities.toMotorInput(-.2,0), 0);
            moveWrongway = true;
        } else if(main.JewelSensor.isRed() && !isRed){
            main.drive.movebyCart(RobotUtilities.toMotorInput(.2,0),0);
            moveWrongway = false;
        } else if(isRed){
            main.drive.movebyCart(RobotUtilities.toMotorInput(.2,0), 0);
            moveWrongway = false;
        } else if(!isRed) {
            main.drive.movebyCart(RobotUtilities.toMotorInput(-.2, 0), 0);
            moveWrongway = true;
        }
        main.opMode.sleep(350);
        main.drive.overrideDrive(RobotUtilities.toMotorInput(0,0), 0);
        main.JewelArm.close();
        main.opMode.sleep(500);
    }
    protected void driveOffPlatform(boolean isRight){
        while (isRight && main.opMode.opModeIsActive() && main.NavSensors.isLineFound()){
            main.drive.overrideDrive(RobotUtilities.toMotorInput(-.5,0),0);
        }
        while (!isRight && main.opMode.opModeIsActive() && main.NavSensors.isLineFound()){
            main.drive.overrideDrive(RobotUtilities.toMotorInput(.5,0),0);
        }
        if(isRight){
            main.drive.overrideDrive(RobotUtilities.toMotorInput(-.2,0),0);
        } else main.drive.overrideDrive(RobotUtilities.toMotorInput(.2, 0), 0);
        main.opMode.sleep(2000);
    }
    private void resetIMU(){
        main.imu = new InertiaMeasurementUnit(main.hwMap);
    }
    protected void driveuntilLine(double x, double y){
        while (main.opMode.opModeIsActive() && !main.NavSensors.isLineFound()){
            main.drive.overrideDrive(RobotUtilities.toMotorInput(x,y),0);
        }
    }
    private void cornerAuton(boolean isRed){
        main.JewelArm.open();
        main.opMode.sleep(1000);
        if(main.JewelSensor.isRed() && isRed){
            main.drive.movebyCart(RobotUtilities.toMotorInput(-.2,0), 0);
            main.opMode.sleep(500);
        } else if(main.JewelSensor.isRed() && !isRed){
            main.drive.movebyCart(RobotUtilities.toMotorInput(.2,0),0);
        } else if(isRed){
        }
    }
    private void midAuton(boolean isRed){

    }

}
