package org.firstinspires.ftc.teamcode.Sensors;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.RobotControl;
import org.firstinspires.ftc.teamcode.RobotMain;
import org.firstinspires.ftc.teamcode.UtilitiesandMic.MathStuff.TeamIntegrator;


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
    public BNO055IMU imu;
    
    public Orientation ori;
    public Acceleration accel;
    public Position pos;
    public Velocity vel;
    final DistanceUnit distanceUnit = RobotControl.distanceUnit;
    final AngleUnit angleUnit = RobotControl.angleUnit;

    private TeamIntegrator integrator = new TeamIntegrator();



    public InertiaMeasurementUnit(HardwareMap hmap){
        hw = hmap;
        vel = new Velocity();
        accel = new Acceleration();
        pos = new Position();
        setParameters("imu");

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
        parameters.accelerationIntegrationAlgorithm = integrator;

        //Map it on the hardware map
        imu = hw.get(BNO055IMU.class, name);
        ori = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, AngleUnit.DEGREES);

        //Initialize the parameters
        imu.initialize(parameters);

    }
    public void retreiveOriData(){
        ori = imu.getAngularOrientation(AxesReference.INTRINSIC, AxesOrder.ZYX, angleUnit);
    }
    public void reset(){

    }
    private void retreiveaccelData() {
        accel = imu.getLinearAcceleration();
    }
    private void retreivePosData(){
        pos = imu.getPosition();
    }
    private void retreiveVelData(){
        vel = imu.getVelocity();
    }

    public void startIntegration(double x, double y, double z){
        imu.startAccelerationIntegration(new Position(distanceUnit,x,y,z,0), new Velocity(), 1);
    }
    public double getyaccel(){
        return imu.getAcceleration().yAccel;
    }
    public Acceleration getaccel(){
        retreiveaccelData();
        return accel;
    }
    public Velocity getVel(){
        retreiveVelData();
        return vel;
    }
    public Position getPos(){
        retreivePosData();
        return this.pos;
    }
    /*public double[] getPos(){
        retreivePosData();
        return new double[] {imu.getPosition().x, imu.getPosition().y, imu.getPosition().z};
    }*/

    // May change to Orintation class later
    public float getHeading() {
        retreiveOriData();
        return ori.firstAngle;
    }
    public float getRoll(){
        retreiveOriData();
        return ori.secondAngle;
    }
    public float getPitch(){
        retreiveOriData();
        return ori.thirdAngle;
    }
}
