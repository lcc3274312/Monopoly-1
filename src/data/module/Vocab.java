package data.module;

public class Vocab {
	/** Name input prompt */
	public static final String NameInputPrompt = "���趨��ɫ%d�����֣�";
	
	/** Map Re-generate prompt */
	public static final String MapRegeneratePrompt = "����r�������ɵ�ͼ��������������ܵ�ͼ";
	
	/** Date output */
	public static final String DateInfo = "������2014��%d��%d��\n";
	
	/** Menu */
	public static final String CurrentPlayerInfo = "������%s�Ĳ���ʱ�䣬����ǰ��������%s��\n";
	public static final String[] Command = {
		"�鿴��ͼ",
		"�鿴ԭʼ��ͼ",
		"ʹ�õ���",
		"ǰ��ʮ����Ԥ��",
		"�鿴ǰ��ָ�������ľ�����Ϣ",
		"�鿴��ҵ��ʲ���Ϣ",
		"��������������",
		"����"
	};
	
	/** Player icon */
	public static final String[] PlayerIcon = {
		"��\u3000",   // player 1
		"��\u3000"    // player 2
	};
	
	/** Cell icon */
	public static final String[] CellIcon = {
		"��\u3000",   // cell for sold
		"��\u3000",   // item store
		"��\u3000",   // bank
		"��\u3000",   // news
		"��\u3000",   // lottery
		"��\u3000",   // get an item
		"ȯ\u3000",   // get coupon
		"��\u3000",   // cell of player 1
		"��\u3000"    // cell of player 2
	};
	
	public static final String[] CellTypeName = {
		"�ز�",
		"�����̵�",
		"����",
		"����",
		"��Ʊ",
		"���͵��ߵ�",
		"���͵�ȯ��"
	};
	
	public static final String[] StreetName = {
		"",     // when 0, the cell is not for sell
		"�ޤ��Ť���ظ�#%d",
		"�褳������ظ�#%d",
		"������ظ�#%d",
		"��������ظ�#%d",
		"�����ߤʤȾ��丮#%d",
		"�ȥ�å�����#%d",
		"��󥬲���#%d",
		"��Х������#%d"
	};
	
	public static final String BarrierInfo = "ǰ����%d����Ϊ·�ϣ���ע�⡣\n";
	public static final String NoBarrierInfo = "ǰ��%d����û��·�ϡ�\n";
	
	public static final String InputError = "�����õ�����ֵ�����������룺";
}
