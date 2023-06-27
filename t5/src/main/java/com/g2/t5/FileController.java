package com.g2.t5;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Controller;

import java.io.IOException;

@Controller
public class FileController {

    public void listFilesInFolder(String folderPath) {
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources(folderPath + "/*");

            for (Resource resource : resources) {
                if (resource.isFile()) {
                    String fileName = resource.getFilename();
                    System.out.println(fileName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

