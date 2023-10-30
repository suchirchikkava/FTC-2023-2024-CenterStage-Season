package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp (name="TeleOpJadon")
public class JadonFirstCode extends OpMode{

    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor frontLeft;
    private DcMotor frontRight;

    @Override
    public void init() {
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        // sets wheels in reverse because build team messed up
        backRight.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        boolean gamepad1_left_stick_y_false = gamepad1.left_stick_y < 0.3 && gamepad1.left_stick_y > -0.3;
        boolean gamepad1_left_stick_x_false = gamepad1.left_stick_x < 0.3 && gamepad1.left_stick_x > -0.3;
        boolean gamepad1_bumpers_false = !gamepad1.left_bumper && !gamepad1.right_bumper;

        if (gamepad1.left_stick_y > 0.3) {
            forward();
        }

        if (gamepad1.left_stick_y < -0.3) {
            backward();
        }

        if (gamepad1.left_stick_x < -0.3) {
            // strafe left
            strafe(false);
        }

        if (gamepad1.left_stick_x > 0.3) {
            // strafe right
            strafe(true);
        }

        if (gamepad1.left_bumper) {
            // rotate counter clockwise
            rotate(false);
        }

        if (gamepad1.right_bumper) {
            // rotate clockwise
            rotate(true);
        }

        if (gamepad1.left_stick_y > 0.3 && gamepad1.left_stick_x < -0.3) {
            // diagonal forward left
            diagonal(true, false);
        }

        if (gamepad1.left_stick_y > 0.3 && gamepad1.left_stick_x > 0.3) {
            // diagonal forward right
            diagonal(true, true);
        }

        if (gamepad1.left_stick_y < -0.3 && gamepad1.left_stick_x < -0.3) {
            // diagonal backward left
            diagonal(false, false);
        }

        if (gamepad1.left_stick_y < -0.3 && gamepad1.left_stick_x > 0.3) {
            // diagonal backward right
            diagonal(false, true);
        }

        if (gamepad1_left_stick_y_false && gamepad1_left_stick_x_false && gamepad1_bumpers_false) {
            // sets wheel power to zero when gamepad1 is not being used
            backLeft.setPower(0);
            backRight.setPower(0);
            frontLeft.setPower(0);
            frontRight.setPower(0);
        }
    }

    public void forward() {
        backLeft.setPower(0.6);
        backRight.setPower(0.6);
        frontLeft.setPower(0.6);
        frontRight.setPower(0.6);
    }

    public void backward() {
        backLeft.setPower(-0.6);
        backRight.setPower(-0.6);
        frontLeft.setPower(-0.6);
        frontRight.setPower(-0.6);
    }

    public void strafe(boolean right) {
        if (right) {
            backLeft.setPower(-0.6);
            backRight.setPower(0.6);
            frontLeft.setPower(0.6);
            frontRight.setPower(-0.6);
        } else {
            backLeft.setPower(0.6);
            backRight.setPower(-0.6);
            frontLeft.setPower(-0.6);
            frontRight.setPower(0.6);
        }
    }

    public void rotate(boolean clockwise) {
        if (clockwise) {
            backLeft.setPower(0.6);
            backRight.setPower(-0.6);
            frontLeft.setPower(0.6);
            frontRight.setPower(-0.6);
        } else {
            backLeft.setPower(-0.6);
            backRight.setPower(0.6);
            frontLeft.setPower(-0.6);
            frontRight.setPower(0.6);
        }
    }

    public void diagonal(boolean forward, boolean right) {
        if (forward) {
            if (right) {
                backLeft.setPower(0);
                backRight.setPower(0.6);
                frontLeft.setPower(0.6);
                frontRight.setPower(0);
            } else {
                backLeft.setPower(0.6);
                backRight.setPower(0);
                frontLeft.setPower(0);
                frontRight.setPower(0.6);
            }
        } else {
            if (right) {
                backLeft.setPower(-0.6);
                backRight.setPower(0);
                frontLeft.setPower(0);
                frontRight.setPower(-0.6);
            } else {
                backLeft.setPower(0);
                backRight.setPower(-0.6);
                frontLeft.setPower(-0.6);
                frontRight.setPower(0);
            }
        }
    }
}
