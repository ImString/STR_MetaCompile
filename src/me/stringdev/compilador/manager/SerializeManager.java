package me.stringdev.compilador.manager;

import me.stringdev.compilador.object.CompilerObject;
import me.stringdev.compilador.object.PrinterObject;

import java.io.File;
import java.io.IOException;

public class SerializeManager {

    private String name;
    private String serialize;

    public void serializeFile() {
        CompilerObject compilerManager = new CompilerObject();
        if (getName() != null) {
            compilerManager.addFile(getName());
        }
    }

    public void serializeText(File file) {
        PrinterObject printerObject = new PrinterObject();
        try {
            printerObject.printInFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSerialize(String serialize) {
        this.serialize = serialize;
    }

    public String getSerialize() {
        return serialize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}