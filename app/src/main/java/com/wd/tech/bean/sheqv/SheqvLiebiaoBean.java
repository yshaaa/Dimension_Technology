package com.wd.tech.bean.sheqv;

import java.util.List;

/**
 * 功能：SheqvLiebiaoBean类
 * 作者：闫圣豪
 * 当前日期：2020/4/21
 * 当前时间：15:14
 */
public class SheqvLiebiaoBean {


    /**
     * result : [{"comment":1,"communityCommentVoList":[{"content":"奥利给","nickName":"花花23","userId":1414}],"content":"奥利给","file":"http://mobile.bwstudent.com/images/tech/community_pic/2020-04-21/0745820200421141329.png","headPic":"http://mobile.bwstudent.com/images/tech/default/tech.jpg","id":1897,"nickName":"花花23","praise":1,"publishTime":1587449609000,"userId":1414,"whetherFollow":2,"whetherGreat":1,"whetherVip":2},{"comment":0,"communityCommentVoList":[],"content":"你品你细品","file":"http://mobile.bwstudent.com/images/tech/community_pic/2020-04-20/8059420200420204831.png","headPic":"http://mobile.bwstudent.com/images/tech/head_pic/2020-04-20/20200420172724.png","id":1896,"nickName":"android小老弟","praise":0,"publishTime":1587386911000,"userId":1416,"whetherFollow":2,"whetherGreat":2,"whetherVip":2},{"comment":0,"communityCommentVoList":[],"content":"你品你细品","file":"http://mobile.bwstudent.com/images/tech/community_pic/2020-04-20/0389720200420204542.png","headPic":"http://mobile.bwstudent.com/images/tech/head_pic/2020-04-20/20200420172724.png","id":1895,"nickName":"android小老弟","praise":0,"publishTime":1587386742000,"userId":1416,"whetherFollow":2,"whetherGreat":2,"whetherVip":2},{"comment":0,"communityCommentVoList":[],"content":"瓦大大啊大大阿达瓦大","file":"","headPic":"http://mobile.bwstudent.com/images/tech/head_pic/2020-04-17/20200417204020.png","id":1894,"nickName":"幻影月缺醉几何","praise":0,"publishTime":1587375549000,"signature":"一起走向科技","userId":1383,"whetherFollow":2,"whetherGreat":2,"whetherVip":2},{"comment":1,"communityCommentVoList":[{"content":"图片很好","nickName":"xte","userId":1412}],"content":"这是我的帖子第二篇帖子","file":"http://mobile.bwstudent.com/images/tech/community_pic/2020-04-20/1085320200420135923.jpg","headPic":"http://mobile.bwstudent.com/images/tech/head_pic/2020-04-20/20200420155039.png","id":1893,"nickName":"xte","praise":1,"publishTime":1587362363000,"signature":"哈哈哈","userId":1412,"whetherFollow":2,"whetherGreat":2,"whetherVip":2}]
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
         * comment : 1
         * communityCommentVoList : [{"content":"奥利给","nickName":"花花23","userId":1414}]
         * content : 奥利给
         * file : http://mobile.bwstudent.com/images/tech/community_pic/2020-04-21/0745820200421141329.png
         * headPic : http://mobile.bwstudent.com/images/tech/default/tech.jpg
         * id : 1897
         * nickName : 花花23
         * praise : 1
         * publishTime : 1587449609000
         * userId : 1414
         * whetherFollow : 2
         * whetherGreat : 1
         * whetherVip : 2
         * signature : 一起走向科技
         */

        private int comment;
        private String content;
        private String file;
        private String headPic;
        private int id;
        private String nickName;
        private int praise;
        private long publishTime;
        private int userId;
        private int whetherFollow;
        private int whetherGreat;
        private int whetherVip;
        private String signature;
        private List<CommunityCommentVoListBean> communityCommentVoList;

        public int getComment() {
            return comment;
        }

        public void setComment(int comment) {
            this.comment = comment;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getFile() {
            return file;
        }

        public void setFile(String file) {
            this.file = file;
        }

        public String getHeadPic() {
            return headPic;
        }

        public void setHeadPic(String headPic) {
            this.headPic = headPic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getPraise() {
            return praise;
        }

        public void setPraise(int praise) {
            this.praise = praise;
        }

        public long getPublishTime() {
            return publishTime;
        }

        public void setPublishTime(long publishTime) {
            this.publishTime = publishTime;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getWhetherFollow() {
            return whetherFollow;
        }

        public void setWhetherFollow(int whetherFollow) {
            this.whetherFollow = whetherFollow;
        }

        public int getWhetherGreat() {
            return whetherGreat;
        }

        public void setWhetherGreat(int whetherGreat) {
            this.whetherGreat = whetherGreat;
        }

        public int getWhetherVip() {
            return whetherVip;
        }

        public void setWhetherVip(int whetherVip) {
            this.whetherVip = whetherVip;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public List<CommunityCommentVoListBean> getCommunityCommentVoList() {
            return communityCommentVoList;
        }

        public void setCommunityCommentVoList(List<CommunityCommentVoListBean> communityCommentVoList) {
            this.communityCommentVoList = communityCommentVoList;
        }

        public static class CommunityCommentVoListBean {
            /**
             * content : 奥利给
             * nickName : 花花23
             * userId : 1414
             */

            private String content;
            private String nickName;
            private int userId;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getNickName() {
                return nickName;
            }

            public void setNickName(String nickName) {
                this.nickName = nickName;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }
        }
    }
}
