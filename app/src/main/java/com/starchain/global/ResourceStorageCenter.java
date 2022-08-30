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


    private ResourceStorageCenter(){}
    private ConcurrentHashMap<String, ArrayList<?>> BucketsStore;

    public void initial(){
        this.BucketsStore = new ConcurrentHashMap<>();
    }

}
