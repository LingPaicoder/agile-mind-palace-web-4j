package ren.lingpai.agile.mind.palace.entity;

/**
 * Created by lrp on 17-5-13.
 */
public class TypeDO {

    private int id;
    private int pId;
    private String topic;
    private String direction;
    private String expanded;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPId() {
        return pId;
    }

    public void setPId(int pId) {
        this.pId = pId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getExpanded() {
        return expanded;
    }

    public void setExpanded(String expanded) {
        this.expanded = expanded;
    }

    public String parseRootNodeStr() {
        return "{\"id\":\"" +
                this.getId() +
                "\",\"isroot\":true, \"topic\":\"" +
                this.getTopic() + "\"},";
    }

    public String parseSonNodeStr() {
        return "{\"id\":\"" +
                this.getId() +
                "\", \"parentid\":\"" +
                this.getPId() +
                "\", \"topic\":\"" +
                this.getTopic() +
                "\", \"direction\":\"" +
                this.getDirection() +
                "\"},";
    }

}
