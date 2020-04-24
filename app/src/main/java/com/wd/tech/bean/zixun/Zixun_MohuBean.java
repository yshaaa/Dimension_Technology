package com.wd.tech.bean.zixun;

import java.util.List;

/**
 * @author 邓先超
 * @date 2020/4/23 19:14
 */
public class Zixun_MohuBean {


    /**
     * result : [{"id":68,"releaseTime":1573023083000,"source":"ITBEAR科技资讯","title":"诺基亚与三大运营商分别签约，总价值157亿元"},{"id":65,"releaseTime":1572763883000,"source":"ITBEAR科技资讯","title":"2019年Q3智能音箱数据发布，天猫精灵再次国内第一"},{"id":62,"releaseTime":1553064558000,"source":"亚马逊网","title":"亚马逊：用AI瞄准全球10万亿美元的医疗健康大机遇"},{"id":60,"releaseTime":1553063676000,"source":"侏罗纪","title":"威胁不止有51%攻击，区块链为何频遭黑客入侵？"},{"id":59,"releaseTime":1553063316000,"source":"科技行者","title":"中国移动亮相2019世界移动大会 展示5G发展计划并推出首款自主品牌5G终端"},{"id":45,"releaseTime":1539574363000,"source":"IT桔子","title":"区块链媒体半年融资超11亿，昨晚被封了好几家"},{"id":40,"releaseTime":1539400915000,"source":"盖世汽车资讯","title":"戴姆勒合作博世 2019年底在加州城市交通中测试完全自动驾驶汽车"},{"id":34,"releaseTime":1539395910000,"source":"砍柴网","title":"到2020年全球1/3的消费者将使用VR"},{"id":13,"releaseTime":1539054007000,"source":"人人都是产品经理","title":"外卖天天满25减21，商家们都是怎么挣钱的？"}]
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
         * id : 68
         * releaseTime : 1573023083000
         * source : ITBEAR科技资讯
         * title : 诺基亚与三大运营商分别签约，总价值157亿元
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
