package com.wd.tech.bean.xiaoxi;

import java.util.List;

/**
 * 功能：FenzuBean类
 * 作者：闫圣豪
 * 当前日期：2020/4/24
 * 当前时间：15:51
 */
public class FenzuBean {


    /**
     * result : [{"black":1,"currentNumber":2,"customize":1,"groupId":3034,"groupName":"我的好友"},{"black":2,"currentNumber":0,"customize":1,"groupId":3035,"groupName":"黑名单"}]
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
         * black : 1
         * currentNumber : 2
         * customize : 1
         * groupId : 3034
         * groupName : 我的好友
         */

        private int black;
        private int currentNumber;
        private int customize;
        private int groupId;
        private String groupName;

        public int getBlack() {
            return black;
        }

        public void setBlack(int black) {
            this.black = black;
        }

        public int getCurrentNumber() {
            return currentNumber;
        }

        public void setCurrentNumber(int currentNumber) {
            this.currentNumber = currentNumber;
        }

        public int getCustomize() {
            return customize;
        }

        public void setCustomize(int customize) {
            this.customize = customize;
        }

        public int getGroupId() {
            return groupId;
        }

        public void setGroupId(int groupId) {
            this.groupId = groupId;
        }

        public String getGroupName() {
            return groupName;
        }

        public void setGroupName(String groupName) {
            this.groupName = groupName;
        }
    }
}
