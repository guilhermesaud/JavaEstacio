import javax.swing.JOptionPane;

public class Principal {
	
	static final int QTEREGISTROS = 10;
	static int x=1, qntclie=0;
	
	public static String id[] = new String[QTEREGISTROS];
	public static String nome[] = new String[QTEREGISTROS];
	public static String email[] = new String[QTEREGISTROS];
	public static String cidade[] = new String[QTEREGISTROS];
	public static String uf[] = new String[QTEREGISTROS];
	

	public static void main(String[] args){
		
		for (int i=0; i<QTEREGISTROS;i++){
			id[i]=String.valueOf(i);
		}
		
		String op = "";
		
		while (!op.equals("6")) {
			op = entraTexto("Menu\n\n"+
							"1 - Cadastrar \n" +
							"2 - Consultar \n" +
							"3 - Atualizar Email \n" +
							"4 - Excluir \n" +
							"5 - Listar Clientes \n" +
							"6 - Sair \n"
							);
		
			
				switch (op) {
				case "1": cadastroCliente();
				break;
				case "2": consultaCliente();
				break;
				case "3": atualizaEmailCliente();
				break;
				case "4": excluirCliente();
				break;
				case "5": listaCliente();
				break;
				case "6": close();
				break;
				
				default:
					retornoTexto("Por favor, digite uma opção válida de 1 a 6!");
				}
		}

	}
	
	private static void cadastroCliente() {
		if (!cheio()){
			nome[x] = entraTexto("\nDigite o nome do cliente: ");
			
			if (nome[x]!=null || !(nome[x].isEmpty())) {
				email[x] = entraTexto("\nDigite o E-mail: ");
				cidade[x] = entraTexto("\nDigite a Cidade: ");
				uf[x] = entraTexto("\nDigite a UF: ");
				
				retornoTexto("\nCliente cadastrado!\nID do cliente: " + id[x]);
				x++;
				qntclie++;

			}else{
				retornoTexto("Digite um nome para o cliente");
			}
		}else{
			retornoTexto("\nQuantidade de cadastro de clientes excedido!");
		}
	}

	
	public static void atualizaEmailCliente() {
		int cliente = 0;
		String novoEmail;
		
		if(!vazio()){
			cliente = Integer.parseInt(entraTexto("Digite o ID do cliente que deseja atualizar o E-mail: "));
			try{
				if (nome[cliente]!=null || !(nome[x].isEmpty())){
					retornoTexto("O cliente " + nome[cliente] +
								 " está cadastrado com o E-mail " + email[cliente]);
					
					novoEmail = entraTexto("Digite o novo E-mail para o cliente: ");
					
					if (novoEmail!=null){
						email[cliente] = novoEmail;
						retornoTexto("E-mail atualizado!");
					}else{
						retornoTexto("Digite um novo E-mail válido");
					}
				}else{
					retornoTexto("ID do cliente ainda não cadastrado!");
				}
			}catch(Exception ex){
				retornoTexto("ID do cliente não foi encontrado!");
			}
		}else{
			retornoTexto("Nenhum cliente cadastrado!");
		}
	}
		
	
	public static void excluirCliente() {
		int cliente = 0;
		
		if(!vazio()){
			cliente = Integer.parseInt(entraTexto("Digite o ID do cliente que deseja excluir: "));
			try{
				if(nome[cliente]!=null || !(nome[x].isEmpty())){
					retornoTexto("Cliente abaixo foi excluido com sucesso!\n" +
								 "\nNome: " + nome[cliente] +
								 "\nEmail: " + email[cliente] +
								 "\nCidade: " + cidade[cliente] +
								 "\nUF: " + uf[cliente]);
						
						nome[cliente] = null;
						email[cliente] = null;
						cidade[cliente] = null;
						uf[cliente] = null;	
						qntclie--;
				}else{
					retornoTexto("ID do cliente ainda não cadastrado!");
				}
			}catch(Exception ex){
				retornoTexto("ID do cliente não foi encontrado!");	
			}
		}else{
			retornoTexto("Nenhum cliente cadastrado!");
		}
	}
	
	
	private static void consultaCliente() {
		int cliente = 0;
	
		if(!vazio()) {
			cliente = Integer.parseInt(
			entraTexto("Digite o ID do cliente que deseja consultar:"));
			try{
				if(nome[cliente]!=null || !(nome[x].isEmpty())){
						retornoTexto("Cliente:\n" +
									 "\nNome: " + nome[cliente] +
									 "\nEmail: " + email[cliente] +
									 "\nCidade: " + cidade[cliente] +
									 "\nUF: " + uf[cliente]);
				}else{
					retornoTexto("ID do cliente ainda não cadastrado!");
				}
			}catch(Exception ex){
				retornoTexto("ID do cliente não foi encontrado!");	
			}
		}else{
			retornoTexto("Nenhum cliente cadastrado!");
		}
	}

	
	public static void listaCliente() {
		
		if (!vazio()){
			for (int i=1;i<x;i++){
				retornoTexto("\nID: " + id[i] + "\nNome: " + nome[i] + "\n");
			}
		}else{
			retornoTexto("Nenhum cliente cadastrado!");
		}
	}

	
	
	
	
	
	
	public static void close() {
		System.exit(0);
	}
	
	public static boolean cheio() {

		return (qntclie==QTEREGISTROS);
	}
	
	public static boolean vazio() {

		return (qntclie==0);
	}
	
	public static void retornoTexto (String texto) {
		JOptionPane.showMessageDialog(null, texto);
		
	}
	
	public static String entraTexto (String texto) {
		return JOptionPane.showInputDialog(texto);
		
	}

}
