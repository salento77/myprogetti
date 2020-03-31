package gestione.biblioteca.prestito;

import gestione.biblioteca.prestito.base.Opera;
import gestione.biblioteca.prestito.base.OperaPrestabile;
import gestione.biblioteca.prestito.eccezioni.PrestitoNonEseguibile;

public class Studente{
	
	private String nome;
	private String cognome;
	
	private OperaPrestabile prestito1;
	private OperaPrestabile prestito2;
	
	public Studente(String nome, String cognome)
	{
		this.nome=nome;
		this.cognome=cognome;
	}
	
	protected void creaPrestito(OperaPrestabile daPrendere)throws
	PrestitoNonEseguibile
	{
		if (!prestitiDisponibili())
			throw new PrestitoNonEseguibile(daPrendere);
		if (prestito1==null)
			prestito1=daPrendere;
		else
			prestito2=daPrendere;
	}
	
	protected boolean restituzionePrestito(Opera daRestituire)
	{
		if (prestito1==daRestituire)
			prestito1=null;
		else if (prestito2==daRestituire)
			prestito2=null;
		else
			return false;
		return true;
	}
	
	protected boolean prestitiDisponibili()
	{
		return numeroPrestiti()<2;
	}
	
	private byte numeroPrestiti()
	{
		byte prestiti=0;
		if (prestito1!=null)
			prestiti++;
		if (prestito2!=null)
			prestiti++;
		return prestiti;
	}
	
	public String getNominativo()
	{
		return nome+" "+cognome;
	}
	
	@Override
	public String toString() {
		switch(numeroPrestiti())
		{
			case 0:
				return getNominativo()+" non ha Opere in prestito";
				
			case 1: //un libro in prestito
				return getNominativo()+" ha una sola Opera in prestito: "+prestito1.getTitolo();
				
			default: // l'unica alternativa è avere due libri in prestito
				return getNominativo()+" ha due Opere in prestito: "+prestito1.getTitolo()+", "+prestito2.getTitolo();
		}
	}

}
