package com.bwie.sj.onetime_sj.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/03/23.
 */

public class JokeBean {

    /**
     * msg : 获取段子列表成功
     * code : 0
     * data : [{"commentNum":null,"content":"大伙都符合东方红","createTime":"2018-03-21T17:17:12","imgUrls":null,"jid":1540,"praiseNum":null,"shareNum":null,"uid":10842,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"的时刻该射击大概就是的价格几个人给人家给","createTime":"2018-03-21T16:43:11","imgUrls":null,"jid":1539,"praiseNum":null,"shareNum":null,"uid":10842,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":"\"方经发局\"","createTime":"2018-03-21T15:16:12","imgUrls":null,"jid":1538,"praiseNum":null,"shareNum":null,"uid":10842,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}},{"commentNum":null,"content":", 你好","createTime":"2018-03-09T20:10:40","imgUrls":null,"jid":1537,"praiseNum":null,"shareNum":null,"uid":4212,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"叫我昊哥好吗！","praiseNum":"null"}},{"commentNum":null,"content":"带图","createTime":"2018-02-28T14:24:47","imgUrls":"https://www.zhaoapi.cn/images/quarter/15197990871861519799086076641.jpg","jid":1536,"praiseNum":null,"shareNum":null,"uid":149,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/149.jpg","nickname":"Yw","praiseNum":"null"}},{"commentNum":null,"content":"哈哈哈","createTime":"2018-02-26T19:57:50","imgUrls":null,"jid":1535,"praiseNum":null,"shareNum":null,"uid":149,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/149.jpg","nickname":"Yw","praiseNum":"null"}},{"commentNum":null,"content":"你习惯了人前坚强，\n因为不想你的悲伤被人嘲笑。\n你习惯了笑脸相迎，\n因为不想你的泪水惹人烦心。\n可总有几个真心对你的人，\n让你的泪水流泻如虹，\n让你的坚强瞬间崩塌！","createTime":"2018-02-26T12:54:00","imgUrls":null,"jid":1534,"praiseNum":null,"shareNum":null,"uid":3881,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/1517574153932AndroidFightingIphone3.png","nickname":"我不是杨犊子","praiseNum":"null"}},{"commentNum":null,"content":"王顺","createTime":"2018-02-13T21:55:14","imgUrls":null,"jid":1533,"praiseNum":null,"shareNum":null,"uid":2944,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15172712697535A818A97940CB355126540DF0D58CDC0.png","nickname":"全村人的希望","praiseNum":"null"}},{"commentNum":null,"content":"吧vvv","createTime":"2018-02-13T13:34:11","imgUrls":null,"jid":1532,"praiseNum":null,"shareNum":null,"uid":2944,"user":{"age":null,"fans":"null","follow":false,"icon":"https://www.zhaoapi.cn/images/15172712697535A818A97940CB355126540DF0D58CDC0.png","nickname":"全村人的希望","praiseNum":"null"}},{"commentNum":null,"content":"121321","createTime":"2018-02-10T11:52:16","imgUrls":null,"jid":1531,"praiseNum":null,"shareNum":null,"uid":11275,"user":{"age":null,"fans":"null","follow":false,"icon":null,"nickname":"吴子敬","praiseNum":"null"}}]
     */

    private String msg;
    private String code;
    private List<DataBean> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * commentNum : null
         * content : 大伙都符合东方红
         * createTime : 2018-03-21T17:17:12
         * imgUrls : null
         * jid : 1540
         * praiseNum : null
         * shareNum : null
         * uid : 10842
         * user : {"age":null,"fans":"null","follow":false,"icon":null,"nickname":null,"praiseNum":"null"}
         */

        private Object commentNum;
        private String content;
        private String createTime;
        private Object imgUrls;
        private int jid;
        private Object praiseNum;
        private Object shareNum;
        private int uid;
        private UserBean user;

        public Object getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(Object commentNum) {
            this.commentNum = commentNum;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public Object getImgUrls() {
            return imgUrls;
        }

        public void setImgUrls(Object imgUrls) {
            this.imgUrls = imgUrls;
        }

        public int getJid() {
            return jid;
        }

        public void setJid(int jid) {
            this.jid = jid;
        }

        public Object getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(Object praiseNum) {
            this.praiseNum = praiseNum;
        }

        public Object getShareNum() {
            return shareNum;
        }

        public void setShareNum(Object shareNum) {
            this.shareNum = shareNum;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public static class UserBean {
            /**
             * age : null
             * fans : null
             * follow : false
             * icon : null
             * nickname : null
             * praiseNum : null
             */

            private Object age;
            private String fans;
            private boolean follow;
            private Object icon;
            private Object nickname;
            private String praiseNum;

            public Object getAge() {
                return age;
            }

            public void setAge(Object age) {
                this.age = age;
            }

            public String getFans() {
                return fans;
            }

            public void setFans(String fans) {
                this.fans = fans;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public Object getIcon() {
                return icon;
            }

            public void setIcon(Object icon) {
                this.icon = icon;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public String getPraiseNum() {
                return praiseNum;
            }

            public void setPraiseNum(String praiseNum) {
                this.praiseNum = praiseNum;
            }
        }
    }
}
