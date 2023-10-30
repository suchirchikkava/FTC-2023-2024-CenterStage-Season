package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp (name="TeleOpJoshua")
public class JoshuaFirstCode extends OpMode {
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor frontLeft;
    private DcMotor frontRight;
    // private objects DcMotor class for the controls

    @Override
    public void init() {
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        backRight.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        // name each wheel in the robot, mapped the wheels
    }
    public void forward() {
        backLeft.setPower(0.6); backRight.setPower(0.6); frontLeft.setPower(0.6); frontRight.setPower(0.6);
    }
    public void backward() {
        backLeft.setPower(-0.6); backRight.setPower(-0.6); frontLeft.setPower(-0.6); frontRight.setPower(-0.6);
    }
    public void deadZone() {
        backLeft.setPower(0); backRight.setPower(0); frontLeft.setPower(0); frontRight.setPower(0);
    }
    public void straifeLeft() {
        backLeft.setPower(0.6); backRight.setPower(-0.6); frontLeft.setPower(-0.6); frontRight.setPower(0.6);
    }
    public void straifeRight() {
        backLeft.setPower(-0.6); backRight.setPower(0.6); frontLeft.setPower(0.6); frontRight.setPower(-0.6);
    }
    public void turnRight() {
        backLeft.setPower(0.6); backRight.setPower(-0.6); frontLeft.setPower(0.6); frontRight.setPower(-0.6);
    }
    public void turnLeft() {
        backLeft.setPower(-0.6); backRight.setPower(0.6); frontLeft.setPower(-0.6); frontRight.setPower(0.6);
    }
    public void diagonalUpLeft() {
        frontLeft.setPower(0); backLeft.setPower(0.6); frontRight.setPower(0.6); backRight.setPower(0);
    }
    public void diagonalUpRight() {
        frontLeft.setPower(0.6); backLeft.setPower(0); frontRight.setPower(0.6); backRight.setPower(0.6);
    }
    public void diagonalBackLeft() {
        frontLeft.setPower(-0.6); backLeft.setPower(0); frontRight.setPower(0); backRight.setPower(-0.6);
    }
    public void diagonalBackRight() {
        frontLeft.setPower(0); backLeft.setPower(-0.6); frontRight.setPower(-0.6); backRight.setPower(0);
    }

    @Override
    public void loop() {

        if (gamepad1.left_stick_y > 0.3) forward();
        // y stick direction, moving forward

        if (gamepad1.left_stick_y < -0.3) backward();
        //y stick direction, moving backwards

        if (gamepad1.left_stick_y < 0.3 && gamepad1.left_stick_y > -0.3) deadZone();
        //deadlock for control stick y between (0.3, 0.3) = no movement

        if (gamepad1.left_stick_x < 0.3 && gamepad1.left_stick_x > -0.3) deadZone();
        //deadlock for control stick x between (0.3, 0.3) = no movement

        if (gamepad1.left_stick_x < -0.3) straifeLeft();
        // strafe left robot left wheels both go inward

        if(gamepad1.left_stick_x > 0.3) straifeRight();
        // strafe right robot right wheels both go inward

        if (gamepad1.right_bumper) turnRight();
        //left wheels forward, right wheels backward

        if (gamepad1.left_bumper) turnLeft();
        //right wheels forward, left wheels backward

        if(gamepad1.left_stick_y > 0.3 && gamepad1.left_stick_x < -0.3) {
            diagonalUpLeft();
        }
        if(gamepad1.left_stick_y > 0.3 && gamepad1.left_stick_x > 0.3) {
            diagonalUpRight();
        }
        if(gamepad1.left_stick_y < -0.3 && gamepad1.left_stick_x < -0.3) {
            diagonalBackLeft();
        }
        if(gamepad1.left_stick_y < -0.3 && gamepad1.left_stick_x > 0.3) {
            diagonalBackRight();
        }
    } //init
} // op mode

