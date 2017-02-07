package es.urjc.code.dad;

public class Palmares {
	
	private long id;
	private Torneo torneo;
	private int numTorneoGanados;
	
	public Palmares(){
		id = 0;
	}

	public Palmares(Torneo torneo, int numTorneoGanados) {
		this.torneo = torneo;
		this.numTorneoGanados = numTorneoGanados;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public int getNumTorneoGanados() {
		return numTorneoGanados;
	}

	public void setNumTorneoGanados(int numTorneoGanados) {
		this.numTorneoGanados = numTorneoGanados;
	}
	
	
}
