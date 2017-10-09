package org.firstinspires.ftc.teamcode;

/**
 * Created by Robi on 10/9/2017.
 */

public class RobotUtilities {
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


}
