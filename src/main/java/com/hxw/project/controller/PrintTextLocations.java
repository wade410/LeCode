package com.hxw.project.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.TextPosition;

import java.io.*;
import java.util.List;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/17
 **/
public class PrintTextLocations extends PDFTextStripper {

    public PrintTextLocations() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        PDDocument document = null;
        try {
            document = PDDocument.load(new File("C:\\Users\\xiaohu\\Desktop\\test.pdf"));

            PDFTextStripper stripper = new PrintTextLocations();
            stripper.setSortByPosition(true);
            stripper.setStartPage(0);
            stripper.setEndPage(document.getNumberOfPages());

            Writer dummy = new OutputStreamWriter(new ByteArrayOutputStream());
            stripper.writeText(document, dummy);
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }

    @Override
    protected void writeString(String string, List<TextPosition> textPositions) throws IOException {
        for (TextPosition text : textPositions) {
            System.out.println("String[" + text.getXDirAdj() + "," + text.getYDirAdj()
                    + " fs=" + text.getFontSize()
                    + " xscale=" + text.getXScale()
                    + " height=" + text.getHeightDir()
                    + " space="  + text.getWidthOfSpace()
                    + " width=" + text.getWidthDirAdj() + "]"
                    + text.getUnicode());
        }
    }

}