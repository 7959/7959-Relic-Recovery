package org.firstinspires.ftc.teamcode.WheelControl;

/**
 * Created by Robi on 10/12/2017.
 */

public interface Wheels {
    double angletranslationR = Math.PI/4;
    double angletranslationD = 45;

    String front = "Front ";
    String back = "Back ";
    String right = "Right";
    String left = "Left";

    void movebyCart(double Velvector[], double AngularVelocity);
    void movebyPolar(double Velvector[], double AngularVelocity);



}
