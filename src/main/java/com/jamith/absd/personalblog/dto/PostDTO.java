package com.jamith.absd.personalblog.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PostDTO {
    private Integer id;
    private String title;
    private String permalink;
    private String content;
    private boolean status;
    private Integer views;
    private Date createdDate;
    private Date modifiedDate;
    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PostDTO{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", permalink='").append(permalink).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", status=").append(status);
        sb.append(", views=").append(views);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", modifiedDate=").append(modifiedDate);
        sb.append(", image='").append(image).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
