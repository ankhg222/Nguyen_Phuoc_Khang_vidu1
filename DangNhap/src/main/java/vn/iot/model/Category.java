package vn.iot.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Category implements Serializable {
    private int cateId;
    private String cateName;
    private String icon;
    private int userId;

    public int getCateId() { return cateId; }
    public void setCateId(int cateId) { this.cateId = cateId; }

    public String getCateName() { return cateName; }
    public void setCateName(String cateName) { this.cateName = cateName; }

    public String getIcon() { return icon; }
    public void setIcon(String icon) { this.icon = icon; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}
