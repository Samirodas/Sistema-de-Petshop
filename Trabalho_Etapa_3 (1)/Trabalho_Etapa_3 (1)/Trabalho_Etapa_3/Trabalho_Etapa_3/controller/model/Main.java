package model;
import java.sql.Connection;
import java.sql.SQLException;

import controller.AnimalController;
import controller.HistoricoServicoController;
import controller.ProprietarioController;
import controller.ServicoController;
import dao.AnimalDAO;
import dao.AnimalDAOImpl;
import dao.ConexaoSQL;
import dao.HistoricoServicoDAO;
import dao.HistoricoServicoDAOImpl;
import dao.ProprietarioDAO;
import dao.ProprietarioDAOImpl;
import dao.ServicoDAO;
import dao.ServicoDAOImpl;
import relatorio.RelatorioGenerator;
import view.AnimalView;
import view.HistoricoServicoView;
import view.ProprietarioView;
import view.ServicoView;

public class Main {
	public static void main(String[] args) {
		Connection connection = null;

		try {
			// Estabelecer conexão com o banco de dados
			connection = ConexaoSQL.getConnection();
			System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

			// Instanciar os DAOs
			AnimalDAO animalDAO = new AnimalDAOImpl(connection);
			ProprietarioDAO proprietarioDAO = new ProprietarioDAOImpl(connection);
			ServicoDAO servicoDAO = new ServicoDAOImpl(connection);
			HistoricoServicoDAO historicoServicoDAO = new HistoricoServicoDAOImpl(connection);

			// Instanciar os controllers
			AnimalController animalController = new AnimalController(animalDAO);
			ProprietarioController proprietarioController = new ProprietarioController(proprietarioDAO);
			ServicoController servicoController = new ServicoController(servicoDAO);
			HistoricoServicoController historicoServicoController = new HistoricoServicoController(historicoServicoDAO);

			// Instanciar as views
			AnimalView animalView = new AnimalView(animalController);
			ProprietarioView proprietarioView = new ProprietarioView(proprietarioController);
			ServicoView servicoView = new ServicoView(servicoController);
			HistoricoServicoView historicoServicoView = new HistoricoServicoView(historicoServicoController);

			// Gerar relatório de animais
			String filePath = "C:\\Users\\Rafael Ribeiro\\Desktop\\Trabalho_Etapa_3\\relatorio\\relatorio_animais.pdf";
			RelatorioGenerator.gerarRelatorioAnimais(connection, filePath);

			// Esperar até que as janelas das views sejam fechadas
			
		} catch (SQLException e) {
			System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
		} finally {
			// Fechar a conexão com o banco de dados quando o programa terminar
			try {
				if (connection != null && !connection.isClosed()) {
					connection.close();
					System.out.println("Conexão com o banco de dados fechada com sucesso!");
				}
			} catch (SQLException e) {
				System.err.println("Erro ao fechar a conexão com o banco de dados: " + e.getMessage());
			}
		}
	}
}
