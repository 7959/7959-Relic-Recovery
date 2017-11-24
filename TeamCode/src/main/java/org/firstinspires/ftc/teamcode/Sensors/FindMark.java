package org.firstinspires.ftc.teamcode.Sensors;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.RobotControl;

/**
 * Created by Robi on 11/2/2017.
 */

public class FindMark extends Thread {


    protected VuforiaLocalizer camera;
    protected VuforiaTrackable relicTemplate;
    protected VuforiaTrackables relicTrackables;
    private RobotControl robotControl;
    private RelicRecoveryVuMark target;

    private final String LiscenseKey ="AXmn/o//////AAAAGaVJenZM3EctobrEv7BirWA5QeIVJcaZZQmNNF33reRfHWRwRwidjcVKbcKs0FS86DVG4WEjBSSoqXOdSoRUuOu9lrzum42nuBlFvNaCmRdXOe0BThEg/T2EjB1+NZTkB1MYu91eng7OtJs15MjOJDxkMQrPQPwhu3qnQiT48BbQ5+ciA8TJlFj1fvOCB8iNDw9/NKVGZZY8OYOOJFOZg4J9jcUqgQCw50YOn3XRuf6mvTcZGtfQm1NfKTrNIf1IIRJw7fg8p82vFrer7VNZNDKAh4gEZKeXU7CfT4WwguxQAtcsnuGqsQ068M1I2fW46aREVZbVSJS/x5T6Zrlh64hLQqvEouC0wakjj691deO7";
    public FindMark(RobotControl RobotControl){
        int cameraID = RobotControl.opMode.hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", RobotControl.opMode.hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters cameraPerameters = new VuforiaLocalizer.Parameters(cameraID);
        cameraPerameters.vuforiaLicenseKey = LiscenseKey;
        cameraPerameters.cameraDirection = VuforiaLocalizer.CameraDirection.FRONT;
        this.camera = ClassFactory.createVuforiaLocalizer(cameraPerameters);
        relicTrackables = this.camera.loadTrackablesFromAsset("RelicVuMark");
        relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");
        relicTrackables.activate();
    }
    private RelicRecoveryVuMark vuMark(){
        return RelicRecoveryVuMark.from(relicTemplate);
    }

    @Override
    public void run(){
        while (RobotControl.opMode.opModeIsActive() && vuMark() == RelicRecoveryVuMark.UNKNOWN){
            target = vuMark();
            try {
                Thread.sleep(200);
            } catch (Exception e){

            }
        }
        relicTrackables.deactivate();
        camera = null;
    }

    public RelicRecoveryVuMark getTarget(){
        return target;
    }

}