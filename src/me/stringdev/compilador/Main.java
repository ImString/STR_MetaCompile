package me.stringdev.compilador;

import me.stringdev.compilador.manager.SerializeManager;
import me.stringdev.compilador.menu.OptionsMenu;
import me.stringdev.compilador.object.MetaGenerator;

import java.io.File;
import javax.swing.JFrame;

public class Main extends JFrame {

    private static SerializeManager manager;
    private static MetaGenerator metaManager;

    public static void main(String[] args) {
        manager = new SerializeManager();
        metaManager = new MetaGenerator();

        OptionsMenu.openMenu();
    }

    public static MetaGenerator getMetaManager() {
        return metaManager;
    }

    public static SerializeManager getManager(){
        return manager;
    }

    public static File getExecutionPath() {
        return new File(System.getProperty("user.dir"));
    }
}