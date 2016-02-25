package com.iteso.compilador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class EditTextMenuBar extends JToolBar implements ActionListener{
    private Button save;
    private Button open;
    private Button close;
    private Button build;
    private Button run;
    private Button copy;
    private Button paste;
    private Button cut;
    private TextEditor editor;

    public EditTextMenuBar(TextEditor editor){
        save = new Button();
        open = new Button();
        close = new Button();
        build = new Button();
        run = new Button();
        copy = new Button();
        paste = new Button();
        cut = new Button();
        this.editor = editor;
        init();
    }

    private void init(){
        add(save);
        add(open);
        add(close);
        add(build);
        add(run);
        add(copy);
        add(paste);
        add(cut);

        save.addActionListener(this);
        open.addActionListener(this);
        close.addActionListener(this);
        build.addActionListener(this);
        run.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        cut.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save){
            JFileChooser file = new JFileChooser();
            int option = file.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter(file.getSelectedFile().getPath()));
                    editor.onSaveFile(out);
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }else if(e.getSource() == open){
            JFileChooser file = new JFileChooser();
            int option = file.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                try {
                    Scanner scanner = new Scanner(new FileReader(file.getSelectedFile().getPath()));
                    editor.onOpenFile(scanner);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }else if(e.getSource() == close){
            editor.onCloseFile();
        }else if(e.getSource() == build){
            editor.onBuildProject();
        }else if(e.getSource() == run){
            editor.onRunProject();
        }else if(e.getSource() == copy){
            editor.onCopyText();
        }else if(e.getSource() == paste){
            editor.onPasteText();
        }else if(e.getSource() == cut){
            editor.onCutText();
        }
    }
}
