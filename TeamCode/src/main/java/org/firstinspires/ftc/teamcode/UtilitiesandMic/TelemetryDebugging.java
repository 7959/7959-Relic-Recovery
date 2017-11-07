package org.firstinspires.ftc.teamcode.UtilitiesandMic;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotMain;

/**
 * Created by Robi on 11/6/2017.
 *
 * Debugging thread. Prints data to screen.
 */

public class TelemetryDebugging extends Thread {
    RobotMain main;
    private long waitTime;

    public TelemetryDebugging(RobotMain main, long waitTime) {
        this.main = main;
        this.waitTime = waitTime;

    }

    @Override
    public void run() {
        while (main.opMode.opModeIsActive()){


            try {
                currentThread().sleep(waitTime);
            } catch (InterruptedException SleepError){

            }
        }
    }
}
