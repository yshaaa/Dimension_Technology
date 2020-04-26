package com.wd.tech.bean.zixun;

import java.util.List;

/**
 * @author 邓先超
 * @date 2020/4/25 19:04
 */
public class MyTongzhiBean {

    /**
     * result : [{"content":"花花23同意了您的好友申请","createTime":1587630451000,"id":1142,"receiveUid":1384}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * content : 花花23同意了您的好友申请
         * createTime : 1587630451000
         * id : 1142
         * receiveUid : 1384
         */

        private String content;
        private long createTime;
        private int id;
        private int receiveUid;

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getReceiveUid() {
            return receiveUid;
        }

        public void setReceiveUid(int receiveUid) {
            this.receiveUid = receiveUid;
        }
    }
}
