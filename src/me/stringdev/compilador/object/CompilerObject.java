package me.stringdev.compilador.object;

import me.stringdev.compilador.enums.FileType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompilerObject {

    private static HashMap<String, FileType> listFiles = new HashMap<>();
    public static HashMap<String, FileType> filter = new HashMap<>();

    public void addFile(String fileName) {
        FileType fileType = null;
        for (String v : filter.keySet()) {
            if (fileName.contains(v)) {
                fileType = filter.get(v);
                break;
            }
        }

        if (fileType == null) {
            fileType = FileType.FILE;
        }

        listFiles.put(fileName, fileType);
    }

    public List<FileObject> getListFiles(FileType fileType) {
        ArrayList<FileObject> newList = new ArrayList<>();
        getListFiles().forEach(list -> {
            if (list.getFileType() == fileType) {
                newList.add(list);
            }
        });

        return newList;
    }

    public List<FileObject> getListFiles() {
        ArrayList<FileObject> newList = new ArrayList<>();
        listFiles.keySet().forEach(fileName -> {
            FileObject object = new FileObject();
            object.setDirName(fileName);
            object.setFileType(listFiles.get(fileName));
            newList.add(object);
        });

        return newList;
    }
}