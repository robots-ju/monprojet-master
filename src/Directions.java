import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;

public class Directions {

	public void direction(EV3LargeRegulatedMotor moteurDroit, EV3LargeRegulatedMotor moteurGauche,
			float[] valeurCouleur, EV3MediumRegulatedMotor bras) {

		LCD.clear();
		if (valeurCouleur[1] >= valeurCouleur[0] - 0.05 && valeurCouleur[1] <= valeurCouleur[0] + 0.05) {

			LCD.clear();
			LCD.drawString("je vais a droite",0,1);
			moteurGauche.setSpeed(50);
			
			moteurGauche.rotate(120);
			
			bras.rotate(-90);
			
			moteurGauche.rotate(120);
			
			bras.rotate(90);

			moteurGauche.rotate(-120);
			

		} else {
			LCD.clear();
			LCD.drawString("je vais a gauche",0,1);

			moteurGauche.setSpeed(50);			
			moteurDroit.setSpeed(50);
			
			moteurDroit.rotate(120);
			
			bras.rotate(-90);
			
			moteurDroit.rotate(180, true);
			moteurGauche.rotate(-180);
			
			moteurDroit.rotate(120);
			
			bras.rotate(90);
			
			moteurDroit.rotate(-120);
			
		}
		Button.waitForAnyPress();
	}

}
