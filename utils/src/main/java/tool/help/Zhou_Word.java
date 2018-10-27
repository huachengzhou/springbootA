package tool.help;

/**
 * create Chinese Name and English Name
 * @author Blake.Zhou
 *
 */
public class Zhou_Word {
	private final static String NAME = "艺谋雨生学良惠妹太极治尔衮庄拜尼克萨哈必隆熙承畴三桂仁宽兰明珠额图启圣琅可喜精忠正羹尧科多卫隆晓岚墉绅琳贵康安廷玉培公赐履光地廷敬成龙怀仁若望则徐天培庆光秀全秀清朝贵云山昌辉达开凤翔开芳玉成秀成文镜宣娇丰治绪统禧安昕宗棠国藩国荃永福鸿章禄之洞莲英世昌汝昌雪芹元璋基濂启善长达遇春愈和英胜亮祖友德允炆棣和铉缙广孝景辑赛儿寅征明枝山文宾梦龙承恩显祖继光嵩世蕃宗宪大猷纶瑞时珍霞客应星守仁拱居正保阶振瑾忠贤祯皇帝德皇帝启皇帝承恩圆圆献忠自成廷弼承宗崇焕文龙世贞起元可纲率教大寿睿如是香君子龙渭抒大中孝孺泰子澄";
	private final static String[] HistoryName = { "皇太极", "顺治", "多尔衮", "孝庄", "鳌拜", "索尼", "苏克萨哈", "遏必隆", "康熙", "洪承畴",
			"吴三桂", "范仁宽", "纳兰明珠", "索额图", "姚启圣", "施琅", "尚可喜", "耿精忠", "雍正", "年羹尧", "隆科多", "李卫", "乾隆", "纪晓岚", "刘墉", "和绅",
			"和琳", "阿贵", "福康安", "张廷玉", "周培公", "熊赐履", "李光地", "陈廷敬", "于成龙", "南怀仁", "汤若望", "林则徐", "关天培", "嘉庆", "道光", "洪秀全",
			"杨秀清", "萧朝贵", "冯云山", "韦昌辉", "石达开", "林凤翔", "李开芳", "陈玉成", "李秀成", "田文镜", "洪宣娇", "咸丰", "同治", "光绪", "宣统", "慈禧",
			"慈安", "奕昕", "左宗棠", "曾国藩", "曾国荃", "刘永福", "李鸿章", "荣禄", "张之洞", "李莲英", "邓世昌", "丁汝昌", "曹雪芹", "朱元璋", "刘基", "宋濂",
			"高启", "李善长", "徐达", "常遇春", "邓愈", "汤和", "沐英", "冯胜", "朱亮祖", "傅友德", "朱允炆", "朱棣", "郑和", "铁铉", "解缙", "姚广孝", "王景",
			"邹辑", "唐赛儿", "唐寅", "文征明", "祝枝山", "周文宾", "冯梦龙", "吴承恩", "汤显祖", "戚继光", "严嵩", "严世蕃", "胡宗宪", "俞大猷", "谭纶", "海瑞",
			"李时珍", "徐霞客", "宋应星", "王守仁", "高拱", "张居正", "冯保", "徐阶", "王振", "刘瑾", "魏忠贤", "崇祯皇帝", "正德皇帝", "天启皇帝", "王承恩",
			"陈圆圆", "张献忠", "李自成", "熊廷弼", "孙承宗", "袁崇焕", "毛文龙", "王世贞", "顾起元", "何可纲", "赵率教", "祖大寿", "丘睿", "柳如是", "李香君",
			"邓子龙", "徐渭", "王抒", "杨大中", "方孝孺", "齐泰", "黄子澄  ", "铁木真", "术赤", "窝阔台", "察合台", "拖雷", "忽必烈", "博尔术", "博尔忽", "木华黎",
			"赤老温", "欧阳贞", "关汉卿", "王实甫", "白朴", "郑光祖", "周德清", "夏镇", "蒙哥", "土土哈", "床兀儿", "不花帖木儿", "燕铁木儿", "撒敦", "唐其势",
			"泰不花", "王保保", "伯颜", "脱脱", "陈也先", "倪云林", "司居敬", "速浑察", "相威", "黄道婆", "图帖睦尔", "雪别台", "刘杰", "杨琼", "郑露", "明玉珍",
			"刘福通", "陈友谅", "陈友定", "张士诚", "徐寿辉", "柯九思", "彭莹玉", "倪文俊", "张必先", "张定边", "妥欢贴睦尔", "赵孟頫", "管道升", "康里脱脱", "鲁明善",
			"汪汝懋", "张雨", "赛典赤·赡思丁", "盛懋", "黄公望", "察罕铁木儿", "亦黑迭儿丁", "也里迷失", "王开", "李渊", "李世民", "侯君集", "李靖", "魏征", "房玄龄",
			"杜如晦", "柴绍", "程知节", "尉迟恭", "秦琼", "长孙无忌", "李存恭", "封德彝", "段志玄", "刘弘基", "徐世绩", "李治", "武则天", "太平公主", "韦后",
			"李隆基", "杨玉环", "王勃", "陈子昂", "卢照邻", "杨炯", "王之涣", "安禄山", "史思明", "张巡", "雷万春", "李白", "高力士", "杜甫", "白居易", "王维",
			"孟浩然", "杜牧", "李商隐", "郭子仪", "张易之", "张昌宗", "来俊臣", "杨国忠", "李林甫", "高适", "王昌龄", "孙思邈", "玄奘", "鉴真", "高骈", "狄仁杰",
			"黄巢", "王仙芝", "文成公主", "松赞干布", "薛涛", "鱼玄机", "贺知章", "李泌", "韩愈", "柳宗元", "上官婉儿 五代十国：朱温", "刘仁恭", "丁会", "李克用",
			"李存勖", "葛从周", "王建", "刘知远", "石敬瑭", "郭威", "柴荣", "孟昶", "荆浩", "刘彟", "张及之", "杜宇", "高季兴", "喻皓", "历真", "李茂贞",
			"朱友珪", "朱友贞", "刘守光", "卢文进", "李嗣源", "冯行袭", "康义诚", "薛贻矩", "朱弘昭", "冯赟", "李存孝", "霍存", "张归霸", "张延寿", "氏叔琮", "朱瑾",
			"朱珍", "张存敬", "牛存节", "李罕之", "乐从训", "王师范", "康怀英", "王彦章", "时溥", "秦宗权", "史懿", "苏逢吉", "杨邡", "桑维汉", "耶律德光", "安重荣",
			"边光范", "袁继忠", "李筠", "薛怀让    宋：赵匡胤", "赵匡义", "石守信", "慕容延钊", "曹彬", "潘美", "赵普", "杨业", "田重进", "王禹偁", "林逋", "杨延昭",
			"杨文广", "包拯", "狄青", "寇准", "范仲淹", "司马光", "欧阳修", "苏轼", "苏辙", "王安石", "吕惠卿", "曾布", "曾巩", "苏洵", "宋江", "方腊", "岳飞",
			"秦桧", "韩世忠", "梁红玉", "赵构", "朱熹", "柳永", "黄庭坚", "秦观", "晏殊", "晏几道", "陆游", "辛弃疾", "魏良臣", "李清照", "唐婉", "史弥远",
			"韩佗胄", "贾似道", "丁大全", "文天祥", "陆秀夫", "高俅", "蔡京", "杨戬", "童贯", "张叔夜", "韩锜", "岳云", "张宪", "梅尧臣", "苏舜钦", "吕文焕",
			"吕文德", "杨幺", "沈括", "杨坚", "杨广", "杨勇", "翟让", "李密", "杨素", "杨玄感", "独孤皇后", "贺若弼", "韩擒虎", "牛弘", "史万岁", "宇文恺",
			"杨玄感", "宇文述", "何妥", "何稠", "裴矩", "陈棱", "宇文化及", "杨林", "王世充", "宇文智及", "宇文成都", "阴寿", "刘焯", "李春", "杨俊", "杨秀",
			"杨谅", "卢思道", "操天成", "明克让", "虞庆", "郑译", "梁士彦", "宇文善", "窦荣定", "长孙冕", "高颖", "智永禅师", "伍建章", "伍云召", "伍天锡", "鱼俱罗",
			"邱瑞", "定彦平", "魏文通", "新文礼 ", "拓跋珪", "拓跋嗣", "拓跋焘", "元雍", "元琛", "元晖", "法庆", "尔朱荣", "郦道元", "刘裕", "刘义隆", "徐羡之",
			"傅亮", "谢晦", "檀道济", "刘义康", "刘湛", "宇文泰", "高欢", "高洋", "宇文觉", "高长恭", "萧道成", "袁粲", "褚渊", "刘秉", "萧衍", "萧统", "陈霸先",
			"陈叔宝", "谢灵运", "杨大眼", "元英", "邢杲", "万俟丑奴", "阮孝绪", "王筠", "萧宝卷", "陈庆之", "萧子云", "萧子显", "杨炫之", "苏绰", "祖冲之", "贺拔岳",
			"贺拔允", "贺拔胜", "侯景", "魏收", "王僧辩", "萧绎", "庾信", "宇文护", "斛律光", "顾野王", "江总", "綦毋怀文", "颜之推", "施文庆", "沈客卿", "司马炎",
			"司马衷", "贾充", "贾南风", "王祥", "羊祜", "王浑", "王浚", "陆机", "陆云", "周处", "刘琨", "谢逖", "陶侃", "孙秀", "刘渊", "石勒", "石虎",
			"王弥", "苟晞", "潘岳", "石崇", "左思", "王览", "王导", "嵇康", "阮籍", "阮咸", "刘伶", "王戎", "杜预", "荀勖", "何曾", "张华", "司马攸",
			"司马玮", "司马亮", "司马伦", "司马冏", "司马颖", "司马颙", "司马乂", "司马越", "段匹磾", "张寔", "刘曜", "刘聪", "司马睿", "王羲之", "王献之", "桓温",
			"谢安", "谢玄", "谢道韫", "桓玄", "苻坚", "姚苌", "慕容垂", "陶渊明", "王敦", "司马道子", "孙恩", "谢琰", "王恭", "殷仲堪", "瘐楷", "卢循", "徐道覆",
			"王猛   ", "刘邦", "萧何", "曹参", "韩信", "张良", "英布", "周勃", "周亚夫", "吕雉", "吕禄", "吕产", "陈平", "灌婴", "灌夫", "郅都", "宁成",
			"张汤", "东方朔", "刘彻", "刘启", "刘安", "卫青", "卫子夫", "霍去病", "霍光", "刘贺", "田蚡", "窦婴", "苏建", "苏武", "司马相如", "卓文君", "司马谈",
			"司马迁", "扬雄", "李广", "李陵", "王莽", "赵飞燕", "赵合德", "刘秀", "马援", "邓禹", "吴汉", "盖延", "赵破奴", "张骞", "刘细君", "王昭君", "梁冀",
			"陈蕃", "窦武", "何进", "卢植", "皇甫嵩", "朱隽", "班超", "班固", "班昭", "董卓", "蔡邕", "袁绍", "袁术", "郑玄", "张衡", "贾谊", "晁错", "郭解",
			"剧孟   ", "嬴政", "吕不韦", "李斯", "尉缭", "王翦", "王贲", "李信", "蒙骜", "蒙武", "蒙恬", "嬴扶苏", "嬴胡亥", "赵高", "章邯", "司马欣", "董翳",
			"李由", "甘罗", "嫪毐", "阳泉君", "嬴子婴", "嬴成矫", "徐福", "卢生", "陈胜", "吴广", "项梁", "项羽", "张良", "韩信", "萧何", "刘邦", "陈平",
			"周勃", "夏侯婴", "曹参", "范增", "项伯", "项庄", "樊哙", "英布", "彭越", "熊心", "狐突", "狐偃", "狐毛", "介子推", "里克", "邳郑", "宋襄公",
			"秦穆公", "楚庄王", "石碏", "石厚", "州吁", "郑突", "郑忽", "老子", "孔子", "孙武", "左丘明", "伍子胥", "范蠡", "西施", "勾践", "阖闾", "夫差",
			"文种", "专诸", "要离", "庆忌", "吴王僚", "伊尹", "烛之武", "公子光", "魏舒", "晏婴", "庆父   战国：乐毅", "吴起", "孙膑", "庞涓", "廉颇", "赵牧",
			"赵奢", "赵括", "项燕", "田单", "韩非", "荀子", "庄子", "墨子", "惠子", "孟子", "燕丹", "荆轲", "高渐离", "樊於期", "孟尝君", "春申君", "信陵君",
			"平原君", "邹忌", "白起", "商鞅", "李悝", "蔺相如", "屈原", "魏斯", "乐羊", "西门豹", "孔伋", "杨朱", "聂政", "申不害", "尸佼", "赵武灵王", "匡章",
			"淳于髡", "张仪", "苏秦", "田辟疆", "田忌", "鬼谷子", "甘德", "石申", "李冰", "扁鹊", "范雎", "蔡泽", "郭隗", "唐蔑", "宋玉", "触龙", "毛遂",
			"鲁仲连", "公孙龙" };
	private final static String[] NAME_100_Number = new String[] { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈",
			"褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶",
			"姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马",
			"苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕",
			"殷", "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟",
			"平", "黄", "和", "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成",
			"戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒", "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强",
			"贾", "路", "娄", "危", "江", "童", "颜", "郭", "梅", "盛", "林", "刁", "钟", "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊",
			"胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "丁", "宣",
			"贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣",
			"翁", "荀", "羊", "於", "惠", "甄", "曲", "家", "封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫",
			"乌", "焦", "巴", "弓", "牧", "隗", "山", "谷", "车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁",
			"仇", "栾", "暴", "甘", "钭", "厉", "戎", "祖", "武", "符", "刘", "景", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎",
			"蓟", "薄", "印", "宿", "白", "怀", "蒲", "邰", "从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴",
			"鬱", "胥", "能", "苍", "双", "闻", "莘", "党", "翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍",
			"卻", "璩", "桑", "桂", "濮", "牛", "寿", "通", "边", "扈", "燕", "冀", "郏", "浦", "尚", "农", "温", "别", "庄", "晏", "柴",
			"瞿", "阎", "充", "慕", "连", "茹", "习", "宦", "艾", "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居",
			"衡", "步", "都", "耿", "满", "弘", "匡", "国", "文", "寇", "广", "禄", "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔",
			"隆", "师", "巩", "厍", "聂", "晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空", "曾", "毋", "沙", "乜",
			"养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查", "后", "荆", "红", "游", "竺", "权", "逯", "盖", "益", "桓", "公", "万",
			"俟", "司", "马", "上", "官", "欧", "阳", "夏", "侯", "诸", "葛", "闻", "人", "东", "方", "赫", "连", "皇", "甫", "尉", "迟",
			"公", "羊", "澹", "台", "公", "冶", "宗", "政", "濮", "阳", "淳", "于", "单", "于", "太", "叔", "申", "屠", "公", "孙", "仲",
			"孙", "轩", "辕", "令", "狐", "钟", "离", "宇", "文", "长", "孙", "慕", "容", "鲜", "于", "闾", "丘", "司", "徒", "司", "空",
			"丌", "官", "司", "寇", "仉", "督", "子", "车", "颛", "孙", "端", "木", "巫", "马", "公", "西", "漆", "雕", "乐", "正", "壤",
			"驷", "公", "良", "拓", "跋", "夹", "谷", "宰", "父", "谷", "梁", "晋", "楚", "闫", "法", "汝", "鄢", "涂", "钦", "段", "干",
			"百", "里", "东", "郭", "南", "门", "呼", "延", "归", "海", "羊", "舌", "微", "生", "岳", "帅", "缑", "亢", "况", "郈", "有",
			"琴", "梁", "丘", "左", "丘", "东", "门", "西", "门", "商", "牟", "佘", "佴", "伯", "赏", "南", "宫", "墨", "哈", "谯", "笪",
			"年", "爱", "阳", "佟", "第", "五", "言", "福", "百", "家", "姓", "终" };
	private final static String[] ENGLISH_NAMES = new String[] { "Aaron", "Abbott", "Abel", "Abner", "Abraham", "Adair",
			"Adam", "Addison", "Adolph", "Adonis", "Adrian", "Ahern", "Alan", "Albert", "Aldrich", "Alexander",
			"Alfred", "Alger", "Algernon", "Allen", "Alston", "Alva", "Alvin", "Alvis", "Amos", "Andre", "Andrew",
			"Andy", "Angelo", "Augus", "Ansel", "Antony", "Antoine", "Antonio", "Archer", "Archibald", "Aries", "Arlen",
			"Armand", "Armstrong", "Arno", "Arnold", "Arthur", "Arvin", "Asa", "Ashbur", "Atwood", "Aubrey", "August",
			"Augustine", "Avery", "Baird", "Baldwin", "Bancroft", "Bard", "Barlow", "Barnett", "Baron", "Barret",
			"Barry", "Bartholomew", "Bart", "Barton", "Bartley", "Basil", "Beacher", "Beau", "Beck", "Ben", "Benedict",
			"Benjamin", "Bennett", "Benson", "Berg", "Berger", "Bernard", "Bernie", "Bert", "Berton", "Bertram",
			"Bevis", "Bill", "Bing", "Bishop", "Blair", "Blake", "Blithe", "Bob", "Booth", "Borg", "Boris", "Bowen",
			"Boyce", "Boyd", "Bradley", "Brady", "Brandon", "Brian", "Broderick", "Brook", "Bruce", "Bruno", "Buck",
			"Burgess", "Burke", "Burnell", "Burton", "Byron", "Caesar", "Calvin", "Carey", "Carl", "Carr", "Carter",
			"Cash", "Cecil", "Cedric", "Chad", "Channing", "Chapman", "Charles", "Chasel", "Chester", "Christ",
			"Christian", "Christopher", "Clare", "Clarence", "Clark", "Claude", "Clement", "Cleveland", "Cliff",
			"Clifford", "Clyde", "Colbert", "Colby", "Colin", "Conrad", "Corey", "Cornelius", "Cornell", "Craig",
			"Curitis", "Cyril", "Dana", "Daniel", "Darcy", "Darnell", "Darren", "Dave", "David", "Dean", "Dempsey",
			"Dennis", "Derrick", "Devin", "Dick", "Dominic", "Don", "Donahue", "Donald", "Douglas", "Drew", "Duke",
			"Duncan", "Dunn", "Dwight", "Dylan", "Earl", "Ed", "Eden", "Edgar", "Edmund", "Edison", "Edward", "Edwiin",
			"Egbert", "Eli", "Elijah", "Elliot", "Ellis", "Elmer", "Elroy", "Elton", "Elvis", "Emmanuel", "Enoch",
			"Eric", "Ernest", "Eugene", "Evan", "Everley", "Fabian", "Felix", "Ferdinand", "Fitch", "Fitzgerald",
			"Ford", "Francis", "Frank", "Franklin", "Frederic", "Gabriel", "Gale", "Gary", "Gavin", "Gene", "Geoffrey",
			"Geoff", "George", "Gerald", "Gilbert", "Giles", "Glenn", "Goddard", "Godfery", "Gordon", "Greg", "Gregary",
			"Griffith", "Grover", "Gustave", "Guy", "Hale", "Haley", "Hamiltion", "Hardy", "Harlan", "Harley", "Harold",
			"Harriet", "Harry", "Harvey", "Hayden", "Heather", "Henry", "Herbert", "Herman", "Hilary", "Hiram",
			"Hobart", "Hogan", "Horace", "Howar", "Hubery", "Hugh", "Hugo", "Humphrey", "Hunter", "Hyman", "Ian",
			"Ingemar", "Ingram", "Ira", "Isaac", "Isidore", "Ivan", "Ives", "Jack", "Jacob", "James", "Jared", "Jason",
			"Jay", "Jeff", "Jeffrey", "Jeremy", "Jerome", "Jerry", "Jesse", "Jim", "Jo", "John", "Jonas", "Jonathan",
			"Joseph", "Joshua", "Joyce", "Julian", "Julius", "Justin", "Keith", "Kelly", "Ken", "Kennedy", "Kenneth",
			"Kent", "Kerr", "Kerwin", "Kevin", "Kim", "King", "Kirk", "Kyle", "Lambert", "Lance", "Larry", "Lawrence",
			"Leif", "Len", "Lennon", "Leo", "Leonard", "Leopold", "Les", "Lester", "Levi", "Lewis", "Lionel", "Lou",
			"Louis", "Lucien", "Luther", "Lyle", "Lyndon", "Lynn", "Magee", "Malcolm", "Mandel", "Marcus", "Marico",
			"Mark", "Marlon", "Marsh", "Marshall", "Martin", "Marvin", "Matt", "Matthew", "Maurice", "Max",
			"Maximilian", "Maxwell", "Meredith", "Merle", "Merlin", "Michael", "Michell", "Mick", "Mike", "Miles",
			"Milo", "Monroe", "Montague", "Moore", "Morgan", "Mortimer", "Morton", "Moses", "Murphy", "Murray", "Myron",
			"Nat", "Nathan", "Nathaniel", "Neil", "Nelson", "Newman", "Nicholas", "Nick", "Nigel", "Noah", "Noel",
			"Norman", "Norton", "Ogden", "Oliver", "Omar", "Orville", "Osborn", "Oscar", "Osmond", "Oswald", "Otis",
			"Otto", "Owen", "Page", "Parker", "Paddy", "Patrick", "Paul", "Payne", "Perry", "Pete", "Peter", "Phil",
			"Philip", "Porter", "Prescott", "Primo", "Quentin", "Quennel", "Quincy", "Quinn", "Quintion", "Rachel",
			"Ralap", "Randolph", "Raymond", "Reg", "Regan", "Reginald", "Reuben", "Rex", "Richard", "Robert", "Robin",
			"Rock", "Rod", "Roderick", "Rodney", "Ron", "Ronald", "Rory", "Roy", "Rudolf", "Rupert", "Ryan", "Sam",
			"Sampson", "Samuel", "Sandy", "Saxon", "Scott", "Sean", "Sebastian", "Sid", "Sidney", "Silvester", "Simon",
			"Solomon", "Spencer", "Stan", "Stanford", "Stanley", "Steven", "Stev", "Steward", "Tab", "Taylor", "Ted",
			"Ternence", "Theobald", "Theodore", "Thomas", "Tiffany", "Tim", "Timothy", "Tobias", "Toby", "Todd", "Tom",
			"Tony", "Tracy", "Troy", "Truman", "Tyler", "Tyrone", "Ulysses", "Upton", "Uriah", "Valentine", "Valentine",
			"Verne", "Vic", "Victor", "Vincent", "Virgil", "Vito", "Vivian", "Wade", "Walker", "Walter", "Ward",
			"Warner", "Wayne", "Webb", "Webster", "Wendell", "Werner", "Wilbur", "Will", "William", "Willie", "Winfred",
			"Winston", "Woodrow", "Wordsworth", "Wright", "Wythe", "Xavier", "Yale", "Yehudi", "York", "Yves",
			"Zachary", "Zebulon", "Ziv" };
	private Zhou_Word() {}

	/**
	 * @return Chinese Name(随机生成的姓名,姓是百家姓)
	 */
	public final static String getChineseName_Random() {
		int num = Zhou_StdRandom.uniform(NAME_100_Number.length-1);
		StringBuilder builder = new StringBuilder();
		builder.append(NAME_100_Number[num]);

		builder.append(NAME.toCharArray()[Zhou_StdRandom.uniform(NAME.length()-1)]);
		return builder.toString();
	}

	/**
	 * 
	 * @return Chinese History Name
	 */
	public final static String getChineseName() {
		java.util.Random random = new java.util.Random(System.nanoTime());
		int num = random.nextInt(ENGLISH_NAMES.length);
		StringBuilder builder = new StringBuilder();
		builder.append(HistoryName[num]);
		return builder.toString();
	}

	/**
	 * @return English Name
	 */
	public final static String getEnglishName() {
		java.util.Random random = new java.util.Random(System.nanoTime());
		int num = random.nextInt(ENGLISH_NAMES.length);
		StringBuilder builder = new StringBuilder();
		builder.append(ENGLISH_NAMES[num]);
		return builder.toString();
	}
	/**
	 * private static void isitA() throws IOException {
		final String s1 = "https://zhidao.baidu.com/question/366614659.html";
		File file = new File("/home/zhou/ssh_java/maven/" + "ming.txt");
		BufferedReader rBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		LineNumberReader lineReader = new LineNumberReader(rBufferedReader);
		StringBuilder builder = new StringBuilder();
		String var;
		while ((var = lineReader.readLine()) != null) {
			String[] strings = var.split(" ");
			builder.append(strings[0] + " ");
			System.out.println("line content:" + strings[0]);
		}
		lineReader.close();
		System.out.println("------------------------------------");
		System.out.println(builder.toString());
		String[] strings = builder.toString().split(" ");
		builder = null;
		builder = new StringBuilder();
		char c = (char) 34;// 用asiii码表转为这个""
		for (int i = 0; i < strings.length; i++) {
			if (i != strings.length - 1) {
				builder.append(c + strings[i] + c + ",");
			} else {
				builder.append(c + strings[i] + c);
			}
		}
		System.out.println(builder.toString());
	}
	 */
	
	/**
	 * public static void isitB() throws IOException {
		String s1 = "http://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
		File file = new File("/home/zhou/ssh_java/maven/" + "ming.txt");
		BufferedReader rBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		LineNumberReader lineReader = new LineNumberReader(rBufferedReader);
		StringBuilder builder = new StringBuilder();
		String var;
		while ((var = lineReader.readLine()) != null) {
			builder.append(var);
		}
		lineReader.close();
		var = null;
		var = builder.toString();
		char[] cs = var.toCharArray();
		builder = null;
		builder = new StringBuilder();
		for (int y = 0; y < cs.length; y++) {
			int i = cs[y];
			int n = (int) '，';// asiii码表
			int m = (int) '。';
			if (i != n && i != m) {
				if (y != cs.length - 1) {
					builder.append((char) 34 + "" + cs[y] + (char) 34 + ",");
				} else {
					builder.append((char) 34 + "" + cs[y] + (char) 34);
				}
			}
		}
		System.out.println(builder.toString());
	}
	 */

}
