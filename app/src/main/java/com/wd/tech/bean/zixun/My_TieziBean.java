package com.wd.tech.bean.zixun;

import java.util.List;

/**
 * @author 邓先超
 * @date 2020/4/25 23:40
 */
public class My_TieziBean {

    /**
     * result : [{"communityUserPostVoList":[{"comment":0,"content":"666","file":"http://mobile.bwstudent.com/images/tech/community_pic/2020-04-25/2657320200425203727.png","id":1937,"praise":0,"whetherGreat":2},{"comment":0,"content":"请问请问","file":"","id":1909,"praise":0,"whetherGreat":2},{"comment":0,"content":"请问请问","file":"","id":1908,"praise":0,"whetherGreat":2},{"comment":0,"content":"请问请问","file":"","id":1906,"praise":0,"whetherGreat":2},{"comment":0,"content":"请问请问","file":"http://mobile.bwstudent.com/images/tech/community_pic/2020-04-23/6794120200423165352.png","id":1904,"praise":0,"whetherGreat":2},{"comment":4,"content":"真秀","file":"http://mobile.bwstudent.com/images/tech/community_pic/2020-04-23/8361420200423163129.png","id":1903,"praise":0,"whetherGreat":2}],"communityUserVo":{"headPic":"http://mobile.bwstudent.com/images/tech/default/tech.jpg","nickName":"小小科技","power":1,"signature":"666","userId":1384,"whetherFollow":2,"whetherMyFriend":2}}]
     * message : 查詢成功
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
         * communityUserPostVoList : [{"comment":0,"content":"666","file":"http://mobile.bwstudent.com/images/tech/community_pic/2020-04-25/2657320200425203727.png","id":1937,"praise":0,"whetherGreat":2},{"comment":0,"content":"请问请问","file":"","id":1909,"praise":0,"whetherGreat":2},{"comment":0,"content":"请问请问","file":"","id":1908,"praise":0,"whetherGreat":2},{"comment":0,"content":"请问请问","file":"","id":1906,"praise":0,"whetherGreat":2},{"comment":0,"content":"请问请问","file":"http://mobile.bwstudent.com/images/tech/community_pic/2020-04-23/6794120200423165352.png","id":1904,"praise":0,"whetherGreat":2},{"comment":4,"content":"真秀","file":"http://mobile.bwstudent.com/images/tech/community_pic/2020-04-23/8361420200423163129.png","id":1903,"praise":0,"whetherGreat":2}]
         * communityUserVo : {"headPic":"http://mobile.bwstudent.com/images/tech/default/tech.jpg","nickName":"小小科技","power":1,"signature":"666","userId":1384,"whetherFollow":2,"whetherMyFriend":2}
         */

        private CommunityUserVoBean communityUserVo;
        private List<CommunityUserPostVoListBean> communityUserPostVoList;

        public CommunityUserVoBean getCommunityUserVo() {
            return communityUserVo;
        }

        public void setCommunityUserVo(CommunityUserVoBean communityUserVo) {
            this.communityUserVo = communityUserVo;
        }

        public List<CommunityUserPostVoListBean> getCommunityUserPostVoList() {
            return communityUserPostVoList;
        }

        public void setCommunityUserPostVoList(List<CommunityUserPostVoListBean> communityUserPostVoList) {
            this.communityUserPostVoList = communityUserPostVoList;
        }

        public static class CommunityUserVoBean {
            /**
             * headPic : http://mobile.bwstudent.com/images/tech/default/tech.jpg
             * nickName : 小小科技
             * power : 1
             * signature : 666
             * userId : 1384
             * whetherFollow : 2
             * whetherMyFriend : 2
             */

            private String headPic;
            private String nickName;
            private int power;
            private String signature;
            private int userId;
            private int whetherFollow;
            private int whetherMyFriend;

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

            public int getPower() {
                return power;
            }

            public void setPower(int power) {
                this.power = power;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
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

            public int getWhetherMyFriend() {
                return whetherMyFriend;
            }

            public void setWhetherMyFriend(int whetherMyFriend) {
                this.whetherMyFriend = whetherMyFriend;
            }
        }

        public static class CommunityUserPostVoListBean {
            /**
             * comment : 0
             * content : 666
             * file : http://mobile.bwstudent.com/images/tech/community_pic/2020-04-25/2657320200425203727.png
             * id : 1937
             * praise : 0
             * whetherGreat : 2
             */

            private int comment;
            private String content;
            private String file;
            private int id;
            private int praise;
            private int whetherGreat;

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

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getPraise() {
                return praise;
            }

            public void setPraise(int praise) {
                this.praise = praise;
            }

            public int getWhetherGreat() {
                return whetherGreat;
            }

            public void setWhetherGreat(int whetherGreat) {
                this.whetherGreat = whetherGreat;
            }
        }
    }
}
