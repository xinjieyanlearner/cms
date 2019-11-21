package com.briup.apps.cms.bean;

public class Article {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.id
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.title
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.content
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.source
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    private String source;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.publish_time
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    private Long publishTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.read_times
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    private Long readTimes;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.status
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.thump_up
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    private Long thumpUp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.thump_down
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    private Long thumpDown;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.author_id
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    private Long authorId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cms_article.category_id
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    private Long categoryId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.id
     *
     * @return the value of cms_article.id
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.id
     *
     * @param id the value for cms_article.id
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.title
     *
     * @return the value of cms_article.title
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.title
     *
     * @param title the value for cms_article.title
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.content
     *
     * @return the value of cms_article.content
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.content
     *
     * @param content the value for cms_article.content
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.source
     *
     * @return the value of cms_article.source
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public String getSource() {
        return source;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.source
     *
     * @param source the value for cms_article.source
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.publish_time
     *
     * @return the value of cms_article.publish_time
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public Long getPublishTime() {
        return publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.publish_time
     *
     * @param publishTime the value for cms_article.publish_time
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public void setPublishTime(Long publishTime) {
        this.publishTime = publishTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.read_times
     *
     * @return the value of cms_article.read_times
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public Long getReadTimes() {
        return readTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.read_times
     *
     * @param readTimes the value for cms_article.read_times
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public void setReadTimes(Long readTimes) {
        this.readTimes = readTimes;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.status
     *
     * @return the value of cms_article.status
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.status
     *
     * @param status the value for cms_article.status
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.thump_up
     *
     * @return the value of cms_article.thump_up
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public Long getThumpUp() {
        return thumpUp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.thump_up
     *
     * @param thumpUp the value for cms_article.thump_up
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public void setThumpUp(Long thumpUp) {
        this.thumpUp = thumpUp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.thump_down
     *
     * @return the value of cms_article.thump_down
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public Long getThumpDown() {
        return thumpDown;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.thump_down
     *
     * @param thumpDown the value for cms_article.thump_down
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public void setThumpDown(Long thumpDown) {
        this.thumpDown = thumpDown;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.author_id
     *
     * @return the value of cms_article.author_id
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public Long getAuthorId() {
        return authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.author_id
     *
     * @param authorId the value for cms_article.author_id
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cms_article.category_id
     *
     * @return the value of cms_article.category_id
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public Long getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cms_article.category_id
     *
     * @param categoryId the value for cms_article.category_id
     *
     * @mbg.generated Tue Nov 12 20:11:00 CST 2019
     */
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}