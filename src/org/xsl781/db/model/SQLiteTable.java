package org.xsl781.db.model;

import java.io.Serializable;
import java.util.List;

import org.xsl781.db.annotation.Column;

/**
 * 表结构，SQLite中的每一张表都有这样的属性。
 * CREATE TABLE sqlite_master (
 * 　type TEXT,
 * 　name TEXT,
 * 　tbl_name TEXT,
 * 　rootpage INTEGER,
 * 　sql TEXT
 * );
 *
 * 
 * @date 2013-6-2下午11:17:40
 */
public class SQLiteTable implements Serializable {
    private static final long serialVersionUID = 6706520684759700566L;

    @Column("type")
    public String       type;

    @Column("name")
    public String       name;

    @Column("tbl_name")
    public String       tbl_name;

    @Column("rootpage")
    public long         rootpage;

    @Column("sql")
    public String       sql;

    public boolean      isTableChecked;
    public List<String> columns;

    @Override
    public String toString() {
        return "SQLite Table Struct：type=" + type + ", name=" + name + ", tbl_name=" + tbl_name + ", " +
                "rootpage=" + rootpage
                + ", sql=" + sql + ", columns=" + columns;
    }

}
