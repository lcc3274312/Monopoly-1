package data.module;

public class Vocab {
	/** Name input prompt */
	public static final String NameInputPrompt = "请设定角色%d的名字：";
	
	/** Map Re-generate prompt */
	public static final String MapRegeneratePrompt = "输入r重新生成地图，其余任意键接受地图";
	
	/** Date output */
	public static final String DateInfo = "今天是2014年%d月%d日\n";
	
	/** Menu */
	public static final String CurrentPlayerInfo = "现在是%s的操作时间，您的前进方向是%s。\n";
	public static final String[] Command = {
		"查看地图",
		"查看原始地图",
		"使用道具",
		"前方十步内预警",
		"查看前后指定步数的具体信息",
		"查看玩家的资产信息",
		"心满意足扔骰子",
		"认输"
	};
	
	/** Player icon */
	public static final String[] PlayerIcon = {
		"○\u3000",   // player 1
		"□\u3000"    // player 2
	};
	
	/** Cell icon */
	public static final String[] CellIcon = {
		"◎\u3000",   // cell for sold
		"道\u3000",   // item store
		"银\u3000",   // bank
		"新\u3000",   // news
		"彩\u3000",   // lottery
		"卡\u3000",   // get an item
		"券\u3000",   // get coupon
		"●\u3000",   // cell of player 1
		"■\u3000"    // cell of player 2
	};
	
	public static final String[] CellTypeName = {
		"地产",
		"道具商店",
		"银行",
		"新闻",
		"彩票",
		"赠送道具点",
		"赠送点券点"
	};
	
	public static final String[] StreetName = {
		"",     // when 0, the cell is not for sell
		"まいづる鎮守府#%d",
		"よこすか鎮守府#%d",
		"くれ鎮守府#%d",
		"させぼ鎮守府#%d",
		"おおみなと警備府#%d",
		"トラック泊地#%d",
		"リンガ泊地#%d",
		"ラバウル基地#%d"
	};
	
	public static final String BarrierInfo = "前方第%d步处为路障，请注意。\n";
	public static final String NoBarrierInfo = "前方%d步内没有路障。\n";
	
	public static final String InputError = "不可用的输入值！请重新输入：";
}
