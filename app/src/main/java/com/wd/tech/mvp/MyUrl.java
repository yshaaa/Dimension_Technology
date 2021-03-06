package com.wd.tech.mvp;

/**
 * 功能：MyUrl类
 * 作者：闫圣豪
 * 当前日期：2020/04/17
 * 当前时间：11:04
 */
public interface MyUrl {
    //外网
    String base="https://mobile.bwstudent.com/";



    String BASE_DL="techApi/user/v1/login";

    String BASE_ZC="techApi/user/v1/register";





    //社区
    String sheqvliebiao="techApi/community/v1/findCommunityList";
    //社区点赞
    String sheqvdianzan="techApi/community/verify/v1/addCommunityGreat";
    //社区取消点赞
    String sheqvqvxiaodianzan="techApi/community/verify/v1/cancelCommunityGreat";
    //社区发布帖子
    String sheqvfabutiezi="techApi/community/verify/v1/releasePost";





    //消息
    //消息分组
    String xiaoxifenzu="techApi/chat/verify/v1/findFriendGroupList";
    //消息分组好友
    String fenzuhaoyou="techApi/chat/verify/v1/findFriendListByGroupId";



    //轮播
    String BASE_ZiXun_LunBo="techApi/information/v1/bannerShow";


    //资讯列表
    String BASE_Zixun="techApi/information/v1/infoRecommendList";










    //资讯详情
    String BASE_ZixunXQ="techApi/information/v1/findInformationDetails";

    String BASE_Zixun_Bankuai="techApi/information/v1/findAllInfoPlate";

    //模糊查询
    String BASE_Zixun_Mohu="techApi/information/v1/findInformationByTitle";

    //模糊查询作者
    String BASE_Zixun_Zuozhe="techApi/information/v1/findInformationBySource";

    //资讯评论列表
    String BASE_Zixun_Plliebiao="techApi/information/v1/findAllInfoCommentList";


    //资讯评论
    String BASE_Zixun_Pl="techApi/information/verify/v1/addInfoComment";
    //我的收藏
    String BASE_Shoucang="techApi/user/verify/v1/findAllInfoCollection";
    //我的通知
    String BASE_Tongzhi="techApi/tool/verify/v1/findSysNoticeList";
    //我的帖子
    String BASE_Tiezi="techApi/community/verify/v1/findUserPostById";
    //我的积分明细
    String BASe_Jifen_Mx="techApi/user/verify/v1/findUserIntegralRecord";
    //修改密码
    String BASE_Xiugai_pwd="techApi/user/verify/v1/modifyUserPwd";
    //点赞成功
    String BASE_Dianzan_true="techApi/information/verify/v1/addGreatRecord";
    //取消点赞
    String BASE_Dianzan_false="techApi/information/verify/v1/cancelGreat";
    //收藏
    String BASE_SC="techApi/user/verify/v1/addCollection";
    //取消收藏
    String BASE_F_SC="techApi/user/verify/v1/cancelCollection";

    String BASE_a="techApi/information/v1/findInfoAdvertising";
    //积分兑换
    String BASE_jf_dh="techApi/information/verify/v1/infoPayByIntegral";

    String BASE_VIP="techApi/tool/v1/findVipCommodityList";

    //购买
    String BASE_Gm="techApi/tool/verify/v1/buyVip";

//支付
    String BASE_Zhifu="techApi/tool/verify/v1/pay";






    //闫圣豪去130+去写.................................................
    //闫圣豪去130+去写.................................................
    //闫圣豪去130+去写.................................................































    //闫圣豪去130+去写.................................................

    //消息搜索好友
    String xiaoxisousuohaoyou="techApi/chat/verify/v1/searchFriend";
    //消息新朋友通知
    String xinpengyou="techApi/chat/verify/v1/findFriendNoticePageList";

    String chunagjian="techApi/group/verify/v1/createGroup";

    //根据手机号查找好友(找群)
    String find_people="techApi/user/verify/v1/findUserByPhone";
    //查询群组详细信息(找群)
    String find_group="techApi/group/verify/v1/findGroupInfo";
    String qunzu="techApi/group/verify/v1/findGroupsByUserId";


    //做任务
    String DO_TASK = "techApi/user/verify/v1/doTheTask";
    //签到
    String USER_SIGN = "techApi/user/verify/v1/userSign";
    //当天签到状态
    String FIND_USER_SIGN = "techApi/user/verify/v1/findUserSignStatus";
    //查询当月签到日期
    String FIND_RECORDING = "techApi/user/verify/v1/findUserSignRecording";
    //查询连续签到日期
    String SIGN_DAY = "techApi/user/verify/v1/findContinuousSignDays";
}
