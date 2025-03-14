import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ToDoListApp extends JFrame {
    private JTextField taskField;
    private JList<String> taskList;
    private DefaultListModel<String> listModel;

    public ToDoListApp() {
        super("Lista de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Campo de texto e botão Adicionar
        taskField = new JTextField(20);
        JButton addButton = new JButton("Adicionar");

        JPanel inputPanel = new JPanel();
        inputPanel.add(taskField);
        inputPanel.add(addButton);
        add(inputPanel, BorderLayout.NORTH);

        // Lista de tarefas
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Botões Concluir e Remover
        JButton completeButton = new JButton("Concluir");
        JButton removeButton = new JButton("Remover");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(completeButton);
        buttonPanel.add(removeButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Listeners (a implementar)
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Adicionar tarefa ao listModel
                String task = taskField.getText();
                if (!task.isEmpty()) {
                    listModel.addElement(task);
                    taskField.setText("");
                }
            }
        });

        completeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Marcar tarefa como concluída
                listModel.setElementAt("[Concluída] " + listModel.getElementAt(taskList.getSelectedIndex()), taskList.getSelectedIndex());
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Remover tarefa selecionada
                listModel.remove(taskList.getSelectedIndex());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ToDoListApp();
            }
        });
    }
}