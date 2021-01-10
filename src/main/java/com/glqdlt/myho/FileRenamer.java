package com.glqdlt.myho;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.mp4.Mp4MetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;

import java.io.File;
import java.io.IOException;

/**
 * @see <a href='https://github.com/drewnoakes/metadata-extractor'>https://github.com/drewnoakes/metadata-extractor</a>
 */
public interface FileRenamer {
    String convertFileName(File file) throws ImageProcessingException, IOException;

    Boolean isSupport(File file);

    class Mp4FileRenamer implements FileRenamer, DateParser.Mp4DateParser {

        @Override
        public String convertFileName(File file) throws ImageProcessingException, IOException {
            Metadata metadata = Mp4MetadataReader.readMetadata(file);
            String dateName = null;
            for (Directory directory : metadata.getDirectories()) {
                if (directory.getName().equals("MP4")) {
                    for (Tag tag : directory.getTags()) {
                        if (tag.getTagType() == 256) {
                            dateName = parsing(tag.getDescription());
                        }
                    }
                }
            }
            if (dateName == null || dateName.startsWith("1904")) {
                throw new FileRenamerExpectedError.DateFiledNotFounded(file.getName());
            }

            return String.format("%s_%s", dateName, file.getName());
        }

        @Override
        public Boolean isSupport(File file) {
            return file.getName().toLowerCase().endsWith("mp4");
        }
    }

    class JpgFileRenamer implements FileRenamer, DateParser.JpgDateParser {

        @Override
        public String convertFileName(File file) throws ImageProcessingException, IOException {
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            String dateString = null;

            for (Directory attributeDirectory : metadata.getDirectories()) {
                if (attributeDirectory instanceof ExifIFD0Directory) {
                    for (Tag attribute : attributeDirectory.getTags()) {
                        if (attribute.getTagType() == 306) {
                            dateString = parsing(attribute.getDescription());
                        }
                    }
                }
            }
            if (dateString == null) {
                throw new FileRenamerExpectedError.DateFiledNotFounded(file.getName());
            }

            return String.format("%s_%s", dateString, file.getName());
        }

        @Override
        public Boolean isSupport(File file) {
            return file.getName().toLowerCase().endsWith("jpg");
        }
    }
}
