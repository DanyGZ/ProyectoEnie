package com.iteso.compilador;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Daniel on 24/02/2016.
 */
public class TextEditor extends JFrame implements OnButtonPressedListener{
    private TextArea textArea;
    private EditTextMenuBar menuBar;

    public TextEditor(String text){
        textArea = new TextArea(text, 0,0, TextArea.SCROLLBARS_VERTICAL_ONLY);
        menuBar = new EditTextMenuBar(this);
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
    public void onOpenFile(String path) {
        System.out.print("Open");
    }

    @Override
    public void onCloseFile() {
        this.dispose();
    }

    @Override
    public void onSaveFile() {
        System.out.print("Save");
    }

    @Override
    public void onCutText() {
        System.out.print("Cut");
    }

    @Override
    public void onCopyText() {
        System.out.print("Copy");
    }

    @Override
    public void onPasteText() {
        System.out.print("Paste");
    }

    @Override
    public void onBuildProject() {
        System.out.print("Build");
    }

    @Override
    public void onRunProject() {
        System.out.print("Run");
    }
}
