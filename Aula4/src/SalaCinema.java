public class SalaCinema {
	int lotacao;
	int bilhetesVendidos;
	String nomeFilme;

	public SalaCinema(int lotacao, String nomeFilme) {
		this.lotacao = lotacao;
		this.nomeFilme = nomeFilme;
		this.bilhetesVendidos = 0;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public int getBilhetesDisponiveis() {
		return lotacao - bilhetesVendidos;
	}

	public synchronized int venderBilhete() {
		int bilhetes = getBilhetesDisponiveis();
		if (bilhetes > 0) {
			bilhetesVendidos++;
			return bilhetesVendidos;
		}
		return -1;
	}
}