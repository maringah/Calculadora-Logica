package athleticraceinterface;

/**
Nombre completo: Hugo Iván Marín Galicia
Fecha de elaboración: 22 de Junio de 2024
Nombre del Módulo: Topicos Avanzados de Programación
Nombre del Asesor: Andrés Espinal Jiménez
* 
* @author hugot
*/

// AthleticRaceInterface.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;

public class AthleticRaceInterface extends JFrame {
    private JTextField txtRegisterRunner;
    private JTextArea txtRegisteredRunners;
    private JTextArea txtResults;
    private Runner[] runners;
    private int runnerCount;

    // Constructor
    public AthleticRaceInterface() {
        setTitle("Carrera Atlética");
        setLayout(new BorderLayout());
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Inicializar componentes
        txtRegisterRunner = new JTextField(20);
        txtRegisteredRunners = new JTextArea(5, 20);
        txtResults = new JTextArea(10, 20);
        runners = new Runner[5];
        runnerCount = 0;

        initComponents();
    }

    // Método para inicializar componentes
    private void initComponents() {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        JLabel lblRegisterRunner = new JLabel("Registrar corredor:");
        JButton btnRegister = new JButton("Registrar");

        topPanel.add(lblRegisterRunner);
        topPanel.add(txtRegisterRunner);
        topPanel.add(btnRegister);

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new BorderLayout());
        middlePanel.add(new JLabel("Corredores registrados:"), BorderLayout.NORTH);
        middlePanel.add(new JScrollPane(txtRegisteredRunners), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1));
        JButton btnStart = new JButton("Iniciar");
        JButton btnRestart = new JButton("Reiniciar");
        JButton btnTerminate = new JButton("Terminar");
        
        buttonPanel.add(btnStart);
        buttonPanel.add(btnRestart);
        buttonPanel.add(btnTerminate);

        bottomPanel.add(new JLabel("Resultados:"), BorderLayout.NORTH);
        bottomPanel.add(new JScrollPane(txtResults), BorderLayout.CENTER);
        bottomPanel.add(buttonPanel, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Añadir listeners a los botones
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerRunner();
            }
        });

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startRace();
            }
        });

        btnRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                restartRace();
            }
        });

        btnTerminate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // Método para registrar un corredor
    private void registerRunner() {
        String runnerName = txtRegisterRunner.getText().trim();
        if (runnerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo de registro no puede estar vacío.");
            return;
        }

        if (runnerCount >= 5) {
            JOptionPane.showMessageDialog(this, "No se pueden registrar más de cinco corredores.");
            return;
        }

        runners[runnerCount] = new Runner(runnerName);
        txtRegisteredRunners.append((runnerCount + 1) + ". " + runnerName + ", registrado.\n");
        runnerCount++;
        txtRegisterRunner.setText("");
    }

    // Método para iniciar la carrera
    private void startRace() {
        if (runnerCount < 5) {
            JOptionPane.showMessageDialog(this, "Debes registrar cinco corredores antes de iniciar la carrera.");
            return;
        }

        txtResults.setText("La carrera ha dado inicio!....\n\n"); // Mensajee de inicio de carrera.

        for (Runner runner : runners) {
            Thread thread = new Thread(new RunnableRunner(runner, txtResults));
            thread.start();
        }
        
    }

    // Método para reiniciar la carrera
    private void restartRace() {
        runnerCount = 0;
        txtRegisteredRunners.setText("");
        txtResults.setText(""); // Limpiar resultados previos
    }

    // Método principal
    public static void main(String[] args) {
        try {
            Properties props = new Properties();
            props.put("logoString", "MiApp"); // Ejemplo de personalización adicional
            McWinLookAndFeel.setTheme(props);
            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AthleticRaceInterface().setVisible(true);
            }
        });
    }
}


