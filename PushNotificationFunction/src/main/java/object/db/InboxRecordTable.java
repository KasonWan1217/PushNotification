package object.db;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;

@DynamoDBTable(tableName = "InboxRecordDBTable")
public class InboxRecordTable {
    private String message_id;
    private String push_timestamp;
    private String targetArn;
    private String targetArnType;
    private Message message;
    private String actionCategory;
    private int badge;
    private String sound;
    private String picUrl;
    private int directMsg;
    private String message_qty;

    public InboxRecordTable(String json) {
        InboxRecordTable request = new Gson().fromJson(json, InboxRecordTable.class);
        this.message = request.getMessage();
        this.targetArn = request.getTargetArn();
        this.targetArnType = request.getTargetArnType();
        this.actionCategory = request.getActionCategory();
        this.badge = request.getBadge();
        this.sound = request.getSound();
        this.push_timestamp = request.getPush_timestamp();
        this.picUrl = request.getPicUrl();
        this.directMsg = request.getDirectMsg();
    }

//@DynamoDBIgnore

    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName="message_id")
    public String getMessage_id() {
        return message_id;
    }
    public void setMessage_id(String message_id) {
        this.message_id = message_id;
    }

    @DynamoDBRangeKey
    @DynamoDBAttribute(attributeName="push_timestamp")
    public String getPush_timestamp() {
        return push_timestamp;
    }

    public void setPush_timestamp(String push_timestamp) {
        this.push_timestamp = push_timestamp;
    }

    @DynamoDBAttribute(attributeName="targetArn")
    public String getTargetArn() {
        return targetArn;
    }
    public void setTargetArn(String targetArn) {
        this.targetArn = targetArn;
    }

    @DynamoDBAttribute(attributeName="targetArnType")
    public String getTargetArnType() {
        return targetArnType;
    }
    public void setTargetArnType(String targetArnType) {
        this.targetArnType = targetArnType;
    }

    @DynamoDBAttribute(attributeName="message")
    public Message getMessage() {
        return message;
    }
    public void setMessage(Message message) {
        this.message = message;
    }

    @DynamoDBAttribute(attributeName="actionCategory")
    public String getActionCategory() {
        return actionCategory;
    }
    public void setActionCategory(String actionCategory) {
        this.actionCategory = actionCategory;
    }

    @DynamoDBAttribute(attributeName="badge")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int getBadge() {
        return badge;
    }
    public void setBadge(int badge) {
        this.badge = badge;
    }

    @DynamoDBAttribute(attributeName="sound")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String getSound() {
        return sound;
    }
    public void setSound(String sound) {
        this.sound = sound;
    }

    @DynamoDBAttribute(attributeName="picUrl")
    public String getPicUrl() {
        return picUrl;
    }
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    @DynamoDBAttribute(attributeName="directMsg")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public int getDirectMsg() {
        return directMsg;
    }

    public void setDirectMsg(int directMsg) {
        this.directMsg = directMsg;
    }

    @DynamoDBAttribute(attributeName="message_qty")
    public String getMessage_qty() {
        return message_qty;
    }

    public void setMessage_qty(String message_qty) {
        this.message_qty = message_qty;
    }

    @DynamoDBDocument
    public class Message {
        private String title;
        private String subtitle;
        private String body;

        public String getTitle() {
            return title;
        }

        public String getSubtitle() {
            return subtitle;
        }

        public String getBody() {
            return body;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setSubtitle(String subtitle) {
            this.subtitle = subtitle;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String convertToJsonString() {
            return new Gson().toJson(this);
        }
    }

    public String convertToJsonString() {
        return new Gson().toJson(this);
    }
}