package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp (name = "TeleOpTestHoratio")
public class ArmTest extends OpMode
{
    private DcMotor armMotor;
    @Override
    public void init()
    {
        armMotor = hardwareMap.get(DcMotor.class, "armMotor");
    }

    @Override
    public void loop()
    {
        if(gamepad1.left_stick_y > 0.3)
            armMotor.setPower(0.6);

        if(gamepad1.left_stick_y < -0.3)
            armMotor.setPower(-0.6);
    }
}
