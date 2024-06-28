package relatorio;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.text.Document;

public class RelatorioGenerator {

    public static void gerarRelatorioAnimais(Connection connection, String filePath) {
        Document document = new Document();

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filePath));
            document.open();

            Paragraph title = new Paragraph("Relatório de Animais\n\n");
            document.add(title);

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Animal");
            while (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String especie = resultSet.getString("especie");
                String raca = resultSet.getString("raca");
                int idade = resultSet.getInt("idade");

                Paragraph animalInfo = new Paragraph("Nome: " + nome + ", Espécie: " + especie + ", Raça: " + raca + ", Idade: " + idade + "\n");
                document.add(animalInfo);
            }

            document.close();
            System.out.println("Relatório de animais gerado com sucesso: " + filePath);
        } catch (DocumentException | SQLException e) {
            System.err.println("Erro ao gerar relatório de animais: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }
}
