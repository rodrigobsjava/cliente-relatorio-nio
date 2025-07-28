package main.java.com.rodrigobsjava.cliente;

import java.util.List;

import main.java.com.rodrigobsjava.cliente.model.Cliente;
import main.java.com.rodrigobsjava.cliente.service.ClienteService;

public class ClienteMain {

	public static void main(String[] args) {
		ClienteService clienteService = new ClienteService();

		String caminhoArquivoCSV = "src/main/resources/clientes.csv";
		String caminhoRelatorio = "src/main/resources/relatorio-clientes.txt";
		
		List<Cliente> clientes = clienteService.lerClientesDeCSV(caminhoArquivoCSV);
		clienteService.gerarRelatorio(clientes, caminhoRelatorio);
	}

}
