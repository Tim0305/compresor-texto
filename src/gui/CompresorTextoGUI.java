package gui;

import lz77.Lz77Compresor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CompresorTextoGUI extends JFrame {

    private int width;
    private int height;
    private JTextArea plainTextArea;
    private JTextArea compressedTextArea;

    public CompresorTextoGUI() {
        super();

        width = 500;
        height = width;

        plainTextArea = new JTextArea();
        compressedTextArea = new JTextArea();

        /*Configuraciones*/
        init();
    }

    private void init() {

        //Ventana
        setTitle("Compresor Texto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

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
        cmdComprimirTexto.addActionListener((e) -> comprimirTexto());
        add(cmdComprimirTexto);

        // Button Descomprimir
        JButton cmdDescomprimirTexto = new JButton("Descomprimir");
        cmdDescomprimirTexto.setBounds(260, 210, 200, 30);
        cmdDescomprimirTexto.addActionListener((e) -> descomprimirTexto());
        add(cmdDescomprimirTexto);

        // CompressedText
        JScrollPane scrollPaneCompressedTextArea = new JScrollPane(compressedTextArea);
        scrollPaneCompressedTextArea.setBounds(50,270,400,100);
        add(scrollPaneCompressedTextArea);
    }

    private void comprimirTexto() {
        String plainText = plainTextArea.getText();
        compressedTextArea.setText(Lz77Compresor.comprimir(plainText));
    }

    private void descomprimirTexto() {
        String compressedText = compressedTextArea.getText();
        plainTextArea.setText(Lz77Compresor.descomprimir(compressedText));
    }
}
