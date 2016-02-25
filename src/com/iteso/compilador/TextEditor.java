package com.iteso.compilador;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Daniel on 24/02/2016.
 */
public class TextEditor extends JFrame implements OnButtonPressedListener{
    private JTextArea textArea;
    private EditTextMenuBar menuBar;
    public boolean isChanged;

    public TextEditor(){
        textArea = new JTextArea();
        menuBar  = new EditTextMenuBar(this);
        init();
    }

    private void init(){
        setBounds(200, 10, 1500, 1000);
        setTitle("Ñ~~");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(textArea);
        setJMenuBar(menuBar);
    }

    @Override
    public void onOpenFile(Scanner scanner) {
        textArea.setText("");
        String code = "";
        while(scanner.hasNext()){
            code += (scanner.nextLine() + "\n");
        }
        textArea.append(code);
    }

    @Override
    public void onSaveFile(BufferedWriter out) throws IOException {
        out.write(textArea.getText());
        out.close();
    }

    @Override
    public void onCutText() {
        textArea.cut();
    }

    @Override
    public void onCopyText() {
        textArea.copy();
    }

    @Override
    public void onPasteText() {
        textArea.paste();
    }

    @Override
    public void onBuildProject() {
        System.out.print("Build");
    }

    @Override
    public void onSaveAsFile(BufferedWriter out) throws IOException {
        out.write(textArea.getText());
        out.close();
    }


}
