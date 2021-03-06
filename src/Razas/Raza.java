package Razas;

public abstract class Raza {

	protected boolean envenenado;
	protected boolean muerto;
	protected double salud;
	protected Punto posicion;
	protected double danoAtaque;
	protected static int turno = 0;
	protected int turnoVeneno;

	public Raza(int salud, Punto posicion, int danoAtaque) {
		this.salud = salud;
		this.posicion = posicion;
		this.danoAtaque = danoAtaque;
		envenenado = false;
		muerto = true;
	}

	public static int getTurno() {
		return turno;
	}

	public static void setTurno(int turno) {
		Raza.turno = turno;
	}

	public void descansar() {
		aumentarTurno();
	}

	public void atacar(Raza otro) {
		aumentarTurno();
	}

	public void recibirAtaque(double dano) {
		if (salud - dano <= 0) {
			salud = 0;
			muerto = true;
		} else
			salud -= dano;
	}

	private void aumentarTurno() {
		if (envenenado)
			recibirAtaque(3);
		turno++;
		if (turno - turnoVeneno > 3)
			envenenado = false;
	}

}