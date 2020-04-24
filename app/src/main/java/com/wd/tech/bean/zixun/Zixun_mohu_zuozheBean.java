package com.wd.tech.bean.zixun;

import java.util.List;

/**
 * @author 邓先超
 * @date 2020/4/23 21:20
 */
public class Zixun_mohu_zuozheBean {

    /**
     * result : [{"id":4,"releaseTime":1535449854000,"source":"砍柴网","title":"最后的红利：三四五线网民时间和金钱消费报告"}]
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
         * id : 4
         * releaseTime : 1535449854000
         * source : 砍柴网
         * title : 最后的红利：三四五线网民时间和金钱消费报告
         */

        private int id;
        private long releaseTime;
        private String source;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
