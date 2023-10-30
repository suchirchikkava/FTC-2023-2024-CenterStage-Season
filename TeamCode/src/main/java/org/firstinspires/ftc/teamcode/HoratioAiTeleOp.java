package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name = "TeleOpHoratio")
public class HoratioAiTeleOp extends OpMode{
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor frontLeft;
    private DcMotor frontRight;

    @Override
    public void init()
    {
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        backRight.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop()
    {
        if (gamepad1.left_stick_y > 0.3)
        {
            backLeft.setPower(0.6);
            backRight.setPower(0.6);
            frontLeft.setPower(0.6);
            frontRight.setPower(0.6);
        }

        if (gamepad1.left_stick_y <= -0.3)
        {
            backLeft.setPower(-0.6);
            backRight.setPower(-0.6);
            frontLeft.setPower(-0.6);
            frontRight.setPower(-0.6);
        }

        if (gamepad1.left_stick_y < 0.3 && gamepad1.left_stick_y > -0.3)
        {
            backLeft.setPower(0);
            backRight.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(0);
        }

        if (gamepad1.left_stick_x > 0.3)
        {
            backLeft.setPower(-0.6);
            backRight.setPower(0.6);
            frontLeft.setPower(0.6);
            frontRight.setPower(-0.6);
        }

        if (gamepad1.left_stick_x <= -0.3)
        {
            backLeft.setPower(0.6);
            backRight.setPower(-0.6);
            frontLeft.setPower(-0.6);
            frontRight.setPower(0.6);
        }

        if (gamepad1.left_stick_x < 0.3 && gamepad1.left_stick_x > -0.3)
        {
            backLeft.setPower(0);
            backRight.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(0);
        }

        if (gamepad1.left_stick_x < -0.3 && gamepad1.left_stick_y < -0.3)
        {
            backLeft.setPower(-0.6);
            backRight.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(-0.6);
        }

        if (gamepad1.left_stick_x < -0.3 && gamepad1.left_stick_y > 0.3)
        {
            backLeft.setPower(0);
            backRight.setPower(0.6);
            frontLeft.setPower(0.6);
            frontRight.setPower(0);
        }

        if (gamepad1.left_stick_x > 0.3 && gamepad1.left_stick_y < -0.3)
        {
            backLeft.setPower(0);
            backRight.setPower(-0.6);
            frontLeft.setPower(-0.6);
            frontRight.setPower(0);
        }

        if (gamepad1.left_stick_x > 0.3 && gamepad1.left_stick_y > 0.3)
        {
            backLeft.setPower(0.6);
            backRight.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(0.6);
        }

        if (gamepad1.right_bumper)
        {
            backLeft.setPower(0.6);
            backRight.setPower(-0.6);
            frontLeft.setPower(0.6);
            frontRight.setPower(-0.6);
        }

        if (gamepad1.left_bumper)
        {
            backLeft.setPower(-0.6);
            backRight.setPower(0.6);
            frontLeft.setPower(-0.6);
            frontRight.setPower(0.6);
        }

    }
}
