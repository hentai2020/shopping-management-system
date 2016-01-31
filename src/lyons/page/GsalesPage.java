package lyons.page;

import java.util.ArrayList;

import lyons.dao.GsalesDao;
import lyons.entity.Gsales;
import lyons.tools.ScannerChoice;

public final class GsalesPage
{
	/*
	 * ÿ��������Ʒ�б�����
	 *gSid,gId,sId,date,sNum
	 */
	public static void dailySaleGoodsPage()
	{
		
		System.out.println("\t����ִ���г������۳���Ʒ�б�����\n");
		ArrayList<Gsales> GsalesList = new GsalesDao().dailyGsales();//���ս����۳���Ʒ���鼯

		if (GsalesList.size() <= 0)
		{
			System.err.println("\t������������Ʒ�۳�����");
			MainPage.commodityManagementPage();
		}else 
			{
				System.out.println("\t\t\t\t�����۳���Ʒ�б�\n");
				System.out.println("\t��Ʒ����\t\t��Ʒ�۸�\t\t��Ʒ����\t\t����\t\t��ע\n");
	
				for (int i = 0,length = GsalesList.size(); i < length; i++)
				{
					//��ȡ�۳���Ʒ��gname,gprice,gnum, allSum (������Ʒ�������ܺ�)
					Gsales gSales = GsalesList.get(i);
					System.out.print("\t"+gSales.getGName()+"\t\t"+gSales.getGPrice()+" $\t\t"+gSales.getGNum()+"\t\t"+gSales.getAllSnum());
					int gNUm = gSales.getGNum();
					if (gNUm==0)
					{
						System.out.println("\t\t����Ʒ���ۿ�");
					}else if (gNUm<10)
							{
								System.out.println("\t\t����Ʒ�Ѳ���10��");
							}else {
								System.out.println("\t\t-");
							}
					System.out.println("\t");
				}
				//����Ĵ������ȫ��д����,���Ǳ����û�����0. ����û����������֣���ô�죿//�ѽ����
				boolean bool = true;
				do
				{
					System.out.println("\n\n���� 0 ������һ���˵�");
					String choice = ScannerChoice.ScannerChoString();
					
					if (choice.equals("0"))
					{
						MainPage.salesManManagementPage();
						bool = false;
					}
					MainPage.commodityManagementPage();
				} while (bool);
			}
	}
}