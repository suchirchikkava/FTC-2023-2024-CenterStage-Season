package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
@ TeleOp (name="ArmTest")
public class ArmTest extends OpMode{

    private DcMotor arm;

    @Override
    public void init()   {
        arm = hardwareMap.get(DcMotor.class, "arm");
    }

    @Override
    public void loop() {
        if (gamepad2.left_stick_y > 0.3) {
            arm.setPower(0.8);
        }

        if (gamepad2.left_stick_y < -0.3) {
            arm.setPower(-0.8);
        }
    }
}
