package com.lpcoder.agile.mind.palace.entity;

/**
 * Created by lrp on 17-3-5.
 */
public class ArticleDO {

    //主键
    private int id;
    //标题
    private String title;
    //摘要
    private String summary;
    //封面图片
    private String coverImgUrl;
    //内容
    private String url;
    //类别
    private int typeId;
    //排序
    private int sort;

    @Override
    public String toString() {
        return "ArticleDO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", coverImgUrl='" + coverImgUrl + '\'' +
                ", url='" + url + '\'' +
                ", typeId=" + typeId +
                ", sort=" + sort +
                '}';
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCoverImgUrl() {
        return coverImgUrl;
    }

    public void setCoverImgUrl(String coverImgUrl) {
        this.coverImgUrl = coverImgUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }
}
