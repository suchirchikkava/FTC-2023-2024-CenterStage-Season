package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="Testing")
public class Suchir extends OpMode{
    private DcMotor frontLeft;
    private DcMotor backLeft;
    private DcMotor frontRight;
    private DcMotor backRight;
    private DcMotor arm;
    private Servo airplane;
    private Servo claw;

    private double holdPlane = 0.0;
    private double launchPlane = 1.0;

    private double closeClaw = 0.0;
    private double openClaw = 1.0;

    public void init() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        arm = hardwareMap.get(DcMotor.class, "arm");
        airplane = hardwareMap.get(Servo.class, "hook");
        claw = hardwareMap.get(Servo.class, "claw");

        frontLeft.setDirection(DcMotor.Direction.FORWARD);
        frontRight.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.FORWARD);
        backRight.setDirection(DcMotor.Direction.REVERSE);
    }
    @Override
    public void loop() {

        moveBot();
        plane();
        moveClaw();
        moveArm();
    }

    public void moveBot() {
        if (gamepad1.left_stick_y > 0.3) {
            frontLeft.setPower(0.5);
            backLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backRight.setPower(0.5);
        }

        if (gamepad1.left_stick_y < -0.3) {
            frontLeft.setPower(-0.5);
            backLeft.setPower(-0.5);
            frontRight.setPower(-0.5);
            backRight.setPower(-0.5);
        }

        if (0.3 > gamepad1.left_stick_y && gamepad1.left_stick_y > -0.3) {
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }

        if (gamepad1.left_stick_x < -0.3) {
            frontLeft.setPower(0.5);
            backLeft.setPower(-0.5);
            frontRight.setPower(-0.5);
            backRight.setPower(0.5);
        }
        if (gamepad1.left_stick_x > 0.3) {
            frontLeft.setPower(-0.5);
            backLeft.setPower(0.5);
            frontRight.setPower(0.5);
            backRight.setPower(-0.5);
        }
        if (0.3 > gamepad1.left_stick_x && gamepad1.left_stick_x > -0.3) {
            frontLeft.setPower(0);
            backLeft.setPower(0);
            frontRight.setPower(0);
            backRight.setPower(0);
        }
    }

    public void plane() {
        if (gamepad1.a) {
            airplane.setPosition(holdPlane);
        }//holds airplane

        if (gamepad1.b) {
            airplane.setPosition(launchPlane);
        }//lets airplane go
    }

    public void moveClaw() {
        if (gamepad1.x) {
            claw.setPosition(closeClaw);
        }

        if (gamepad2.y) {
            claw.setPosition(openClaw);
        }
    }

    public void moveArm() {
        if (gamepad1.right_stick_y > 0.3) {
            arm.setPower(0.5);
        }

        if (gamepad1.right_stick_y < -0.3) {
            arm.setPower(-0.5);
        }

        if (gamepad1.right_stick_y > -0.3 && gamepad1.right_stick_y < 0.3) {
            arm.setPower(0.0);
        }
    }
}



