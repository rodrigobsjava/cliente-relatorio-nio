package com.rodrigobsjava.cliente.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.rodrigobsjava.cliente.model.Cliente;

public class ClienteService {
	public List<Cliente> lerClientesDeCSV(String caminhoArquivo) {
		List<Cliente> clientes = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(caminhoArquivo))) {
			String linha;
			boolean primeiraLinha = true;

			while ((linha = br.readLine()) != null) {
				if (primeiraLinha) {
					primeiraLinha = false;
					continue;
				}

				String[] campos = linha.split(",");
				String nome = campos[0];
				String email = campos[1];
				int idade = Integer.parseInt(campos[2]);

				clientes.add(new Cliente(nome, email, idade));
			}
		} catch (IOException e) {
			System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		}

		return clientes;
	}

	public void gerarRelatorio(List<Cliente> clientes, String caminhoSaida) {
		List<String> linhas = new ArrayList<>();
		linhas.add("RELATÓRIO DE CLIENTES:");
		linhas.add("Total: " + clientes.size());
		linhas.add("--------------------------------------");

		for (Cliente c : clientes) {
			linhas.add(c.formatado());
		}

		try {
			Files.write(Paths.get(caminhoSaida), linhas);
			System.out.println("Relatório gerado com sucesso!");
		} catch (IOException e) {
			System.err.println("Erro ao escrever o relatório: " + e.getMessage());
		}
	}
}
