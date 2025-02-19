package modelo;

public class Pais {
	private String pais;
	private int W;
	private int D;
	private int L;
	private int GF;
	private int GA;
	private int GD;
	private int puntos;
	
	public Pais(String pais, int w, int d, int l, int gF, int gA, int gD, int puntos) {
		super();
		this.pais = pais;
		this.W = w;
		this.D = d;
		this.L = l;
		this.GF = gF;
		this.GA = gA;
		this.GD = gD;
		this.puntos = puntos;
	}

	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getW() {
		return W;
	}
	public void setW(int w) {
		W = w;
	}

	public int getD() {
		return D;
	}
	public void setD(int d) {
		D = d;
	}

	public int getL() {
		return L;
	}
	public void setL(int l) {
		L = l;
	}

	public int getGF() {
		return GF;
	}
	public void setGF(int gF) {
		GF = gF;
	}

	public int getGA() {
		return GA;
	}
	public void setGA(int gA) {
		GA = gA;
	}

	public int getGD() {
		return GD;
	}
	public void setGD(int gD) {
		GD = gD;
	}

	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
}