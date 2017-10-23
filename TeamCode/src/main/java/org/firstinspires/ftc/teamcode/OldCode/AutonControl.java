package org.firstinspires.ftc.teamcode.OldCode;

import org.firstinspires.ftc.teamcode.OldCode.RobotControl;

/**
 * Created by Robi on 9/16/2017.
 */
@Deprecated
public abstract class AutonControl extends RobotControl {

    final static String LiscenseKey ="AXmn/o//////AAAAGaVJenZM3EctobrEv7BirWA5QeIVJcaZZQmNNF33reRfHWRwRwidjcVKbcKs0FS86DVG4WEjBSSoqXOdSoRUuOu9lrzum42nuBlFvNaCmRdXOe0BThEg/T2EjB1+NZTkB1MYu91eng7OtJs15MjOJDxkMQrPQPwhu3qnQiT48BbQ5+ciA8TJlFj1fvOCB8iNDw9/NKVGZZY8OYOOJFOZg4J9jcUqgQCw50YOn3XRuf6mvTcZGtfQm1NfKTrNIf1IIRJw7fg8p82vFrer7VNZNDKAh4gEZKeXU7CfT4WwguxQAtcsnuGqsQ068M1I2fW46aREVZbVSJS/x5T6Zrlh64hLQqvEouC0wakjj691deO7";

    public class PositionEstimater implements Runnable{
        public double[] position;
        final double imuweight;
        final double cameraWeight;
        final double encoderWeight;
        final double[] zeroed = {0,0,0};
        private double[] preposition;
        IMU imu;



        //Constuctor has weights(all must add up to one)
        PositionEstimater(double Imuweight, double cameraweight, double encoderweight, IMU Imu){
            this.imuweight = Imuweight;
            this.cameraWeight = cameraweight;
            this.encoderWeight = encoderweight;
            this.imu = Imu;
            if(imuweight + cameraWeight + encoderWeight != 1){
                robotUtil.endOpMode("Position weights don't add up to 1");
            }
        }

        public void run() {
            while (opModeIsActive()) {
                preposition = zeroed;
                ///Camera estimate(if available) more accurate

                //Encoder estimate


                //IMU Acceleration's position from integration data added
                double imupos[] = imu.getPos();
                for (int i = 0; i < 3; i++) {
                    preposition[i] = preposition[i] + (imupos[i] * imuweight);
                }




                position = preposition;
            }
        }
    }


}
