package com.hxw.project.controller;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * @Author HuShengHenGao
 * @Date 2022/10/17
 **/
public class PDFprase {
    public static void main(String[] args) throws Exception {
        try (PDDocument document = PDDocument.load(new File("C:\\Users\\xiaohu\\Desktop\\test.pdf"))) {
            if (!document.isEncrypted()) {
                PDFTextStripper tStripper = new PDFTextStripper();
                // 如果想抽取某一页或者某几页，可以使用下面的方法限定范围。
                // 目前是抽取所有页
                tStripper.setStartPage(0);
                tStripper.setEndPage(document.getNumberOfPages());
                String pdfFileInText = tStripper.getText(document);
                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(line);
                }
            }
        }
    }
}
