package me.stringdev.compilador.object;

import me.stringdev.compilador.enums.FileType;

public class FileObject {

    public String dirName;
    public FileType fileType;

    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }
}