package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.OperaPrestabile;

public class CD extends OperaPrestabile {
	
	private int numeroTracce;
	public final static int MAX_SETTIMANE_PRESTITO=1;
	
	public CD(String titolo, int numeroTracce)
	{
		super(titolo);
		this.numeroTracce=numeroTracce;
	}

	public int getNumeroTracce() {
		return numeroTracce;
	}

	@Override
	public String produciScheda() {
		return "Il CD "+titolo+" ("+numeroTracce+" tracce in totale) è concesso in prestito per "+MAX_SETTIMANE_PRESTITO+" settimane";
	}

}
