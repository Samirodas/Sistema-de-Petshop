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

import controller.AnimalController;
import model.Animal;

public class AnimalView {
    private AnimalController animalController;

    private JFrame frame;
    private JTextField nomeField;
    private JTextField especieField;
    private JTextField racaField;
    private JTextField idadeField;
    private JTextField sexoField;
    private JTextField pesoField;
    private JButton addButton;
    private JButton listButton;
    private JTextArea listArea;

    public AnimalView(AnimalController animalController) {
        this.animalController = animalController;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setVisible(true);
    }
    
    private void initialize() {
        frame = new JFrame("Animal Management");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 80, 25);
        frame.getContentPane().add(nomeLabel);

        nomeField = new JTextField();
        nomeField.setBounds(100, 10, 160, 25);
        frame.getContentPane().add(nomeField);

        JLabel especieLabel = new JLabel("Espécie:");
        especieLabel.setBounds(10, 40, 80, 25);
        frame.getContentPane().add(especieLabel);

        especieField = new JTextField();
        especieField.setBounds(100, 40, 160, 25);
        frame.getContentPane().add(especieField);

        JLabel racaLabel = new JLabel("Raça:");
        racaLabel.setBounds(10, 70, 80, 25);
        frame.getContentPane().add(racaLabel);

        racaField = new JTextField();
        racaField.setBounds(100, 70, 160, 25);
        frame.getContentPane().add(racaField);

        JLabel idadeLabel = new JLabel("Idade:");
        idadeLabel.setBounds(10, 100, 80, 25);
        frame.getContentPane().add(idadeLabel);

        idadeField = new JTextField();
        idadeField.setBounds(100, 100, 160, 25);
        frame.getContentPane().add(idadeField);

        JLabel sexoLabel = new JLabel("Sexo:");
        sexoLabel.setBounds(10, 130, 80, 25);
        frame.getContentPane().add(sexoLabel);

        sexoField = new JTextField();
        sexoField.setBounds(100, 130, 160, 25);
        frame.getContentPane().add(sexoField);

        JLabel pesoLabel = new JLabel("Peso:");
        pesoLabel.setBounds(10, 160, 80, 25);
        frame.getContentPane().add(pesoLabel);

        pesoField = new JTextField();
        pesoField.setBounds(100, 160, 160, 25);
        frame.getContentPane().add(pesoField);

        addButton = new JButton("Adicionar Animal");
        addButton.setBounds(10, 190, 160, 25);
        frame.getContentPane().add(addButton);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarAnimal();
            }
        });

        listButton = new JButton("Listar Animais");
        listButton.setBounds(180, 190, 160, 25);
        frame.getContentPane().add(listButton);
        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarAnimais();
            }
        });

        listArea = new JTextArea();
        listArea.setBounds(10, 220, 330, 120);
        frame.getContentPane().add(listArea);

        frame.setVisible(true);
    }

    private void adicionarAnimal() {
        String nome = nomeField.getText();
        String especie = especieField.getText();
        String raca = racaField.getText();
        int idade = Integer.parseInt(idadeField.getText());
        String sexo = sexoField.getText();
        double peso = Double.parseDouble(pesoField.getText());

        Animal animal = new Animal();
        animal.setNome(nome);
        animal.setEspecie(especie);
        animal.setRaca(raca);
        animal.setIdade(idade);
        animal.setSexo(sexo);
        animal.setPeso(peso);

        animalController.adicionarAnimal(animal);
        JOptionPane.showMessageDialog(frame, "Animal adicionado com sucesso!");
    }

    private void listarAnimais() {
        List<Animal> animais = animalController.listarAnimais();
        StringBuilder builder = new StringBuilder();
        for (Animal animal : animais) {
            builder.append(animal.toString()).append("\n");
        }
        listArea.setText(builder.toString());
    }
}
