package com.glqdlt.myho;

import com.drew.imaging.ImageProcessingException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class ImageFileTest {

    private File target = new File("aaa");

    @Test
    public void TEST_convertToFileDate() throws ImageProcessingException, IOException {
        FileRenamer.JpgFileRenamer jpgFileRenamer = new FileRenamer.JpgFileRenamer();
        if (jpgFileRenamer.isSupport(target)) {
            String originFileName = target.getName();
            String convertedFileName = jpgFileRenamer.convertFileName(target);
            System.out.println(originFileName);
            System.out.println(convertedFileName);
        }

    }

}