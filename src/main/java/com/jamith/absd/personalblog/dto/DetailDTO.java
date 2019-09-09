package com.jamith.absd.personalblog.dto;

public class DetailDTO {

    private String name;
    private String description;
    private String domain;
    private String linkedin;
    private String facebook;
    private String twitter;
    private String github;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DetailDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", domain='").append(domain).append('\'');
        sb.append(", linkedin='").append(linkedin).append('\'');
        sb.append(", facebook='").append(facebook).append('\'');
        sb.append(", twitter='").append(twitter).append('\'');
        sb.append(", github='").append(github).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
