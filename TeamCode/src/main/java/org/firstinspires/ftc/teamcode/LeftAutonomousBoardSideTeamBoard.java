package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;

public class LeftAutonomousBoardSideTeamBoard extends HoratioAiAutonomous
{
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor frontLeft;
    private DcMotor frontRight;
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

        doShit();
    }

    public void doShit() //Front wheels facing East relative to game board
    {
        moveForward();//moves forward to marks so we can scan for prop
        //scan mark prependicuar to board
        sleep(1000);
        turnLeft();
        //scan mark closest to board, do scanning board shit
        sleep(1000);
        moveForward();//move to the board and prep for tetris
        sleep(1000);
        //doboardshit
        moveRight();//get out of the way of the board for teamates
        sleep(1000);
        moveForward();//park right of board
        sleep(1000);
    }
}
