package com.example.demo.test.cache;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntityCache {
    /**
     * 保存的数据
     */
    private  Object datas;

    /**
     * 设置数据失效时间,为0表示永不失效
     */
    private  long timeOut;

    /**
     * 最后刷新时间
     */
    private  long lastRefeshTime;
}
