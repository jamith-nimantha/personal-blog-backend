package com.jamith.absd.personalblog.entity;


import com.jamith.absd.personalblog.dto.PostDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("Duplicates")
@Entity
@Table(name = "T_POST")
public class Post implements Serializable {

    private static final long serialVersionUID = -5803387771833142101L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PERMALINK")
    private String permalink;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "STATUS")
    private boolean status;

    @Column(name = "VIEWS")
    private Integer views;

    @Column(name ="CREATED_DATE")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;

    @OneToOne
    @JoinColumn(name = "IMAGE_ID")
    private Image image;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public PostDTO getAdminPostDTO(){
        PostDTO postDTO = new PostDTO();
        postDTO.setId(this.id);
        postDTO.setTitle(this.title);
        postDTO.setPermalink(this.permalink);
        postDTO.setStatus(this.status);
        postDTO.setCreatedDate(this.createdDate);
        postDTO.setModifiedDate(this.modifiedDate);
        postDTO.setViews(this.views);
        return postDTO;
    }

//    public PostDTO getPublicPostDTO(){
//        PostDTO postDTO = new PostDTO();
//        postDTO.setId(this.id);
//        postDTO.setTitle(this.title);
//        postDTO.setPermalink(this.permalink);
//        postDTO.setContent(this.content);
//        postDTO.setStatus(this.status);
//        postDTO.setCreatedDate(this.createdDate);
//        postDTO.setModifiedDate(this.modifiedDate);
//        postDTO.setViews(this.views);
//        postDTO.setImage(this.image.getPath());
//        return postDTO;
//    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Post{");
        sb.append("id=").append(id);
        sb.append(", title='").append(title).append('\'');
        sb.append(", permalink='").append(permalink).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", status=").append(status);
        sb.append(", views=").append(views);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", modifiedDate=").append(modifiedDate);
        sb.append(", image=").append(image);
        sb.append('}');
        return sb.toString();
    }
}
