package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name = "HoratioAiAutonomous")

public class HoratioAiAutonomous extends LinearOpMode
{
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor frontLeft;
    private DcMotor frontRight;

    @Override
    public void runOpMode()
    {
        waitForStart();
        backLeft   = hardwareMap.get(DcMotor.class, "backLeft");
        backRight  = hardwareMap.get(DcMotor.class, "backRight");
        frontLeft  = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");

        backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        backLeft.setDirection(DcMotor.Direction.REVERSE);
        frontLeft.setDirection(DcMotor.Direction.REVERSE);

        backLeft.setPower(0.6);
        backRight.setPower(0.6);
        frontLeft.setPower(0.6);
        frontRight.setPower(0.6);

        moveForward(2000);
        moveBackward(2000);
        moveLeft(2000);
        moveRight(2000);
    }

    public void runWheels()
    {
        while (frontRight.getCurrentPosition() != frontRight.getTargetPosition())
        {
            frontRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            frontLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            backLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
    }

    public void reset() {
        frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void moveForward(int distance)
    {
        reset();
        backLeft.setTargetPosition(distance);
        backRight.setTargetPosition(distance);
        frontLeft.setTargetPosition(distance);
        frontRight.setTargetPosition(distance);
        runWheels();
    }

    public void moveBackward(int distance)
    {
        reset();
        backLeft.setTargetPosition(-distance);
        backRight.setTargetPosition(-distance);
        frontLeft.setTargetPosition(-distance);
        frontRight.setTargetPosition(-distance);
        runWheels();
    }

    public void moveLeft(int distance)
    {
        reset();
        backLeft.setTargetPosition(distance);
        backRight.setTargetPosition(-distance);
        frontLeft.setTargetPosition(-distance);
        frontRight.setTargetPosition(distance);
        runWheels();
    }

    public void moveRight(int distance)
    {
        reset();
        backLeft.setTargetPosition(-distance);
        backRight.setTargetPosition(distance);
        frontLeft.setTargetPosition(distance);
        frontRight.setTargetPosition(-distance);
        runWheels();
    }
}
