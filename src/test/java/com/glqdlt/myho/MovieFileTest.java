package com.glqdlt.myho;

import com.drew.imaging.ImageProcessingException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class MovieFileTest {
    @Test
    public void name() throws ImageProcessingException, IOException {
        File target = new File("aaaa");
        FileRenamer.Mp4FileRenamer mp4FileRenamer = new FileRenamer.Mp4FileRenamer();
        String aaa = mp4FileRenamer.convertFileName(target);
        System.out.println(aaa);

    }
}
