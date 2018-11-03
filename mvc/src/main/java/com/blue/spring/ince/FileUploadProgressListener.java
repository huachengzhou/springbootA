package com.blue.spring.ince;

/**
 * @Author zch
 * @Description
 * @createDate 2018/11/3
 **/

import com.blue.domin.Progress;
import org.apache.commons.fileupload.ProgressListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;

/**
 * @author zhou
 * 文件上传进度监听类
 */

public class FileUploadProgressListener implements ProgressListener {
    private final Logger logger = LoggerFactory.getLogger(getClass());
    private HttpSession session;

    public void setSession(HttpSession session) {
        this.session = session;
        Progress status = new Progress();//保存上传状态
        session.setAttribute("status", status);
    }

    public void update(long pBytesRead, long pContentLength, int pItems) {
        Progress status = (Progress) session.getAttribute("status");
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        status.setpBytesRead(pBytesRead);
        status.setpContentLength(pContentLength);
        status.setpItems(pItems);
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>> "+status);
    }

}