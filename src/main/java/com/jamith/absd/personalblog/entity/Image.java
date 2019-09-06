package com.jamith.absd.personalblog.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_IMAGE")
public class Image implements Serializable {

    private static final long serialVersionUID = 561492623646734937L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "PATH")
    private String path;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGE_ID")
    private Post post;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Image{");
        sb.append("id=").append(id);
        sb.append(", path='").append(path).append('\'');
        sb.append(", post=").append(post);
        sb.append('}');
        return sb.toString();
    }
}
