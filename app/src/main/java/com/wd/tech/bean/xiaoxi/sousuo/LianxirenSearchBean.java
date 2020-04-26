package com.wd.tech.bean.xiaoxi.sousuo;

import java.util.List;

/**
 * 功能：LianxirenSearchBean类
 * 作者：闫圣豪
 * 当前日期：2020/4/25
 * 当前时间：16:33
 */
public class LianxirenSearchBean {


    /**
     * result : [{"buddySource":"我的好友","friendUid":1429,"headPic":"http://mobile.bwstudent.com/images/tech/default/tech.jpg","nickName":"丁鸿翔","pwd":"LA/0Je691M/FqyyreFL9Tyw7aV5PXcaMjUwbtuTaYFhuDNt3HrsWMWi/fjdSxqJDoPiJ72gai78jIrNfNE01BtbAZDiS2Zzu/wrRLQCmMk08pcIXEBVJq5tsk9e3bZVxAexdNpOYlRqo0OY3O1jeQ/ahyqJd5EAqsy9QHYqyKJQ=","remarkName":"丁鸿翔","userName":"NY43b315721291693"}]
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
         * buddySource : 我的好友
         * friendUid : 1429
         * headPic : http://mobile.bwstudent.com/images/tech/default/tech.jpg
         * nickName : 丁鸿翔
         * pwd : LA/0Je691M/FqyyreFL9Tyw7aV5PXcaMjUwbtuTaYFhuDNt3HrsWMWi/fjdSxqJDoPiJ72gai78jIrNfNE01BtbAZDiS2Zzu/wrRLQCmMk08pcIXEBVJq5tsk9e3bZVxAexdNpOYlRqo0OY3O1jeQ/ahyqJd5EAqsy9QHYqyKJQ=
         * remarkName : 丁鸿翔
         * userName : NY43b315721291693
         */

        private String buddySource;
        private int friendUid;
        private String headPic;
        private String nickName;
        private String pwd;
        private String remarkName;
        private String userName;

        public String getBuddySource() {
            return buddySource;
        }

        public void setBuddySource(String buddySource) {
            this.buddySource = buddySource;
        }

        public int getFriendUid() {
            return friendUid;
        }

        public void setFriendUid(int friendUid) {
            this.friendUid = friendUid;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getRemarkName() {
            return remarkName;
        }

        public void setRemarkName(String remarkName) {
            this.remarkName = remarkName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}
