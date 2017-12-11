package org.firstinspires.ftc.teamcode.TestOpmodes;


import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import org.firstinspires.ftc.teamcode.Mechanisms.Claw;
import org.firstinspires.ftc.teamcode.Mechanisms.JewelArm;
import org.firstinspires.ftc.teamcode.Sensors.ColorDistanceSensor;


/**
 * Created by Robi on 12/8/2017.
 */
@Disabled
@TeleOp(name = "SpinTest")
public class SpinThing extends LinearOpMode {
    @Override
    public void runOpMode(){
        //Servo glyphRotator = hardwareMap.servo.get("Claw Rotator");
        DcMotor liftMotor = hardwareMap.dcMotor.get("Parallelogram Lift");
        //ModernRoboticsI2cRangeSensor rangeSensor = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "Range Sensor");
        final DistanceSensor distanceSensor = hardwareMap.get(DistanceSensor.class, "Floor Sensor");
        ColorSensor colorSensor = hardwareMap.colorSensor.get("Jewel Sensor");

        ColorDistanceSensor colorDistanceSensor = new ColorDistanceSensor(hardwareMap, "Jewel Sensor");

        Claw topGylph = new Claw(hardwareMap.servo.get("Top Claw Left"), hardwareMap.servo.get("Top Claw Right"));

        topGylph.setClosePos(.5,.5);
        topGylph.setOpenPos(0, 1);

        Claw botGylph = new Claw(hardwareMap.servo.get("Bottom Claw Left"), hardwareMap.servo.get("Bottom Claw Right"));

        botGylph.setClosePos(0,1);
        botGylph.setOpenPos(.4,.6);

        /*newSingledervative singledervative = new newSingledervative(50) {
            @Override
            protected double getData() {
                return distanceSensor.getDistance(DistanceUnit.CM);
            }
        }*/
        JewelArm arm = new JewelArm(hardwareMap.servo.get("Sweep Servo"), hardwareMap.servo.get("Jewel Arm"));
       // arm.initPos();

        waitForStart();
        //singledervative.start();
        //arm.sweep(colorDistanceSensor, AutonTeam.REDMIDDLE);
        while (opModeIsActive()) {
            //telemetry.addData("dervative", singledervative.getDervative());
            telemetry.addData("red", colorDistanceSensor.getRed());
            telemetry.addData("blue", colorDistanceSensor.getBlue());
            telemetry.addData("isRed", colorDistanceSensor.isRed());
            telemetry.addData("isBlue", colorDistanceSensor.isBlue());
            telemetry.update();

            if (gamepad1.a) {
                //liftMotor.setPower(.2);
                botGylph.open();

            } else if (gamepad1.b){
                botGylph.close();
            } else if(gamepad1.y){
                topGylph.open();
                //liftMotor.setPower(.5);
            } else if(gamepad1.x){
                topGylph.close();
            }
        }
    }
}
