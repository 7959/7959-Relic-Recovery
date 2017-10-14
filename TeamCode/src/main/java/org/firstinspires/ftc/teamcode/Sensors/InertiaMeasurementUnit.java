package org.firstinspires.ftc.teamcode.Sensors;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;

/**
 * Created by Robi on 10/12/2017.
 */

public class InertiaMeasurementUnit{


    /**
     * REMEMBER TO MAKE CALIBRATION PROGRAM
     *
     *
     */
    HardwareMap hw;
    BNO055IMU imu;
    Orientation orientation;
    final DistanceUnit distanceUnit = DistanceUnit.METER;
    final BNO055IMU.AccelUnit accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
    final BNO055IMU.AngleUnit angleUnit = BNO055IMU.AngleUnit.RADIANS;
    final int positioninterval = 1000;



    public InertiaMeasurementUnit(HardwareMap hmap){
        hw = hmap;
        setParameters("imu");

    }


    protected void setParameters(String name){
        //Setts parameters for our IMU sensor.(We use Radians and meters per sec per sec)
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
        parameters.angleUnit = angleUnit;
        parameters.accelUnit = accelUnit;
        parameters.calibrationDataFile = "I don't have a file here yet, but imagine a .json file here";
        parameters.loggingEnabled = true;
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();

        //Map it on the hardware map
        imu = hw.get(BNO055IMU.class, name);
        orientation = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.RADIANS);

        //Initialize the parameters
        imu.initialize(parameters);
    }
    public void startIntegration(double x, double y, double z){
        imu.startAccelerationIntegration(new Position(distanceUnit,x,y,z,0), new Velocity(), positioninterval);
    }
    public double[] getaccel(){
        return new double[] {imu.getAcceleration().xAccel, imu.getAcceleration().yAccel , imu.getAcceleration().zAccel};
    }
    public double[] getPos(){
        return new double[] {imu.getPosition().x, imu.getPosition().y, imu.getPosition().z};
    }
    public float getHeading() {
        return orientation.firstAngle;
    }
    public float getRoll(){
        return orientation.secondAngle;
    }
    public float getPitch(){
        return orientation.thirdAngle;
    }
}
