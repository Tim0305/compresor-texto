package gui;

import lz77.Lz77Compresor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CompresorTextoGUI extends JFrame {

    private int width;
    private int height;
    private JTextArea plainTextArea;
    private JTextArea compressedTextArea;
    private JFrame ventanaPrincipal;

    public CompresorTextoGUI() {
        super();
        ventanaPrincipal = null;
        width = 500;
        height = width;

        plainTextArea = new JTextArea();
        compressedTextArea = new JTextArea();

        /*Configuraciones*/
        init();
    }

    public CompresorTextoGUI(JFrame ventanaPrincipal) {
        this();
        this.ventanaPrincipal = ventanaPrincipal;
    }

    private void init() {

        //Ventana
        setTitle("Compresor Texto");
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (ventanaPrincipal != null) {
                    // Si hay una ventana principal terminar esta ventana y abrir la principal
                    setVisible(false);
                    ventanaPrincipal.setVisible(true);
                }
                else
                    System.exit(0); // Terminar el programa si no hay una ventana principal
            }
        });

        // Label
        JLabel titulo = new JLabel("Compresor Texto", SwingConstants.CENTER);
        titulo.setBounds(0, 20, width, 30);
        add(titulo);

        // PlainText
        JScrollPane scrollPanePlainTextArea = new JScrollPane(plainTextArea);
        scrollPanePlainTextArea.setBounds(50,80,400,100);
        add(scrollPanePlainTextArea);

        // Button Comprimir
        JButton cmdComprimirTexto = new JButton("Comprimir");
        cmdComprimirTexto.setBounds(20, 210, 200, 30);
        cmdComprimirTexto.addActionListener((e) -> onClickComprimirTexto());
        cmdComprimirTexto.setBackground(new Color(0, 150, 0));
        cmdComprimirTexto.setForeground(Color.white);
        cmdComprimirTexto.setFocusable(false);
        add(cmdComprimirTexto);

        // Button Descomprimir
        JButton cmdDescomprimirTexto = new JButton("Descomprimir");
        cmdDescomprimirTexto.setBounds(260, 210, 200, 30);
        cmdDescomprimirTexto.addActionListener((e) -> onClickDescomprimirTexto());
        cmdDescomprimirTexto.setBackground(new Color(150, 0, 0));
        cmdDescomprimirTexto.setForeground(Color.white);
        cmdDescomprimirTexto.setFocusable(false);
        add(cmdDescomprimirTexto);

        // CompressedText
        JScrollPane scrollPaneCompressedTextArea = new JScrollPane(compressedTextArea);
        scrollPaneCompressedTextArea.setBounds(50,270,400,100);
        add(scrollPaneCompressedTextArea);
    }

    private void onClickComprimirTexto() {
        String plainText = plainTextArea.getText();
        compressedTextArea.setText(Lz77Compresor.comprimir(plainText));
    }

    private void onClickDescomprimirTexto() {
        String compressedText = compressedTextArea.getText();
        plainTextArea.setText(Lz77Compresor.descomprimir(compressedText));
    }
}
