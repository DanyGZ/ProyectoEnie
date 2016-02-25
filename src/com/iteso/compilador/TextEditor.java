package com.iteso.compilador;

import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

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
    public void onOpenFile(Scanner scanner) {
        String code = "";
        while(scanner.hasNext()){
            code += (scanner.nextLine() + "\n");
        }
        textArea.append(code);
    }

    @Override
    public void onCloseFile() {
        this.dispose();
    }

    @Override
    public void onSaveFile(BufferedWriter out) throws IOException {
        out.write(textArea.getText());
        out.close();
    }

    @Override
    public void onCutText() {

        ActionMap m = menuBar.getActionMap();
        Action Cut = m.get(DefaultEditorKit.cutAction);
        Action Copy = m.get(DefaultEditorKit.copyAction);
        Action Paste = m.get(DefaultEditorKit.pasteAction);
        
    }

    @Override
    public void onCopyText() {
        String copy = textArea.getSelectedText();
        StringSelection stringSelection = new StringSelection(copy);
        Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipBoard.setContents(stringSelection, null);
    }

    @Override
    public void onPasteText() {
        Clipboard clipBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable transferable = clipBoard.getContents(this);
        if (transferable == null)
            return;
        try {
            textArea.setText((String) transferable.getTransferData(DataFlavor.stringFlavor));
        } catch (Exception e){
            e.printStackTrace();
        }
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
