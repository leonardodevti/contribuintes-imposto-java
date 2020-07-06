package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidades.PessoaFisica;
import entidades.PessoaJuridica;
import entidades.Usuario;


/*Fazer um programa para ler os dados de N contribuintes (N fornecido pelo usuário), os quais
podem ser pessoa física ou pessoa jurídica, e depois mostrar o valor do imposto pago por cada um,
bem como o total de imposto arrecadado.
Os dados de pessoa física são: nome, renda anual e gastos com saúde. Os dados de pessoa jurídica
são nome, renda anual e número de funcionários. As regras para cálculo de imposto são as
seguintes:
Pessoa física: pessoas cuja renda foi abaixo de 20000.00 pagam 15% de imposto. Pessoas com
renda de 20000.00 em diante pagam 25% de imposto. Se a pessoa teve gastos com saúde, 50%
destes gastos são abatidos no imposto.
Exemplo: uma pessoa cuja renda foi 50000.00 e teve 2000.00 em gastos com saúde, o imposto
fica: (50000 * 25%) - (2000 * 50%) = 11500.00
Pessoa jurídica: pessoas jurídicas pagam 16% de imposto. Porém, se a empresa possuir mais de 10
funcionários, ela paga 14% de imposto.
Exemplo: uma empresa cuja renda foi 400000.00 e possui 25 funcionários, o imposto fica:
400000 * 14% = 56000.00
 * */

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner ent = new Scanner(System.in);

		List<Usuario> lista = new ArrayList<>();

		System.out.println("Informe a quantidade de contribuintes: ");
		int n = ent.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Contribuinte #" + i + "Dados:");
			System.out.print("Pessoa física ou jurídica (f/j)? ");
			char resp = ent.next().charAt(0);
			System.out.print("Nome: ");
			ent.nextLine();
			String nome = ent.nextLine();
			System.out.print("Renda anual: ");
			//Estrutura de decisão para preencher os dados de pessoa física ou pessoa jurídica.  
			double rendaAnual = ent.nextDouble();
			if (resp == 'f') {
				System.out.println("Despesas médicas: ");
				double gastoSaude = ent.nextDouble();
				lista.add(new PessoaFisica(nome, rendaAnual, gastoSaude));
			} else {
				System.out.println("Funcionários: ");
				int funcionarios = ent.nextInt();
				lista.add(new PessoaJuridica(nome, rendaAnual, funcionarios));
			}

		}
		double soma = 0.0;
		System.out.println();//Imprimindo o imposto cobrado de cada pessoa ou empresa.
		System.out.println("contribuição: ");
		for (Usuario usuario : lista) {
			double imposto = usuario.imposto();
			System.out.println(usuario.getNome() + ": R$ " + String.format("%.2f", imposto));
			soma += imposto;

		}

		System.out.println();//Imprimindo o imposto total cobrado de todas as pessoas e empresas.
		System.out.println("Total de Impostos: R$" + String.format("%.2f", soma));

		ent.close();
	}

}
