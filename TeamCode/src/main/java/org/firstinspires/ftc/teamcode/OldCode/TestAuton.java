package org.firstinspires.ftc.teamcode.OldCode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackables;
import org.firstinspires.ftc.teamcode.OldCode.AutonControl;

/**
 * Created by Robi on 9/14/2017.
 */
@Autonomous(name = "test")
public class TestAuton extends AutonControl {
   // BasicWheels drive = new BasicWheels();
    Claw relicClaw = new Claw("relicClaw");
    Claw cubeClaw = new Claw("Cubeclaw1", "Cubeclaw2");
    Claw cubeClaw2 = new Claw("UCubeclaw1", "UCubeclaw2");
    VuforiaLocalizer camera;
    IMU REVimu = new IMU();
    Thread PosEstimate = new Thread(new PositionEstimater(1,0,0, REVimu));

    @Override
    public void runOpMode() throws InterruptedException {
        //TeleOpDrive wheels initialization
       // drive.init();

        //DoubServ initialization
        //relicClaw.init();
        cubeClaw.init();
        //cubeClaw2.init();


        //Vuforia initialization
        OpenGLMatrix lastLocation = null;
        int cameraID = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        VuforiaLocalizer.Parameters cameraPerameters = new VuforiaLocalizer.Parameters(cameraID);
        cameraPerameters.vuforiaLicenseKey = LiscenseKey;
        cameraPerameters.cameraDirection = VuforiaLocalizer.CameraDirection.BACK;
        this.camera = ClassFactory.createVuforiaLocalizer(cameraPerameters);
        VuforiaTrackables relicTrackables = this.camera.loadTrackablesFromAsset("RelicVuMark");
        VuforiaTrackable relicTemplate = relicTrackables.get(0);
        relicTemplate.setName("relicVuMarkTemplate");
        relicTrackables.activate();
        //Couldn't find a way to get it in a function, so it looks real messy

        PosEstimate.start();
        while (opModeIsActive()) {

            RelicRecoveryVuMark pictograph = RelicRecoveryVuMark.from(relicTemplate);
            telemetry.addData("Pictograph", pictograph);
            telemetry.update();
        }
    }


}
