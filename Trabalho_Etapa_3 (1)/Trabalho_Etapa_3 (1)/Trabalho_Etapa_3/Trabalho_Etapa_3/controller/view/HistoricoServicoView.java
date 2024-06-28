package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.HistoricoServicoController;
import model.Animal;
import model.HistoricoServico;
import model.Servico;

public class HistoricoServicoView {
    private HistoricoServicoController historicoServicoController;

    private JFrame frame;
    private JTextField animalIdField;
    private JTextField servicoIdField;
    private JTextField valorField;
    private JTextField observacoesField;
    private JButton addButton;
    private JButton listButton;
    private JTextArea listArea;

    public HistoricoServicoView(HistoricoServicoController historicoServicoController) {
        this.historicoServicoController = historicoServicoController;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame("Histórico de Serviços Management");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel animalIdLabel = new JLabel("Animal ID:");
        animalIdLabel.setBounds(10, 10, 80, 25);
        frame.getContentPane().add(animalIdLabel);

        animalIdField = new JTextField();
        animalIdField.setBounds(100, 10, 160, 25);
        frame.getContentPane().add(animalIdField);

        JLabel servicoIdLabel = new JLabel("Serviço ID:");
        servicoIdLabel.setBounds(10, 40, 80, 25);
        frame.getContentPane().add(servicoIdLabel);

        servicoIdField = new JTextField();
        servicoIdField.setBounds(100, 40, 160, 25);
        frame.getContentPane().add(servicoIdField);

        JLabel valorLabel = new JLabel("Valor:");
        valorLabel.setBounds(10, 70, 80, 25);
        frame.getContentPane().add(valorLabel);

        valorField = new JTextField();
        valorField.setBounds(100, 70, 160, 25);
        frame.getContentPane().add(valorField);

        JLabel observacoesLabel = new JLabel("Observações:");
        observacoesLabel.setBounds(10, 100, 80, 25);
        frame.getContentPane().add(observacoesLabel);

        observacoesField = new JTextField();
        observacoesField.setBounds(100, 100, 160, 25);
        frame.getContentPane().add(observacoesField);

        addButton = new JButton("Adicionar Histórico");
        addButton.setBounds(10, 130, 160, 25);
        frame.getContentPane().add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarHistoricoServico();
            }
        });

        listButton = new JButton("Listar Históricos");
        listButton.setBounds(180, 130, 160, 25);
        frame.getContentPane().add(listButton);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarHistoricoServicos();
            }
        });

        listArea = new JTextArea();
        listArea.setBounds(10, 160, 330, 120);
        frame.getContentPane().add(listArea);

        frame.setVisible(true);
    }

    private void adicionarHistoricoServico() {
        int animalId = Integer.parseInt(animalIdField.getText());
        int servicoId = Integer.parseInt(servicoIdField.getText());
        double valor = Double.parseDouble(valorField.getText());
        String observacoes = observacoesField.getText();
        Date data = new Date();

        HistoricoServico historicoServico = new HistoricoServico();
        historicoServico.setAnimal(new Animal(animalId)); // Assume Animal has a constructor with ID
        historicoServico.setServico(new Servico(servicoId)); // Assume Servico has a constructor with ID
        historicoServico.setValor(valor);
        historicoServico.setObservacoes(observacoes);
        historicoServico.setData(data);

        historicoServicoController.adicionarHistoricoServico(historicoServico);
        JOptionPane.showMessageDialog(frame, "Histórico de serviço adicionado com sucesso!");
    }

    private void listarHistoricoServicos() {
        List<HistoricoServico> historicos = historicoServicoController.listarHistoricoServicos();
        StringBuilder builder = new StringBuilder();
        for (HistoricoServico historico : historicos) {
            builder.append(historico.toString()).append("\n");
        }
        listArea.setText(builder.toString());
    }
}
