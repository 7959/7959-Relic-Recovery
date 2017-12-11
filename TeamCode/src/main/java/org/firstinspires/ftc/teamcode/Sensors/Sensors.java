package org.firstinspires.ftc.teamcode.Sensors;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.teamcode.RobotControl;

/**
 * Created by Robi on 12/8/2017.
 */
@Deprecated
public class Sensors {

    private ColorSensor colorSensor;
    private DistanceSensor optDistance;
    private ModernRoboticsI2cRangeSensor rangeSensor;
    private BNO055IMU imu;
    private Orientation orientation;

    public Sensors(ColorSensor colorSensor, DistanceSensor optDistance, ModernRoboticsI2cRangeSensor rangeSensor){

        this.colorSensor = colorSensor;
        this.optDistance = optDistance;
        this.rangeSensor = rangeSensor;


        orientation = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);
        imu.initialize(imuParameters(BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC, BNO055IMU.AngleUnit.RADIANS));


    }

    public ModernRoboticsI2cRangeSensor getRangeSensor(){
        return rangeSensor;
    }



    public boolean jewelisRed(){
        if(colorSensor.red() > colorSensor.blue())
            return true;
        else return false;
    }
    public boolean jewelisBlue(){
        return !jewelisRed();
    }

    public double getDistance(){
        return optDistance.getDistance(RobotControl.distanceUnit);
    }



    private void setParameters(String name){


        BNO055IMU.AccelUnit IMUaccelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        BNO055IMU.AngleUnit IMUangleUnit;
        switch (RobotControl.angleUnit){
            case DEGREES: IMUangleUnit = BNO055IMU.AngleUnit.DEGREES;
            case RADIANS: IMUangleUnit = BNO055IMU.AngleUnit.RADIANS;
            default: IMUangleUnit = BNO055IMU.AngleUnit.RADIANS;
        }
        //Setts parameters for our IMU colorSensor.(We use Radians and meters per sec per sec)
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = IMUangleUnit;
        parameters.accelUnit = IMUaccelUnit;
        //parameters.calibrationDataFile = "I don't have a file here yet, but imagine a .json file here";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";


        //Map it on the hardware map


        //Initialize the parameters
        imu.initialize(parameters);

    }


    private BNO055IMU.Parameters imuParameters(BNO055IMU.AccelUnit accelUnit, BNO055IMU.AngleUnit angleUnit){
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = angleUnit;
        parameters.accelUnit = accelUnit;
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        return parameters;
    }
}
