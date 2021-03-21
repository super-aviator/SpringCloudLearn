package com.xqk.cloud.consumer.feign;

import com.xqk.cloud.consumer.controller.ClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 交通cache服务FeignClient
 *
 * @author 熊乾坤
 * @since 2021-03-16 10:59
 */
@FeignClient(name = "kstpCacheFeignClient", url = "${feign.kstp-cache}", configuration = ClientConfiguration.class)
public interface KstpCacheFeignClient {
    /**
     * 上传文件
     *
     * @param file 文件二进制
     * @return ResponseMessage
     */
    @PostMapping(value = "/attachment/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    List<String> uploadFile(@RequestPart("file") MultipartFile file);

    /**
     * 删除文件
     *
     * @param fileName 文件名需要带年月日参数，例如：2021/03/16/20210316144530968_Sketchpad.png
     * @return ResponseMessage
     */
    @DeleteMapping("/attachment/delete")
    List<String> deleteFile(@RequestParam("fileName") String fileName);
}
