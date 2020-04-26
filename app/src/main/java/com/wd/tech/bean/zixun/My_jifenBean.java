package com.wd.tech.bean.zixun;

import java.util.List;

/**
 * @author 邓先超
 * @date 2020/4/25 22:34
 */
public class My_jifenBean {

    /**
     * result : [{"amount":10,"createTime":1587819003000,"direction":1,"type":2},{"amount":20,"createTime":1587818252000,"direction":1,"type":9},{"amount":20,"createTime":1587818247000,"direction":1,"type":4},{"amount":10,"createTime":1587630726000,"direction":1,"type":2},{"amount":20,"createTime":1587630689000,"direction":1,"type":4},{"amount":10,"createTime":1587457344000,"direction":1,"type":1}]
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
         * amount : 10
         * createTime : 1587819003000
         * direction : 1
         * type : 2
         */

        private int amount;
        private long createTime;
        private int direction;
        private int type;

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public int getDirection() {
            return direction;
        }

        public void setDirection(int direction) {
            this.direction = direction;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
