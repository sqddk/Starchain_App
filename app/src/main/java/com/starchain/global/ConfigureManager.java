package com.starchain.global;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ConfigureManager {
    private static class ConfigureManagerHolder{
        private static final ConfigureManager INSTANCE = new ConfigureManager();
    }
    public static ConfigureManager getInstance(){
        return ConfigureManagerHolder.INSTANCE;
    }
    public static void init(){
        getInstance();
    }


    private ConfigureManager(){
        this.loadConfig();
    }
    private static final String NATIVE_CONFIGURE_PATH = "data/data/com.starchain/config.json";
    private JSONObject config;

    /**
     * 初始化加载配置
     */
    private void loadConfig(){
        File file = new File(NATIVE_CONFIGURE_PATH);
        if(file.exists()){
            try{
                BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(file.toPath())));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                config = JSON.parseObject(response.toString());
            }catch (IOException e){
                e.printStackTrace();
            }
        }else{
            this.saveConfig();
        }
    }

    /**
     * 保存JSON格式的配置文件
     */
    public void saveConfig(){
        File file = new File(NATIVE_CONFIGURE_PATH);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(config.toJSONString().getBytes(StandardCharsets.UTF_8));
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取配置文件
     * @param key 配置项的键
     * @return 配置项的值
     */
    public String getValue(String key){
        return this.config.getString(key);
    }

    /**
     * 设置配置文件
     * @param key 配置项的键
     * @param value 配置项的值
     */
    public void setValue(String key, String value){
        this.config.put(key, value);
    }

}
