package com.iteso.compilador;

/**
 * Created by Daniel on 24/02/2016.
 */
public interface OnButtonPressedListener {
    void onOpenFile(String path);
    void onCloseFile();
    void onSaveFile();
    void onCutText();
    void onCopyText();
    void onPasteText();
    void onBuildProject();
    void onRunProject();
}
