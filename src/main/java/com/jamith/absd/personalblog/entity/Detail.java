package com.jamith.absd.personalblog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "T_DETAIL")
public class Detail implements Serializable {

    private static final long serialVersionUID = 6200750167963307720L;

    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "BLOG_NAME", nullable = false)
    private String blogName;

    @Column(name = "BLOG_DESCRIPTION")
    private String blogDescription;

    @Column(name = "BLOG_DOMAIN")
    private String blogDomain;

    @Column(name = "LINKEDIN_URL")
    private String linkedinURL;

    @Column(name = "FACEBOOK_URL")
    private String facebookURL;

    @Column(name = "TWITTER_URL")
    private String twitterURL;

    @Column(name = "GITHUB_URL")
    private String githubURL;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogName() {
        return blogName;
    }

    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    public String getBlogDescription() {
        return blogDescription;
    }

    public void setBlogDescription(String blogDescription) {
        this.blogDescription = blogDescription;
    }

    public String getBlogDomain() {
        return blogDomain;
    }

    public void setBlogDomain(String blogDomain) {
        this.blogDomain = blogDomain;
    }

    public String getLinkedinURL() {
        return linkedinURL;
    }

    public void setLinkedinURL(String linkedinURL) {
        this.linkedinURL = linkedinURL;
    }

    public String getFacebookURL() {
        return facebookURL;
    }

    public void setFacebookURL(String facebookURL) {
        this.facebookURL = facebookURL;
    }

    public String getTwitterURL() {
        return twitterURL;
    }

    public void setTwitterURL(String twitterURL) {
        this.twitterURL = twitterURL;
    }

    public String getGithubURL() {
        return githubURL;
    }

    public void setGithubURL(String githubURL) {
        this.githubURL = githubURL;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Detail{");
        sb.append("id=").append(id);
        sb.append(", blogName='").append(blogName).append('\'');
        sb.append(", blogDescription='").append(blogDescription).append('\'');
        sb.append(", blogDomain='").append(blogDomain).append('\'');
        sb.append(", linkedinURL='").append(linkedinURL).append('\'');
        sb.append(", facebookURL='").append(facebookURL).append('\'');
        sb.append(", twitterURL='").append(twitterURL).append('\'');
        sb.append(", githubURL='").append(githubURL).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
