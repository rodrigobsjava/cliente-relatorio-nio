package main.java.com.rodrigobsjava.cliente;

import java.util.List;

import main.java.com.rodrigobsjava.cliente.model.Cliente;
import main.java.com.rodrigobsjava.cliente.service.ClienteService;

public class ClienteMain {

	public static void main(String[] args) {
		ClienteService clienteService = new ClienteService();

		//	Define os caminhos dos arquivos de entrada (CSV) e saída (TXT)
		String caminhoArquivoCSV = "src/main/resources/clientes.csv";
		String caminhoRelatorio = "src/main/resources/relatorio-clientes.txt";
		
		List<Cliente> clientes = clienteService.lerClientesDeCSV(caminhoArquivoCSV); // Lê os clientes do arquivo .csv
		clienteService.gerarRelatorio(clientes, caminhoRelatorio); // Gera o relatório com os dados lidos
	}

}
