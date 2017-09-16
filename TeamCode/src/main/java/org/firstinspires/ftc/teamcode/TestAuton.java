package org.firstinspires.ftc.teamcode;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;

/**
 * Created by Robi on 9/14/2017.
 */

public class TestAuton extends AutonControl {
    Wheels drive;
    VuforiaLocalizer camera;
    @Override
    public void runOpMode() throws InterruptedException {
        //Drive wheels initialization
        drive.init();

        //Vuforia initialization
        OpenGLMatrix lastLocation = null;
        int cameraID = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters cameraPerameters = new VuforiaLocalizer.Parameters(cameraID);

        cameraPerameters.vuforiaLicenseKey = "AXmn/o//////AAAAGaVJenZM3EctobrEv7BirWA5QeIVJcaZZQmNNF33reRfHWRwRwidjcVKbcKs0FS86DVG4WEjBSSoqXOdSoRUuOu9lrzum42nuBlFvNaCmRdXOe0BThEg/T2EjB1+NZTkB1MYu91eng7OtJs15MjOJDxkMQrPQPwhu3qnQiT48BbQ5+ciA8TJlFj1fvOCB8iNDw9/NKVGZZY8OYOOJFOZg4J9jcUqgQCw50YOn3XRuf6mvTcZGtfQm1NfKTrNIf1IIRJw7fg8p82vFrer7VNZNDKAh4gEZKeXU7CfT4WwguxQAtcsnuGqsQ068M1I2fW46aREVZbVSJS/x5T6Zrlh64hLQqvEouC0wakjj691deO7";

        cameraPerameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;

        this.camera = ClassFactory.createVuforiaLocalizer(cameraPerameters);

        VuforiaTrackables relicTrackables = this.camera.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");
        relicTrackables.activate();

        while (opModeIsActive()) {
            RelicRecoveryVuMark pictograph = RelicRecoveryVuMark.from(relicTemplate);
            telemetry.addData("Pictograph", pictograph);
            telemetry.update();
        }
    }
}
