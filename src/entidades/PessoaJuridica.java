package entidades;

public class PessoaJuridica extends Usuario {

	private int funcionarios;

	PessoaJuridica() {

	}

	public PessoaJuridica(String nome, Double rendaAnual, int funcionarios) {
		super(nome, rendaAnual);
		this.funcionarios = funcionarios;
	}

	public int getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(int funcionarios) {
		this.funcionarios = funcionarios;
	}

	@Override
	public double imposto() {
		if (getRendaAnual() > 10) {/*pessoas jur�dicas pagam 16% de imposto. Por�m, 
									se a empresa possuir mais de 10 funcion�rios, ela paga 14% de imposto*/
			return getRendaAnual() * 0.14;

		} else {
			return getRendaAnual() * 0.16;

		}
	}

}
