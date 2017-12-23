package org.firstinspires.ftc.teamcode.Sensors;

import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchDevice;
import com.qualcomm.robotcore.hardware.configuration.I2cSensor;

/**
 * Created by Robi on 12/13/2017.
 */
@I2cSensor(name = "Rev Hip Sick Potentiometer", description = "Thing go speed, Robi go code",xmlTag = "REVPOTENTIOMETER")
public class REVPotentiometer extends I2cDeviceSynchDevice<I2cDeviceSynch> {
    protected REVPotentiometer(I2cDeviceSynch deviceClient) {
        super(deviceClient, true);
        super.registerArmingStateCallback(false);
    }

    @Override
    protected boolean doInitialize() {
        return true;
    }

    @Override
    public Manufacturer getManufacturer() {
        return Manufacturer.Other;
    }

    @Override
    public String getDeviceName() {
        return "Rev Potentiometer dude thing";
    }
}
