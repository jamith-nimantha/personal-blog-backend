package com.jamith.absd.personalblog.dto;

public class StatDTO {
    Integer postCount;
    Integer commentCount;
    Integer viewsCount;

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("StatDTO{");
        sb.append("postCount=").append(postCount);
        sb.append(", commentCount=").append(commentCount);
        sb.append(", viewsCount=").append(viewsCount);
        sb.append('}');
        return sb.toString();
    }
}
