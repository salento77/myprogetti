package gestione.biblioteca.servizi;

public class ServizioRiparazione implements Servizio{

	@Override
	public String ricezioneInoltro(Inoltro<?> inoltrato) {
		return "Servizio riparazione.\nRicevuto: "+inoltrato.stampaScheda();
	}

}
