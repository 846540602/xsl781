package org.xsl781.db.model;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * 实体的表结构
 *
 * 
 * @date 2013-6-9上午1:10:48
 */
public class EntityTable implements Serializable {
    private static final long serialVersionUID = 421721084878061123L;
    /**
     * 实体对应类
     */
    public Class                           claxx;
    /**
     * 实体对应表名
     */
    public String                          name;
    /**
     * 主键
     */
    public PrimaryKey                      key;
    /**
     * 属性列表
     */
    public LinkedHashMap<String, Property> pmap;
    /**
     * 多对一属性列表
     */
    public ArrayList<MapProperty>          mappingList;

    public void addMapping(MapProperty pro) {
        if (mappingList == null) {
            mappingList = new ArrayList<MapProperty>();
        }
        mappingList.add(pro);
    }

    public Annotation getAnnotation(Class annoClass) {
        if (claxx != null) return claxx.getAnnotation(annoClass);
        return null;
    }

    @Override
    public String toString() {
        return "EntityTable{" +
                "claxx=" + claxx +
                ", name='" + name + '\'' +
                ", key=" + key +
                ", pmap=" + pmap +
                ", mappingList=" + mappingList +
                '}';
    }
}
