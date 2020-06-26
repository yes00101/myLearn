package com.shawn.molinks.service;

import com.shawn.molinks.MolinksApplication;
import com.shawn.molinks.entity.MolinksAddress;
import com.shawn.molinks.utils.ExcelUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class GisPointConfig implements InitializingBean, ServletContextAware {

    private static final Log logger = LogFactory.getLog(GisPointConfig.class);

    @Value("${molinks.excel.path}")
    private String filePath;

    public static List<MolinksAddress> MOLINKS_ADDRESS_LIST = new ArrayList<>(2048);

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        try {
            MOLINKS_ADDRESS_LIST = ExcelUtils.importExcel(filePath, 0, 1, MolinksAddress.class);
        } catch (IOException e) {
            logger.error("初始化数据出现异常！", e);
        }
    }

    /**
     * 数据重载
     * @return
     */
    public String reloadData(){
        try {
            MOLINKS_ADDRESS_LIST = ExcelUtils.importExcel(filePath, 0, 1, MolinksAddress.class);
        } catch (IOException e) {
            logger.error("初始化数据出现异常！", e);
            return e.getMessage();
        }
        return "数据重载成功";
    }


}
