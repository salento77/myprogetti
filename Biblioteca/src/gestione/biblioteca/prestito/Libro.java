package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.OperaPrestabile;

public class Libro extends OperaPrestabile {
	
	private int numeroPagine;
	public final static int MAX_SETTIMANE_PRESTITO=4;
	
	public Libro(String titolo, int numeroPagine)
	{
		super(titolo);
		this.numeroPagine=numeroPagine;
	}

	public int getNumeroPagine() {
		return numeroPagine;
	}

	@Override
	public String produciScheda() {
		return "Il libro "+titolo+" ("+numeroPagine+" pagine in totale) è concesso in prestito per "+MAX_SETTIMANE_PRESTITO+" settimane";
	}

	
}
