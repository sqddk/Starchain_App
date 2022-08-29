package com.starchain.global;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class ResourceStorageCenter {
    private static class ResourceStorageCenterHolder{
        private static final ResourceStorageCenter INSTANCE = new ResourceStorageCenter();
    }
    public static ResourceStorageCenter getInstance(){
        return ResourceStorageCenterHolder.INSTANCE;
    }
    public static void init(){
        getInstance();
    }


    private ResourceStorageCenter(){}
    private final ConcurrentHashMap<String, ArrayList<?>> BucketsStore = new ConcurrentHashMap<>();

}
