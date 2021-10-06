package me.stringdev.compilador.object;

import me.stringdev.compilador.Main;
import me.stringdev.compilador.enums.FileType;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PrinterObject {

    public String name;
    public FileType fileType;

    public void printInFile(File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);

        fileWriter.write("<meta>");
        printScript(fileWriter, FileType.SHARED);
        printScript(fileWriter, FileType.SERVER);
        printScript(fileWriter, FileType.CLIENT);
        printFile(fileWriter);
        fileWriter.write("\n</meta>");
        fileWriter.close();

        System.out.println("Close");
    }

    private void printScript(FileWriter fileWriter, FileType fileType) {
        CompilerObject compilerObject = new CompilerObject();
        compilerObject.getListFiles(fileType).forEach(fType -> {
            try {
                fileWriter.write("\n\t<script src=\"" + fType.getDirName() + "\" type=\"" + fType.getFileType().name().toLowerCase() + "\" />");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void printFile(FileWriter fileWriter) {
        CompilerObject compilerObject = new CompilerObject();
        compilerObject.getListFiles(FileType.FILE).forEach(fType -> {
            try {
                if (1 == 1) {
                    fileWriter.write("\n\t<file src=\"" + fType.getDirName() + "\" />");
                } else {
                    fileWriter.write("\n\t<file src=\"" + fType.getDirName() + "\" cache=\"false\" />");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }
}