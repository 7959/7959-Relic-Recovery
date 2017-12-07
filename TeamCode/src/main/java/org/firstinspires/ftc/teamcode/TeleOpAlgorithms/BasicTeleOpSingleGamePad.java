package org.firstinspires.ftc.teamcode.TeleOpAlgorithms;

import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.WheelControl.BasicWheels;
import org.firstinspires.ftc.teamcode.WheelControl.WheelsEncoded;

/**
 * Created by Robi on 10/24/2017.
 *
 * The superclass for TeleOp Controls
 *
 */
@Deprecated
public class BasicTeleOpSingleGamePad{
   /* protected RobotMain main;
    protected Gamepad gamepad1;

    protected enum driveMode{
        SLOW,NORMAL,FAST
    }


    public BasicTeleOpSingleGamePad(){

    }
    protected driveMode mode = driveMode.NORMAL;
    public BasicTeleOpSingleGamePad(RobotMain main, Gamepad gamepad1){
        this.main = main;
        this.gamepad1 = gamepad1;
        this.main.drive = new WheelsEncoded(main.hwMap);
    }
    public void run(){
        drive(gamepad1);
        chassisPinionControl(gamepad1);
        liftControl(gamepad1);
        relicArmControl(gamepad1);
        if(gamepad1.dpad_down) relicClawControl(gamepad1);
            else clawControl(gamepad1);
        main.tele.addData("Drive Mode", mode);
    }

    protected void chassisPinionControl(Gamepad controller){
        if(controller.dpad_up)
            main.chassisPinion.invertPower(1);
        else if(controller.dpad_down)
            main.chassisPinion.invertPower(-1);
        else main.chassisPinion.invertPower(0);
    }
    protected void liftControl(Gamepad controller){
        if(controller.a){
            main.lift.lift(.57);
        } else if(controller.b){
            main.lift.lift(-.428);
        } else main.lift.holdPos();
    }
    boolean isPressed = false;
    boolean isSlow = false;
    protected void drive(Gamepad controller){
        if(controller.right_bumper) mode = driveMode.FAST;
        else{
            if(isSlow) mode = driveMode.SLOW;
            else mode = driveMode.NORMAL;
        }
        if(controller.start && !isPressed){
            isSlow = !isSlow;
            isPressed = true;
        } else if(!controller.start && isPressed) isPressed = false;

        double input[] = {controller.left_stick_x, controller.left_stick_y};
        switch (mode){
            case SLOW:{
                input[0] *= .33;
                input[1] *= .33;
            }
            case NORMAL:{
                input[0] *= .66;
                input[1] *= .66;
            }
            case FAST:{
                input[0] *= 1;
                input[1] *= 1;
            }
        }
        main.drive.movebyCart(input, gamepad1.right_stick_x);
    }

    protected void relicArmControl(Gamepad controller){
        if(controller.y){
            main.LinearExtension.lift(-.5);
        } else if(controller.x){
            main.LinearExtension.lift(.5);
        } else if(controller.right_bumper){
            main.LinearExtension.lift(relicClawOpen ? -.2 : -.3);
        }
        else main.LinearExtension.lift(0);
    }
    protected boolean relicClawOpen = false;
    protected void relicClawControl(Gamepad controller){
        if(controller.right_trigger > .1){
            main.relicClaw.close();
            relicClawOpen = false;
        } else if(controller.left_trigger > .1){
            main.relicClaw.open();
            relicClawOpen = true;
        }
    }



    protected void clawControl(Gamepad controller) {

        if(controller.right_trigger > .2){
            main.lift.closeClaw();
        } else if(controller.left_trigger > .2){
            main.lift.openClaw();
        } else if(controller.right_bumper){
            main.lift.slightClose();
        }
    }*/

}
