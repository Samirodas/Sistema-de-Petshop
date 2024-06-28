package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.ServicoController;
import model.Servico;

public class ServicoView {
    private ServicoController servicoController;

    private JFrame frame;
    private JTextField nomeField;
    private JTextField descricaoField;
    private JTextField precoField;
    private JButton addButton;
    private JButton listButton;
    private JTextArea listArea;

    public ServicoView(ServicoController servicoController) {
        this.servicoController = servicoController;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame("Serviço Management");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 80, 25);
        frame.getContentPane().add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(100, 10, 160, 25);
        frame.getContentPane().add(nomeField);

        JLabel descricaoLabel = new JLabel("Descrição:");
        descricaoLabel.setBounds(10, 40, 80, 25);
        frame.getContentPane().add(descricaoLabel);

        descricaoField = new JTextField();
        descricaoField.setBounds(100, 40, 160, 25);
        frame.getContentPane().add(descricaoField);

        JLabel precoLabel = new JLabel("Preço:");
        precoLabel.setBounds(10, 70, 80, 25);
        frame.getContentPane().add(precoLabel);

        precoField = new JTextField();
        precoField.setBounds(100, 70, 160, 25);
        frame.getContentPane().add(precoField);

        addButton = new JButton("Adicionar Serviço");
        addButton.setBounds(10, 100, 160, 25);
        frame.getContentPane().add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarServico();
            }
        });

        listButton = new JButton("Listar Serviços");
        listButton.setBounds(180, 100, 160, 25);
        frame.getContentPane().add(listButton);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarServicos();
            }
        });

        listArea = new JTextArea();
        listArea.setBounds(10, 130, 330, 120);
        frame.getContentPane().add(listArea);

        frame.setVisible(true);
    }

    private void adicionarServico() {
        String nome = nomeField.getText();
        String descricao = descricaoField.getText();
        double preco = Double.parseDouble(precoField.getText());

        Servico servico = new Servico();
        servico.setNome(nome);
        servico.setDescricao(descricao);
        servico.setPreco(preco);

        servicoController.adicionarServico(servico);
        JOptionPane.showMessageDialog(frame, "Serviço adicionado com sucesso!");
    }

    private void listarServicos() {
        List<Servico> servicos = servicoController.listarServicos();
        StringBuilder builder = new StringBuilder();
        for (Servico servico : servicos) {
            builder.append(servico.toString()).append("\n");
        }
        listArea.setText(builder.toString());
    }
}
