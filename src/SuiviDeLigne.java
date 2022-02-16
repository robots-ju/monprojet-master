import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.SensorMode;
import lejos.utility.Delay;

public class SuiviDeLigne {
	public void suiviDeLigne(EV3LargeRegulatedMotor moteurDroit, EV3LargeRegulatedMotor moteurGauche,
			SensorMode couleurLigne, SensorMode couleurBloc) {


		boolean sortDeLaBoucle = true;
		float[] sampleBloc = new float[couleurBloc.sampleSize()];
		float[] sampleLigne = new float[couleurBloc.sampleSize()];

		float moyenneLumiere = 0.35f;
		float correctionbla = 150f;
		float vitesse = 70;

		while (sortDeLaBoucle) {
			couleurLigne.fetchSample(sampleLigne, 0);
			LCD.clear();
			LCD.drawString(Float.toString(sampleLigne[0]), 0, 0);

			float positionligne = sampleLigne[0] - moyenneLumiere;
			float correction = positionligne * correctionbla;
			float vitessegauche = vitesse + correction;
			float vitessedroite = vitesse - correction;
			moteurDroit.setSpeed(vitessedroite);
			moteurGauche.setSpeed(vitessegauche);
			
			moteurDroit.forward();
			moteurGauche.forward();

			/// détecte le bloc
			couleurBloc.fetchSample(sampleBloc, 0);
			if (sampleBloc[0] >= 0.05) {
				sortDeLaBoucle = false;
			}
			LCD.drawString(Float.toString(sampleBloc[0]), 0, 1);
			Delay.msDelay(50);
		}
		
		
		moteurDroit.stop();
		moteurGauche.stop();
	}}
