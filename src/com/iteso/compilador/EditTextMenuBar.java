package com.iteso.compilador;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class EditTextMenuBar extends JMenuBar implements ActionListener{
    private JButton save;
    private JButton open;
    private JButton build;
    private JButton copy;
    private JButton paste;
    private JButton cut;
    private JButton saveAs;
    private TextEditor editor;
    private String path;


    public EditTextMenuBar(TextEditor editor){
        BufferedImage imageSave   = null;
        BufferedImage imageOpen   = null;
        BufferedImage imageBuild  = null;
        BufferedImage imageCopy   = null;
        BufferedImage imagePaste  = null;
        BufferedImage imageCut    = null;
        BufferedImage imageSaveAs = null;

        path = null;

        try {
            URL file = getClass().getResource("images/save.png");
            imageSave = ImageIO.read(file);

            file = getClass().getResource("images/open.png");
            imageOpen = ImageIO.read(file);

            file = getClass().getResource("images/build.png");
            imageBuild = ImageIO.read(file);

            file = getClass().getResource("images/copy.png");
            imageCopy = ImageIO.read(file);

            file = getClass().getResource("images/paste.png");
            imagePaste = ImageIO.read(file);

            file = getClass().getResource("images/cut.png");
            imageCut = ImageIO.read(file);

            file = getClass().getResource("images/saveAs.png");
            imageSaveAs = ImageIO.read(file);

        } catch (IOException ioex){

        }
        ImageIcon iconSave   = new ImageIcon(imageSave);
        ImageIcon iconOpen   = new ImageIcon(imageOpen);
        ImageIcon iconBuild  = new ImageIcon(imageBuild);
        ImageIcon iconCopy   = new ImageIcon(imageCopy);
        ImageIcon iconPaste  = new ImageIcon(imagePaste);
        ImageIcon iconCut    = new ImageIcon(imageCut);
        ImageIcon iconSaveAs = new ImageIcon(imageSaveAs);

        save   = new JButton(iconSave);
        open   = new JButton(iconOpen);
        build  = new JButton(iconBuild);
        copy   = new JButton(iconCopy);
        paste  = new JButton(iconPaste);
        cut    = new JButton(iconCut);
        saveAs = new JButton(iconSaveAs);

        this.editor = editor;
        init();
    }

    private void init(){
        JSeparator separator = new JSeparator();
        JSeparator separator2 = new JSeparator();
        separator.setMaximumSize(new Dimension(20, 0));
        separator2.setMaximumSize(new Dimension(20, 0));
        add(open);
        add(save);
        add(saveAs);
        add(separator);
        add(build);
        add(separator2);
        add(copy);
        add(cut);
        add(paste);


        save.addActionListener(this);
        open.addActionListener(this);
        build.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        cut.addActionListener(this);
        saveAs.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == save){
            if(path != null){
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter(path));
                    editor.onSaveAsFile(out);
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }else{
                saveAs.doClick();
            }
        }else if(e.getSource() == open){
            JFileChooser file = new JFileChooser();
            int option = file.showOpenDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                try {
                    path = file.getSelectedFile().getPath();
                    Scanner scanner = new Scanner(new FileReader(path));
                    editor.onOpenFile(scanner);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        }else if(e.getSource() == build){
            editor.onBuildProject();
        }else if(e.getSource() == copy){
            editor.onCopyText();
        }else if(e.getSource() == paste){
            editor.onPasteText();
        }else if(e.getSource() == cut){
            editor.onCutText();
        }else if(e.getSource() == saveAs){
            JFileChooser file = new JFileChooser();
            int option = file.showSaveDialog(this);
            if(option == JFileChooser.APPROVE_OPTION){
                try {
                    path = file.getSelectedFile().getPath();
                    BufferedWriter out = new BufferedWriter(new FileWriter(path));
                    editor.onSaveAsFile(out);
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
