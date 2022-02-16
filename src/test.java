import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.SensorMode;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LCD.drawString("je commence", 0, 7);
		Button.waitForAnyPress();
		EV3LargeRegulatedMotor moteurDroit = new EV3LargeRegulatedMotor(MotorPort.B);
		EV3LargeRegulatedMotor moteurGauche = new EV3LargeRegulatedMotor(MotorPort.C);
		
		moteurDroit.setSpeed(20);
		moteurGauche.setSpeed(20);

		// avance un peu pour être contre le bloc
		
		moteurDroit.rotate(80, true);
		moteurGauche.rotate(80);
		

		// recule un chouia pour détecter sa couleur
		
		moteurDroit.rotate(-30, true);
		moteurGauche.rotate(-30);
		
	}

}
