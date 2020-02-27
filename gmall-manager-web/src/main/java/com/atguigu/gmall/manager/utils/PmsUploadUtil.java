package com.atguigu.gmall.manager.utils;

import org.apache.commons.lang3.StringUtils;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传图片工具类
 */
public class PmsUploadUtil {

    public static String uploadImage(MultipartFile multipartFile) {
        String imgUrl="";
        if(multipartFile != null){
            String configFile = PmsUploadUtil.class.getResource("/tracker.conf").getFile();
            try {
                ClientGlobal.init(configFile);
                TrackerClient trackerClient =new TrackerClient();
                TrackerServer trackerServer = trackerClient.getTrackerServer();
                StorageClient storageClient = new StorageClient(trackerServer,null);
                String filename=    multipartFile.getOriginalFilename();
                String extName = StringUtils.substringAfterLast(filename,".");
                String[] upload_file = storageClient.upload_file(multipartFile.getBytes(), extName, null);
                for (int i = 0; i < upload_file.length; i++) {
                    String path = upload_file[i];
                    imgUrl+="/"+path;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
        return imgUrl;
    }
}
