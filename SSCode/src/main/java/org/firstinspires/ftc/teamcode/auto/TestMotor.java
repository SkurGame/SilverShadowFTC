package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Config;

@Autonomous(name = "test_motor", group = "Concept")
public class TestMotor extends LinearOpMode {

    @Override
    public void runOpMode() {
        DcMotor myMotor = null;
        myMotor = hardwareMap.get(DcMotor.class, "myMotor");
        myMotor.setDirection(DcMotor.Direction.FORWARD);
        myMotor.setPower(0);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            myMotor.setPower(Config.motor.boost);

            telemetry.addData("Status", "Running");
            telemetry.addData("Motor Power", "%.2f", myMotor.getPower());
            telemetry.update();
        }

        myMotor.setPower(0);
        telemetry.addData("Status", "Stopped");
        telemetry.update();
    }
}