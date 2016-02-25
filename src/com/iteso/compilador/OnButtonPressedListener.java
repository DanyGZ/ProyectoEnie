package com.iteso.compilador;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Daniel on 24/02/2016.
 */
public interface OnButtonPressedListener {
    void onOpenFile(Scanner scanner);
    void onCloseFile();
    void onSaveFile(BufferedWriter out) throws IOException;
    void onCutText();
    void onCopyText();
    void onPasteText();
    void onBuildProject();
    void onRunProject();
}
