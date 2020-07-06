package entidades;

public class PessoaFisica extends Usuario {

	private Double gastoSaude;

	public PessoaFisica() {

	}

	public PessoaFisica(String nome, Double rendaAnual, Double gastoSaude) {
		super(nome, rendaAnual);
		this.gastoSaude = gastoSaude;
	}

	public Double getGastoSaude() {
		return gastoSaude;
	}

	public void setGastoSaude(Double gastoSaude) {
		this.gastoSaude = gastoSaude;
	}

	@Override
	public double imposto() {

		if (getRendaAnual() < 20000.0) {/*pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. 
										Pessoas com renda de 20000.00 em diante pagam 25% de imposto.*/
			return getRendaAnual() * 0.15 - gastoSaude * 0.5;

		} else {
			return getRendaAnual() * 0.25 - gastoSaude * 0.5;

		}
	}

}
