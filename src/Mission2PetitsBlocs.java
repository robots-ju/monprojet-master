import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.motor.EV3MediumRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.SensorMode;

public class Mission2PetitsBlocs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EV3LargeRegulatedMotor moteurDroit = new EV3LargeRegulatedMotor(MotorPort.B);
		EV3LargeRegulatedMotor moteurGauche = new EV3LargeRegulatedMotor(MotorPort.C);
		SensorMode couleurLigne = new EV3ColorSensor(SensorPort.S3).getRedMode();
		SensorMode couleurBlocs = new EV3ColorSensor(SensorPort.S2).getRedMode();
		EV3MediumRegulatedMotor bras = new EV3MediumRegulatedMotor(MotorPort.A);
		
		int nbreBlocs = 0;
		
		float[] valeurCouleur = new float[2];
		
		SuiviDeLigne SuiviDeLigne = new SuiviDeLigne();
		Valeurs Valeurs = new Valeurs();
		Directions Direction = new Directions();
		
		do{
			
			SuiviDeLigne.suiviDeLigne(moteurDroit, moteurGauche, couleurLigne, couleurBlocs);
			
			valeurCouleur = Valeurs.valeurs(moteurDroit, moteurGauche, couleurBlocs, valeurCouleur);
			
			Direction.direction(moteurDroit, moteurGauche, valeurCouleur, bras);
			
			nbreBlocs ++;
			
		}while (nbreBlocs < 4);
		


	}

}
