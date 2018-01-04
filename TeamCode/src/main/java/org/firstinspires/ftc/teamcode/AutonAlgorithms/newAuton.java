package org.firstinspires.ftc.teamcode.AutonAlgorithms;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Mechanisms.ChassisWedge;
import org.firstinspires.ftc.teamcode.Mechanisms.JewelArm;
import org.firstinspires.ftc.teamcode.Mechanisms.MotorSync;
import org.firstinspires.ftc.teamcode.Opmodes.OpMode7959;
import org.firstinspires.ftc.teamcode.Sensors.FindMark;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.AutonTeam;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.RobotUtilities;
import org.firstinspires.ftc.teamcode.WheelControl.IMUDrive;

/**
 * Created by Robi on 12/12/2017.
 */

public abstract class newAuton {
    public AutonTeam team;
    private MotorSync intake;
    private JewelArm jewelArm;
    private IMUDrive drive;
    private ChassisWedge chassisWedge;
    private final double slowMove = .1;
    private final double normalMove = .3;
    private final double fastMove = .5;
    private FindMark markFinder;
    

    public newAuton(AutonTeam team, MotorSync intake, JewelArm jewelArm, IMUDrive drive, ChassisWedge chassisWedge) {
        this.intake = intake;
        this.jewelArm = jewelArm;
        this.drive = drive;
        this.chassisWedge = chassisWedge;
        markFinder = new FindMark();
    }

    private void jewelKnock(){
        jewelArm.setPos(1,.5);// TODO FIND DOWN POSITIONS
        RobotUtilities.sleep(500);
        jewelArm.sweep(team.isRed() ? jewelArm.jewelisRed() : !jewelArm.jewelisRed());
        RobotUtilities.sleep(500);
        jewelArm.init();
    }

    private void startMarkFinder(){
        markFinder.start();
    }

    final double redMidBoxAngle = 0;
    final double blueMidBoxAngle = 0;
    final double redCornBoxAngle = (OpMode7959.angleUnit == AngleUnit.RADIANS ? Math.PI/2 : 90);
    final double blueCornBoxAngle = (OpMode7959.angleUnit == AngleUnit.RADIANS ? -Math.PI/2 : -90);
    private void positiontoBox(){
        switch (team){
            case REDMIDDLE:{
                drive.movebyCart(-.1,0,redMidBoxAngle);
                RobotUtilities.sleep(1500);
                drive.movebyCart(0,.1,redMidBoxAngle);
                RobotUtilities.sleep(500);
                drive.powerOff();
                break;
            }
            case BLUEMIDDLE:{
                drive.movebyCart(.1,0,blueMidBoxAngle);
                RobotUtilities.sleep(3000);
                drive.movebyCart(0,.1,blueMidBoxAngle);
                RobotUtilities.sleep(500);
                drive.powerOff();
                break;
            }

            case REDCORNER:{
                drive.movebyCart(-.1,0,0);
                RobotUtilities.sleep(1000);
                drive.movebyCart(0,0,redCornBoxAngle);
                RobotUtilities.sleep(500);
                drive.movebyCart(0,.1,redCornBoxAngle);
                RobotUtilities.sleep(500);
                drive.powerOff();
                break;
            }
            case BLUECORNOR:{
                drive.movebyCart(.1,0,0);
                RobotUtilities.sleep(1000);
                drive.movebyCart(0,0,blueCornBoxAngle);
                RobotUtilities.sleep(500);
                drive.movebyCart(0,.1,blueCornBoxAngle);
                RobotUtilities.sleep(500);
                drive.powerOff();
                break;
            }

            default:{
                break;
            }
        }
        chassisWedge.wedgeServoPos(0);
        RobotUtilities.sleep(250);

    }


    private void passSide(){
        chassisWedge.down();
        RobotUtilities.sleep(200);
        RobotUtilities.startFailsafeTimer(4000);
        while (!chassisWedge.sideinFront() && RobotUtilities.isActive()&& RobotUtilities.timeFailsafe()){//TODO FIND DIFFERING POWERS FOR EACH TEAM LATER
            drive.movebyCart(.1,0,0);
        }
        chassisWedge.up();
        RobotUtilities.sleep(200);
    }
}
