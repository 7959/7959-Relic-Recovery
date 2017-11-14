package org.firstinspires.ftc.teamcode.UtilitiesandMic;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

/**
 * Created by Robi on 10/9/2017.
 */

public final class RobotUtilities {
    RobotUtilities(){

    }




    /**
     *Changes cordinates from (x,y) to (r,theta)
     * finds the radius through the pythagorean therom
     * finds the angle by calculating the arctan of y and x
     */
    public static double[] CarttoPolar(double cart[]){
        double polar[] = new double[2];

        polar[0] = Math.sqrt(cart[0]*cart[0]+ cart[1]*cart[1]);
        polar[1] = Math.atan2(cart[1],cart[0]);
        return polar;
    }


    /**
     *Changes cordinates from (r,theta) to (x,y)
     * x = rcos(theta)
     * y = rsin(theta)
     */
    public static double[] PolartoCart(double polar[]){
        double cart[] = new double[2];
        cart[0] = polar[0] * Math.cos(polar[1]);
        cart[1] = polar[0] * Math.sin(polar[1]);

        return cart;
    }
    public static double[] toMotorInput(double... x){
        return x;
    }
    public static double fixdegrees(double angle){
        while(angle > 180){
            angle = angle - 180;
        }
        while (angle < -180){
            angle = angle+180;
        }
        return angle;
    }
    public static double fixRads(double angle){
        while(angle > Math.PI){
            angle = angle - Math.PI;
        }
        while (angle < 0){
            angle = angle + Math.PI;
        }
        return angle;
    }
    public static boolean isOpmodeActive(LinearOpMode opMode){
        return opMode.opModeIsActive();
    }
    public static boolean stopNotRequested(LinearOpMode opMode){
        return !opMode.isStopRequested();
    }
}
