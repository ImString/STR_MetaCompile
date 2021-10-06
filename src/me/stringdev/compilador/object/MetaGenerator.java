package me.stringdev.compilador.object;

import me.stringdev.compilador.Main;
import me.stringdev.compilador.enums.FileType;
import me.stringdev.compilador.manager.SerializeManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MetaGenerator {

    public void generateMeta() {
        try {
            File myObj = new File(Main.getExecutionPath(), "meta.xml");
            if (myObj.createNewFile()) {
                File[] pathnames;
                File f = Main.getExecutionPath();
                pathnames = f.listFiles();
                try (Stream<Path> walk = Files.walk(Paths.get(Main.getExecutionPath().toURI()))) {
                    List<String> result = walk.filter(Files::isRegularFile).map(x -> x.toString().replace(System.getProperty("user.dir") + "\\", "")).collect(Collectors.toList());

                    for (String pathname : result) {
                        pathname = pathname.replace("\\", "/");
                        if (!pathname.contains(".jar") && !pathname.contains(".bat")) {
                            if (!pathname.equalsIgnoreCase("meta.xml")) {
                                SerializeManager serializerName = new SerializeManager();
                                serializerName.setName(pathname);
                                serializerName.serializeFile();
                            }
                        }
                    }

                    Main.getManager().serializeText(myObj);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException err) {
            System.out.println("An error occurred.");
            err.printStackTrace();
        }
    }

    public void filterMeta(List<String> filter) {
        System.out.println("Start");
        ArrayList<FileObject> fileObjects = new ArrayList<>();
        filter.forEach(f -> {
            if (f.replace(" ", "").contains("-")) {
                FileObject fileObject = new FileObject();
                fileObject.setDirName(f.replace(" ", "").split("-")[0]);
                fileObject.setFileType(FileType.valueOf(f.replace(" ", "").split("-")[1].toUpperCase()));
                fileObjects.add(fileObject);
            }
        });

        fileObjects.forEach(fObj -> {
            CompilerObject.filter.put(fObj.getDirName(), fObj.getFileType());
        });
    }
}
