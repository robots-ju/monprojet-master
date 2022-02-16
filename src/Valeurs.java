import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.sensor.SensorMode;

public class Valeurs {


	public float[] valeurs(EV3LargeRegulatedMotor moteurDroit, EV3LargeRegulatedMotor moteurGauche,
			SensorMode capteurCouleur, float[] valeurCouleur) {
		
		// règle le capteur couleur


		
		moteurDroit.setSpeed(40);
		moteurGauche.setSpeed(40);
		
		// avance un peu pour être contre le bloc
		
		moteurDroit.rotate(60, true);
		moteurGauche.rotate(60);
		
		
		// recule un chouilla pour détecter sa couleur
		
		moteurDroit.rotate(-30, true);
		moteurGauche.rotate(-30);
		
		
		float[] sample = new float[capteurCouleur.sampleSize()];
		capteurCouleur.fetchSample(sample, 0);
		
		// si c'est le premier tour, on ajoute le bloc en tant que bloc de référence
		if (valeurCouleur[0] == 0) {
			valeurCouleur[0] = sample[0];
		}

		// on enregistre la valeur de test
		valeurCouleur[1] = sample[0];
		
		return valeurCouleur;
	}
}
