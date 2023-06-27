package com.g2.t5;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.ArrayList;

@Controller
public class FileController {
    private ArrayList<String> Class = new ArrayList<>();
    
    public void listFilesInFolder(String folderPath) {
        try {
            ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
            Resource[] resources = resolver.getResources(folderPath + "/*");

            for (Resource resource : resources) {
                if (resource.isFile()) {
                    String fileName = resource.getFilename();
                    Class.add(fileName);
                    System.out.println(fileName);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getClassSize() { return Class.size(); }

    public String getClass(int i) { return Class.get(i); }

}

