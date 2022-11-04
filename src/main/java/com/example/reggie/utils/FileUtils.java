package com.example.reggie.utils;

import com.example.reggie.common.CustomException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class FileUtils {

    private static String basePath;

    @Value("${reggie.path}")
    public void setBasePath(String basePath) {
        FileUtils.basePath = basePath;
    }

    /**
     *删除文件
     * @param fileName 这是图片的路径
     * @return
     */
    public static void deleteFile(List<String> fileName){
        File file;
        for(String name:fileName){
            file = new File(basePath + name);
            //判断文件存不存在
            if(!file.exists()){
                throw new CustomException("系统繁忙");
            }else{
                //判断这是不是一个文件，ps：有可能是文件夹
                if(file.isFile()){
                    file.delete();
                }
            }
        }


    }

}
