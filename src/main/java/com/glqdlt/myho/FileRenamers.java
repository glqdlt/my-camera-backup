package com.glqdlt.myho;

import com.drew.imaging.ImageProcessingException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileRenamers {

    private static final List<FileRenamer> ENTRY = new LinkedList<>();

    static {
        ENTRY.add(new FileRenamer.Mp4FileRenamer());
        ENTRY.add(new FileRenamer.JpgFileRenamer());
    }

    public String converRename(File file) {

        FileRenamer zzz = FileRenamers.ENTRY.stream().filter(x -> x.isSupport(file)).findAny().orElseThrow(() -> new FileRenamerExpectedError.NotSupportFile(file.getName()));

        try {
            return zzz.convertFileName(file);
        } catch (ImageProcessingException | IOException e) {
            throw new RuntimeException(e);
        }
    }


}
