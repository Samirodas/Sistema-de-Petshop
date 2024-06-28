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

import controller.ProprietarioController;
import model.Proprietario;

public class ProprietarioView {
    private ProprietarioController proprietarioController;

    private JFrame frame;
    private JTextField nomeField;
    private JTextField enderecoField;
    private JTextField telefoneField;
    private JTextField emailField;
    private JButton addButton;
    private JButton listButton;
    private JTextArea listArea;

    public ProprietarioView(ProprietarioController proprietarioController) {
        this.proprietarioController = proprietarioController;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }

    private void initialize() {
        frame = new JFrame("Proprietário Management");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 80, 25);
        frame.getContentPane().add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(100, 10, 160, 25);
        frame.getContentPane().add(nomeField);

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoLabel.setBounds(10, 40, 80, 25);
        frame.getContentPane().add(enderecoLabel);

        enderecoField = new JTextField();
        enderecoField.setBounds(100, 40, 160, 25);
        frame.getContentPane().add(enderecoField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(10, 70, 80, 25);
        frame.getContentPane().add(telefoneLabel);

        telefoneField = new JTextField();
        telefoneField.setBounds(100, 70, 160, 25);
        frame.getContentPane().add(telefoneField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 100, 80, 25);
        frame.getContentPane().add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 100, 160, 25);
        frame.getContentPane().add(emailField);

        addButton = new JButton("Adicionar Proprietário");
        addButton.setBounds(10, 130, 160, 25);
        frame.getContentPane().add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProprietario();
            }
        });

        listButton = new JButton("Listar Proprietários");
        listButton.setBounds(180, 130, 160, 25);
        frame.getContentPane().add(listButton);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProprietarios();
            }
        });

        listArea = new JTextArea();
        listArea.setBounds(10, 160, 330, 120);
        frame.getContentPane().add(listArea);

        frame.setVisible(true);
    }

    private void adicionarProprietario() {
        String nome = nomeField.getText();
        String endereco = enderecoField.getText();
        String telefone = telefoneField.getText();
        String email = emailField.getText();

        Proprietario proprietario = new Proprietario();
        proprietario.setNome(nome);
        proprietario.setEndereco(endereco);
        proprietario.setTelefone(telefone);
        proprietario.setEmail(email);

        proprietarioController.adicionarProprietario(proprietario);
        JOptionPane.showMessageDialog(frame, "Proprietário adicionado com sucesso!");
    }

    private void listarProprietarios() {
        List<Proprietario> proprietarios = proprietarioController.listarProprietarios();
        StringBuilder builder = new StringBuilder();
        for (Proprietario proprietario : proprietarios) {
            builder.append(proprietario.toString()).append("\n");
        }
        listArea.setText(builder.toString());
    }
}
