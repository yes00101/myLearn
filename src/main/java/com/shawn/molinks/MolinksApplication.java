package com.shawn.molinks;

import com.shawn.molinks.utils.ExcelUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.multipart.MultipartFile;

@SpringBootApplication
public class MolinksApplication {

    private static final Log logger = LogFactory.getLog(MolinksApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(MolinksApplication.class, args);
        logger.error("魔灵坐标基础程序启动成功！");
    }

}
