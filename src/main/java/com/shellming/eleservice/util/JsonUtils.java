package com.shellming.eleservice.util;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.io.FileUtils;
import net.sf.json.JSONObject;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class JsonUtils {
    public static String readJsonData(String pactFile) throws IOException {
        // 读取文件数据
        //System.out.println("读取文件数据util");
        StringBuffer strbuffer = new StringBuffer();
        File myFile = new File(pactFile);
        if (!myFile.exists()) {
            System.err.println("Can't Find " + pactFile);
        }
        try {
            FileInputStream fis = new FileInputStream(pactFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
            BufferedReader in = new BufferedReader(inputStreamReader);

            String str;
            while ((str = in.readLine()) != null) {
                strbuffer.append(str);  //new String(str,"UTF-8")
            }
            in.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
        //System.out.println("读取文件结束util");
        return strbuffer.toString();
    }

    public static Map getJsonData(String path) {
        try {
            URL l1 = Thread.currentThread().getContextClassLoader().getResource(path);
            System.out.println(l1);
            String str = readJsonData(l1.toString());
            log.info("str" + str);
        } catch (Exception e) {
            log.error("读取JSON{}失败: {}", path, e);
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        File jsonFile = ResourceUtils.getFile("classpath:CitiesInitData.json");
        String json = FileUtils.readFileToString(jsonFile);
        JSONObject jsonObject = JSONObject.fromObject(json);
        log.info("mapObj: {}", jsonObject);
        Iterator iterator = jsonObject.keys();
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            String value = jsonObject.getString(key);
            log.info("key:"+ key);
            log.info("value:{}", value);
        }
    }
}
