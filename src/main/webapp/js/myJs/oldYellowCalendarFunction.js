/**
 * 行星产物页面相关js
 */
/**
 *EVE老黄历原始程序作者  fake_faith
 *原作者 twitter： @fake_faith  原APP名为：程序员老黄历
 *由 Linodas.com 莉诺雅·羽月 修改
 *本APP放置于Linodas.com 测试服务器上。
 *PS:然后又被一个工作量不饱和的程序猿玩家 星际奏者 搬运至 军团自用的网站上
 *
 *
 *
 *EVE老黄历属于 ** 自由软件 ** ，遵循GPL通用许可证发布。
 *
 *转载本程序无需注明来自 Linodas
 *可自由复制并修改本页所有源码，并发布在你自己的网站上，允许自由嵌入到任何第三方客户端
 *
 *无需保留 Linodas.com 的版权声明
 *无需保留 修改者（莉诺雅·羽月）的名字
 *
 * 以上为Linodas.com网站的声明，出于对同行的尊重，还是将以上信息留于此处
 * @type {{today: Date, iday: *, weeks: [string,string,string,string,string,string,string], directions: [string,string,string,string,string,string,string,string], activities: [null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null], specials: [null], tools: Array, varNames: Array, spaces: [string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string], ships: [string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string,string], getTodayString: oldYellowCalendar.getTodayString, random: oldYellowCalendar.random, pickRandomActivity: oldYellowCalendar.pickRandomActivity, pickRandom: oldYellowCalendar.pickRandom, pickTodaysLuck: oldYellowCalendar.pickTodaysLuck}}
 */
var oldYellowCalendar = {
    today: new Date(),
    iday: 5201314,
    weeks: ["日", "一", "二", "三", "四", "五", "六"],
    directions: ["北方", "东北方", "东方", "东南方", "南方", "西南方", "西方", "西北方"],
    activities: [
        {name: "高安任务", good: "全出腹背受敌", bad: "拉暴动被反跳掉线"},
        {name: "刷异常", good: "传说一跳破5k", bad: "刚拉暴动就断网"},
        {name: "蹲站", good: "今天WoW更新版本", bad: "错过羊神发福利"},
        {name: "挖矿", good: "矿涨价比房价还快", bad: "红星蹲驻地星门了"},
        {name: "打入侵", good: "统合部LP又涨价了", bad: "后勤又断传电了"},
        {name: "打洞", good: "闭着眼睛数钱", bad: "洞主了！"},
        {name: "翻合同", good: "有人填错数字，赚到了", bad: "手一抖买了个金鹏子系统书"},
        {name: "参观战场", good: "人品爆发捡了个杆子", bad: "蛋都保不住了同学"},
        {name: "多开", good: "横扫5级不解释", bad: "不小心打到自己被筒子部端了"},
        {name: "T1船制造", good: "王师出货中", bad: "反正肥的快都垄断了"},
        {name: "会战", good: "怒抓一条泰坦", bad: "互蹲星门到半夜下线"},
        {name: "堵门", good: "有人运一船PLEX自动导航", bad: "蹲一晚上秒睡了然后损了"},
        {name: "吃肉", good: "又有金鹏秒睡了", bad: "那个噩梦是永动装肉"},
        {name: "考古", good: "势力POS图纸！", bad: "没捡到势力POS图纸！人生还有什么意义！"},
        {name: "KFC", good: "全家桶网上订餐有优惠", bad: "总监要查账"},
        {name: "低安任务", good: "本地就一人简直开心", bad: "遇一隐轰，船蛋双飞"},
        {name: "跑货", good: "这个时间没人抓你", bad: "出门就被堵死了"},
        {name: "刷死亡", good: "小B大C潜龙图", bad: "不好意思，双子妥妥的"},
        {name: "T2制造", good: "知道啥叫出货战争吗", bad: "还嫌TC送得不够多？"},
        {name: "拆迁", good: "壮哉我多炮塔神教", bad: "别人早就跳旗舰回来守家了"},
        {name: "守官员", good: "AMM全抗妥妥的", bad: "双子，你懂的"},
        {name: "偷运", good: "学好吉他秒跳红减堵门也不怕", bad: "居然有秒锁重拦不科学啊"},
        {name: "收割", good: "异常秒睡党数不胜数", bad: "N跳外就被发现了"},
        {name: "打捞", good: "就是要捞出一艘泰坦的男人啊", bad: "突然刷个怪没看见，损"},
        {name: "塔玛观光", good: "海盗都没起床", bad: "这还用问？"},
        {name: "高安宣战", good: "又有新鲜的肉啦", bad: "被疯狂的新人围剿"},
        {name: "带路", good: "王师，这边走！", bad: "被王师爆了"},
        {name: "行星开发", good: "一片茫茫白色区", bad: "辛苦半天不如别人一顿KFC"},
        {name: "发明", good: "10条线红了9条，还都是N流程的", bad: "熊老师上线了"},
        {name: "1024", good: "你懂的", bad: "强撸船飞蛋灭"},
        {name: "挖气云", good: "低调的暴利行业", bad: "没人买药"},
        {name: "泡YY", good: "哟，萌妹子", bad: "给新人讲解了半天对方表示刚睡着了"},
        {name: "DOTA", good: "妹子放一边，基友围一圈", bad: "注定孤独一生"},
        {name: "坦克世界", good: "我们击穿了对方装甲", bad: "误国"},
        {name: "刷微博", good: "新闻八卦不容错过", bad: "你获得了50点负能量"},
        {name: "EFT", good: "EFT是EVE的一部分为什么就是不明白", bad: "忘记上线换技能"},
        {name: "炒货", good: "水硼砂我会乱说？", bad: "还轮得到你么"},
        {name: "刷A/B站", good: "专注新番三十年", bad: "切回来就只剩蛋了"},
        {name: "刷ECF", good: "主席夸我政工强！", bad: "切回来就只剩蛋了"}
        //{name:"扫货", good:"物美价廉大优惠",bad:"会遇到肥得快奸商"}


    ],
    specials: [
        {}
    ],
    tools: [],
    varNames: [],
    spaces: ['血脉星域', '德克廉星域', '斐德星域', '对舞之域', '黑渊星域', '特纳', '特布特星域', '静寂谷星域', '维纳尔星域', '地窖星域', '卡彻星域', '柯尔斯星域', '底特里德', '埃索特亚', '非塔波利斯', '大荒野星域', '伊梅瑟亚', '绝径星域', '因斯姆尔', '欧米斯特', '摄魂之域', '普罗维登斯', '灼热之径', '混浊星域', '特里菲斯', '邪恶湾流', '云环星域', '绝地之域', '源泉之域', '外环星域', '贝斯星域', '逑瑞斯星域', '辛迪加', '域外走廊', '琉蓝之穹', '卡勒瓦拉阔地', '欧莎', '钴蓝边域', '糟粕之域', '佩利根弗', '螺旋之域'],
    ships: ["分裂者级", "爆发级", "探索级", "裂谷级", "伐木者级", "守夜者级", "阿特龙级", "伊米卡斯级", "因卡萨斯级", "毛鲁斯级", "纳维达斯级", "特里斯坦级", "磨难级", "刽子手级", "检察官级", "惩罚者级", "巨神兵级", "矮脚鸡级", "秃鹫级", "狮鹫级", "苍鹭级", "茶隼级", "小鹰级", "利爪级", "短剑级", "阿瑞斯级", "塔纳尼斯级", "十字军级", "咒灭级", "黑鸦级", "猛禽级", "美洲虎级", "猎狼级", "恩尤级", "伊什库尔级", "审判者级", "复仇级", "女妖级", "战鹰级", "猎豹级", "猎犬级", "太阳神级", "纳美西斯级", "咒逐级", "净化级", "秃鹰级", "蝎尾怪级", "土狼级", "克勒斯级", "哨兵级", "斯芬尼克斯级", "长尾鲛级", "促进级", "强制者级", "海燕级", "剑齿虎级", "厄里斯级", "异端级", "飞燕级", "挑战级", "断崖级", "镰刀级", "刺客级", "星空级", "送葬者级", "托勒克斯级", "狂怒者级", "主宰级", "奥格诺级", "林荫级", "启示级", "黑鸟级", "狞獾级", "巨鸟级", "鱼鹰级", "休津级", "长剑级", "埃拉兹级", "拉克希斯级", "诅咒级", "朝圣级", "战隼级", "白嘴鸦级", "阔刀级", "伏波斯级", "奉献级", "奥尼克斯级", "缪宁级", "流浪级", "戴默斯级", "伊什塔级", "渎圣级", "狂热级", "希尔博拉斯级", "银鹰级", "曲剑级", "奥内罗斯级", "守卫级", "皇冠蜥级", "飓风级", "暴风级", "布鲁提克斯级", "弥洱米顿级", "先知级", "先驱者级", "猛鲑级", "幼龙级", "月刃级", "斯雷普尼级", "阿施塔特级", "曙光女神级", "救赎级", "永灭级", "夜鹰级", "兀鹫级", "狂暴级", "台风级", "死亡漩涡级", "多米尼克斯级", "万王宝座级", "亥伯龙神级", "灾难级", "末日沙场级", "地狱天使级", "乌鸦级", "毒蝎级", "鹏鲲级", "黑豹级", "罪恶级", "救世级", "寡妇级", "恶狼级", "克洛诺斯级", "帕拉丁级", "魔像级", "拉格纳洛克级", "俄洛巴斯级", "神使级", "勒维亚坦级", "纳迦法级", "莫洛级", "神示级", "凤凰级", "冥府级", "尼铎格尔级", "夜神级", "绝念级", "万古级", "执政官级", "奇美拉级", "飞龙级", "巨象级", "徘徊者级", "奥卡托级", "旅行者级", "激进级", "分裂级", "大鸨级", "天鹤级"],
    getTodayString: function () {
        return "今天是" + today.getFullYear() + "年" + (today.getMonth() + 1) + "月" + today.getDate() + "日 星期" + weeks[today.getDay()];
    },
    random: function (dayseed, indexseed) {
        var n = dayseed % 11117;
        for (var i = 0; i < 100 + indexseed; i++) {
            n = n * n;
            n = n % 11117;   // 11117 是个质数
        }
        return n;
    },
    // /**
    //  * 添加预定义事件
    //  * @private
    //  * @returns {[number,number]}
    //  */
    // pickSpecials: function () {
    //     var specialSize = [0, 0];
    //
    //     for (var i = 0; i < this.specials.length; i++) {
    //         var special = this.specials[i];
    //
    //         if (iday == special.date) {
    //             if (special.type == 'good') {
    //                 specialSize[0]++;
    //                 addToGood({name: special.name, good: special.description});
    //             } else {
    //                 specialSize[1]++;
    //                 addToBad({name: special.name, bad: special.description});
    //             }
    //         }
    //     }
    //     return specialSize;
    // },
    /**
     * 从 activities 中随机挑选 size 个
     * @private
     * @param size
     * @returns {*}
     */
    pickRandomActivity: function (size) {
        var picked_events = this.pickRandom(this.activities, size);

        // for (var i = 0; i < picked_events.length; i++) {
        //     picked_events[i] = parse(picked_events[i]);
        // }

        return picked_events;
    },
    // 从数组中随机挑选 size 个
    pickRandom: function (array, size) {
        var result = [];

        for (var i = 0; i < array.length; i++) {
            result.push(array[i]);
        }

        for (var j = 0; j < array.length - size; j++) {
            var index = this.random(this.iday, j) % result.length;
            result.splice(index, 1);
        }

        return result;
    },
    /**
     * 主方法
     * @param year
     * @param month
     * @param day
     */
    pickTodaysLuck: function (year, month, day) {
        if (year && month && day) {
            this.iday = year * 10000 + (month + 1) * 100 + day;
        } else {
            this.iday = this.today.getFullYear() * 10000 + (this.today.getMonth() + 1) * 100 + this.today.getDate();
        }
        var numGood = this.random(this.iday, 98) % 3 + 2;
        var numBad = this.random(this.iday, 87) % 3 + 2;
        var eventArr = this.pickRandomActivity(numGood + numBad);

        //var specialSize = this.pickSpecials();
        var goodEvent = [];
        var badEvent = [];
        for (var i = 0; i < numGood; i++) {
            goodEvent[i] = eventArr[i];
        }

        for (var i = 0; i < numBad; i++) {
            badEvent[i] = eventArr[numGood + i];
        }
        return {"good": goodEvent,"bad": badEvent};
    }
};