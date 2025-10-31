package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "teleop_test", group = "Concept")
public class TestTeleop extends LinearOpMode {
    private DcMotor leftUp, leftDown, rightUp, rightDown;

    public void runOpMode() {
        leftUp = hardwareMap.get(DcMotor.class, "leftUp");
        leftDown = hardwareMap.get(DcMotor.class, "leftDown");
        rightUp = hardwareMap.get(DcMotor.class, "rightUp");
        rightDown = hardwareMap.get(DcMotor.class, "rightDown");

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            double ly = gamepad1.left_stick_y;
            double lx = gamepad1.left_stick_x;
            boolean rb = gamepad1.right_bumper;

            double deadZone = 0.15;
            double power = 0.4;
            double boostPower = 0.3;

            if (Math.abs(ly) < deadZone) ly = 0;
            if (Math.abs(lx) < deadZone) lx = 0;

            leftUp.setPower(0);
            leftDown.setPower(0);
            rightUp.setPower(0);
            rightDown.setPower(0);

            // ПОВОРОТ
            if (gamepad1.left_trigger > 0.1) {
                if (rb) {
                    leftUp.setPower(-power - boostPower);
                    leftDown.setPower(-power - boostPower);
                    rightUp.setPower(power + boostPower);
                    rightDown.setPower(power + boostPower);
                } else {
                    leftUp.setPower(-power);
                    leftDown.setPower(-power);
                    rightUp.setPower(power);
                    rightDown.setPower(power);
                }
            }
            else if (gamepad1.right_trigger > 0.1) {
                if (rb) {
                    leftUp.setPower(power + boostPower);
                    leftDown.setPower(power + boostPower);
                    rightUp.setPower(-power - boostPower);
                    rightDown.setPower(-power - boostPower);
                } else {
                    leftUp.setPower(power);
                    leftDown.setPower(power);
                    rightUp.setPower(-power);
                    rightDown.setPower(-power);
                }
            }

            // ДВИЖЕНИЕ ВПЕРЕД
            else if (ly > 0 && Math.abs(lx) < 0.4) {
                if (rb) {
                    leftUp.setPower(power + boostPower);
                    leftDown.setPower(power + boostPower);
                    rightUp.setPower(power + boostPower);
                    rightDown.setPower(power + boostPower);
                } else {
                    leftUp.setPower(power);
                    leftDown.setPower(power);
                    rightUp.setPower(power);
                    rightDown.setPower(power);
                }
            }

            // ДВИЖЕНИЕ НАЗАД
            else if (ly < 0 && Math.abs(lx) < 0.4) {
                if (rb) {
                    leftUp.setPower(-power - boostPower);
                    leftDown.setPower(-power - boostPower);
                    rightUp.setPower(-power - boostPower);
                    rightDown.setPower(-power - boostPower);
                } else {
                    leftUp.setPower(-power);
                    leftDown.setPower(-power);
                    rightUp.setPower(-power);
                    rightDown.setPower(-power);
                }
            }

            // ДВИЖЕНИЕ ВПРАВО
            else if (lx > 0 && Math.abs(ly) < 0.4) {
                if (rb) {
                    leftUp.setPower(power + boostPower);
                    leftDown.setPower(-power - boostPower);
                    rightUp.setPower(-power - boostPower);
                    rightDown.setPower(power + boostPower);
                } else {
                    leftUp.setPower(power);
                    leftDown.setPower(-power);
                    rightUp.setPower(-power);
                    rightDown.setPower(power);
                }
            }

            // ДВИЖЕНИЕ ВЛЕВО
            else if (lx < 0 && Math.abs(ly) < 0.4) {
                if (rb) {
                    leftUp.setPower(-power - boostPower);
                    leftDown.setPower(power + boostPower);
                    rightUp.setPower(power + boostPower);
                    rightDown.setPower(-power - boostPower);
                } else {
                    leftUp.setPower(-power);
                    leftDown.setPower(power);
                    rightUp.setPower(power);
                    rightDown.setPower(-power);
                }
            }

            // ДИАГОНАЛЬ ВПЕРЕД-ВПРАВО
            else if (ly > 0 && lx > 0) {
                if (rb) {
                    leftUp.setPower(power + boostPower);
                    leftDown.setPower(0);
                    rightUp.setPower(0);
                    rightDown.setPower(power + boostPower);
                } else {
                    leftUp.setPower(power);
                    leftDown.setPower(0);
                    rightUp.setPower(0);
                    rightDown.setPower(power);
                }
            }

            // ДИАГОНАЛЬ ВПЕРЕД-ВЛЕВО
            else if (ly > 0 && lx < 0) {
                if (rb) {
                    leftUp.setPower(0);
                    leftDown.setPower(power + boostPower);
                    rightUp.setPower(power + boostPower);
                    rightDown.setPower(0);
                } else {
                    leftUp.setPower(0);
                    leftDown.setPower(power);
                    rightUp.setPower(power);
                    rightDown.setPower(0);
                }
            }

            // ДИАГОНАЛЬ НАЗАД-ВПРАВО
            else if (ly < 0 && lx > 0) {
                if (rb) {
                    leftUp.setPower(0);
                    leftDown.setPower(-power - boostPower);
                    rightUp.setPower(-power - boostPower);
                    rightDown.setPower(0);
                } else {
                    leftUp.setPower(0);
                    leftDown.setPower(-power);
                    rightUp.setPower(-power);
                    rightDown.setPower(0);
                }
            }

            // ДИАГОНАЛЬ НАЗАД-ВЛЕВО
            else if (ly < 0 && lx < 0) {
                if (rb) {
                    leftUp.setPower(-power - boostPower);
                    leftDown.setPower(0);
                    rightUp.setPower(0);
                    rightDown.setPower(-power - boostPower);
                } else {
                    leftUp.setPower(-power);
                    leftDown.setPower(0);
                    rightUp.setPower(0);
                    rightDown.setPower(-power);
                }
            }

            telemetry.addData("Left Y", "%.2f", ly);
            telemetry.addData("Left X", "%.2f", lx);
            telemetry.addData("LeftUp", "%.2f", leftUp.getPower());
            telemetry.addData("LeftDown", "%.2f", leftDown.getPower());
            telemetry.addData("RightUp", "%.2f", rightUp.getPower());
            telemetry.addData("RightDown", "%.2f", rightDown.getPower());
            telemetry.addData("Boost", rb ? "ON" : "OFF");
            telemetry.update();
        }
    }
}