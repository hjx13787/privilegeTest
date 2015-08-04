package privilegeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;

import privilegeTest.mina.MainClient;
import privilegeTest.util.BasicJavaBeanModel;
import privilegeTest.util.ByteUtils;
import privilegeTest.util.Utils;

public class MainPresenter{
	CardDAO cd = new CardDAO();
	TaskDAO td = new TaskDAO();
	Map<String, String> mapcard = new HashMap<String, String>();
	String[] nums = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", };

	public enum privilegeType {
		waitupload, uploaded, unupload, waitdelete, deleteed, undelete
	}

	// 设备列表
	Map<Integer, String> deviceMap = new HashMap<Integer, String>();
	// 操作列表
	Map<Integer, Integer> runMap = new HashMap<Integer, Integer>();

	Map<String, ScheduledFuture> taskMap = new HashMap<String, ScheduledFuture>();

	List<Card> listc = new ArrayList<Card>();

	MainView view;

	public void initCard(int num) {
		setLog("开始初始化卡片，数量为" + num);
		for (int i = 0; mapcard.keySet().size() < num;) {
			StringBuilder cardnum = new StringBuilder("00000000");
			Random rm = new Random();
			for (int j = 0; j < 8; j++) {
				cardnum.append(nums[rm.nextInt(16)]);
			}
			mapcard.put(cardnum.toString(), "");
		}
		saveCard();
		setLog("初始化卡片完成");
		setCardList();
	}

	private void setLog(String string) {
		view.setLog(string);
	}

	private void saveCard() {
		try {
			List<Card> list = new ArrayList<Card>();
			Set<String> keySet = mapcard.keySet();
			for (String string : keySet) {
				String upload = getCardUpload(string);
				String delete = getCardDelete(string);
				String search = getCardSearch(string);
				Card c = new Card();
				c.setIdentifire(string);
				c.setUploadno(upload);
				c.setDeleteno(delete);
				c.setSearchno(search);
				list.add(c);
			}
			for (Card c : list) {
				cd.save(c);
			}
			setListc(cd.findAll());
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	// 查找指令
	private String getCardSearch(String string) {
		String s1 = "01 57 00 01 00 01 E4 02 ";
		String s2 = getCardByte(string);
		String search = s1 + s2 + "03 ";
		search += getCheckByte(search);
		return search;
	}

	// 校验位
	private String getCheckByte(String s) {
		byte[] hexStringToByteArray = ByteUtils.hexStringToByteArray(s.replaceAll(" ", ""));
		byte bcc = Utils.BCC(hexStringToByteArray, 0, hexStringToByteArray.length - 1);
		return ByteUtils.byteToHexString(bcc);
	}

	// 获得卡片字节
	private String getCardByte(String string) {
		StringBuilder substring = new StringBuilder("");
		for (int i = 16; i > 0; i = i - 2) {
			substring.append(string.substring(i - 2, i) + " ");
		}
		return substring.toString();
	}

	// 删除指令
	private String getCardDelete(String string) {
		String s1 = "01 57 00 01 00 01 E1 02 ";
		String s2 = getCardByte(string);
		String search = s1 + s2 + "03 ";
		search += getCheckByte(search);
		return search;
	}

	// 上传指令
	private String getCardUpload(String string) {
		String s1 = "01 57 00 01 00 01 E0 02 ";
		String s2 = getCardByte(string);
		String search = s1 + s2 + "15 08 03 11 03 16 08 03 11 03 0B 03 ";
		search += getCheckByte(search);
		return search;
	}

	public void clearCard() {
		cd.deleteCardAll();
		setListc(new ArrayList<Card>());
		setCardList();
	}

	public void go() {
		// boolean init = new BaseDao().init();
		try {
			listc = cd.findAll();
		} catch (Exception e) {
//			e.printStackTrace();
		}
	}

	public Map<Integer, String> getDeviceMap() {
		return deviceMap;
	}

	public Map<Integer, Integer> getRunMap() {
		return runMap;
	}

	int i;

	public void run() {
		try {
			listc = cd.findAll();
			if (listc == null) {
				return;
			}
			i = 1;
			view.setLog(null);
			for (; i <= 10; i++) {
				if (runMap.get(i) == null) {
					continue;
				}
				if (deviceMap.get(i) == null || deviceMap.get(i).equals("")) {
					continue;
				}
				if (runMap.get(i) == 1) {
					uploadCard(i, listc);
					continue;
				}
				;
				if (runMap.get(i) == 2) {
					delete(i, listc);
					continue;
				}
				;
				if (runMap.get(i) == 3) {
					count(i, listc);
					continue;
				}
				;
				if (runMap.get(i) == 4) {
					deviceInit(deviceMap.get(i), listc);
					continue;
				}
				;
			}
		} catch (Exception e) {
//			e.printStackTrace();
		}

	}

	// 初始化设备
	private void deviceInit(String string, List<Card> listc2) {
		MainClient client = new MainClient();
		setLog(string + "开始初始化设备");
		client.send(string, getDeviceInitMsg().replaceAll(" ", ""));
		setLog(string + "初始化设备完成");

	}

	private String getDeviceInitMsg() {
		String search = "01 57 00 01 00 01 E2 02 03 ";
		search += getCheckByte(search);
		return search;
	}

	// 对比
	private void count(int i, List<Card> listc2) {
		new Thread(new Count(i, listc2)).start();
	}

	// 删除
	private void delete(int i, List<Card> listc2) {
		String string = deviceMap.get(i);

		td.deleteTask(string);
		new Thread(new Delete(i)).start();
	}

	// 下载
	protected void uploadCard(int i, List<Card> listc2) {
		String string = deviceMap.get(i);

		td.deleteTaskAll(string);
		for (Card card : listc2) {
			Task t = new Task();
			t.setIp(string);
			t.setCard(card);
			t.setStatustype(privilegeType.waitupload.name());
			td.save(t);
		}
		new Thread(new Upload(i)).start();

	}

	public void setDeviceMap(Map<Integer, String> deviceMap) {
		this.deviceMap = deviceMap;
	}

	public void setRunMap(Map<Integer, Integer> runMap) {
		this.runMap = runMap;
	}

	// 下载
	public class Upload implements Runnable {
		String ip;
		MainClient client = new MainClient();
		int num;
		List<Card> list = new ArrayList<Card>();

		Upload(int ip) {
			num = ip;
			this.ip = deviceMap.get(i);
		}

		@Override
		public void run() {
			view.setLog(ip + "开始下载权限");
			int i = 0;
			int j = 0;
			try {
				List<Task> findTaskList = td.findTaskList(ip, privilegeType.waitupload);
				for (Task t : findTaskList) {
					j++;
					String uploadno = t.getCard().getUploadno();
					String replaceAll = uploadno.replaceAll(" ", "");
					String send = client.send(ip, replaceAll);
					boolean flag = checkUploadMsg(send);
					if (flag) {
						t.setStatustype(privilegeType.uploaded.name());
						i++;
					} else {
						t.setStatustype(privilegeType.unupload.name());
						list.add(t.getCard());
					}
					td.attachDirty(t);
					view.setText(num, j);
				}
			} catch (Exception e) {
				setLog(e.toString());
//				e.printStackTrace();
			}
			view.setLog(ip + "下载权限完成,下载了" + i + "条权限,有" + list.size() + "条下载失败\n" + list);
		}

		private boolean checkUploadMsg(String send) {
			if (send == null) {
				return false;
			}
			String substring = send.substring(25, 27);
			if (substring.equals("79")) {
				return true;
			}
			return false;
		}

	}

	// 删除
	public class Delete implements Runnable {
		String ip;
		MainClient client = new MainClient();
		List<Card> list = new ArrayList<Card>();
		int num;

		Delete(int i) {
			num = i;
			this.ip = deviceMap.get(i);
		}

		@Override
		public void run() {
			try {
				view.setLog(ip + "开始删除权限");
				int i = 0;
				int j = 0;
				List<Task> findTaskList = td.findTaskList(ip, privilegeType.waitdelete);
				for (Task t : findTaskList) {
					j++;
					String replaceAll = t.getCard().getDeleteno().replaceAll(" ", "");
					String send = client.send(ip, replaceAll);
					boolean flag = checkDeleteMsg(send);
					if (flag) {
						t.setStatustype(privilegeType.deleteed.name());
						i++;
					} else {
						t.setStatustype(privilegeType.undelete.name());
						list.add(t.getCard());
					}
					td.attachDirty(t);
					view.setText(num, j);
				}
				setLog(ip + "删除权限完成,删除了" + i + "条权限,有" + list.size() + "条删除失败\n" + list);
			} catch (Exception e) {
				setLog(e.toString());
//				e.printStackTrace();
			}
		}

		// 判断是否成功
		private boolean checkDeleteMsg(String send) {
			if (send == null) {
				return false;
			}
			String substring = send.substring(25, 27);
			if (substring.equals("79")) {
				return true;
			}
			return false;
		}

	}

	// 对比
	public class Count implements Runnable {
		String ip;
		List<Card> list;
		List<Card> noList = new ArrayList<Card>();
		MainClient client = new MainClient();
		int num;

		Count(int i, List<Card> list) {
			num=i;
			this.ip = deviceMap.get(i);
			this.list = list;
		}

		@Override
		public void run() {

			try {
				view.setLog(ip + "开始对比" );
				int i = 0;
				for (Card c : list) {
					i++;
					String send = client.send(ip, c.getSearchno().replaceAll(" ", ""));
					boolean flag = checkSearchMsg(send);
					if (!flag) {
						noList.add(c);
					}
					view.setText(num, i);
				}
				view.setLog(ip + "对比完成，有" + noList.size() + "张卡片没有，\n" + noList);
			} catch (Exception e) {
//				e.printStackTrace();
			}

		}

		private boolean checkSearchMsg(String send) {
			if (send == null) {
				return false;
			}
			return !send.contains("FF FF FF FF FF FF FF FF");
		}

	}

	public List<Card> getListc() {
		return listc;
	}

	public void setListc(List<Card> listc) {
		this.listc = listc;
	}

	// 读数
	public void summayAllDevice() {
		setLog(null);
		view.setNumText("失败", "失败", "失败", "失败", "失败", "失败", "失败", "失败", "失败", "失败");
		try {
			Map<Integer, Object> nums = new HashMap<Integer, Object>();
			for (int i = 1; i < 11; i++) {

				MainClient client = new MainClient();
				String string = deviceMap.get(i);
				setLog(string + "开始读数");
				String send = client.send(string, getCountPrivilegeMsg().replaceAll(" ", ""));
				if (send == null) {
					nums.put(i, "失败");
					setLog(string + "读数完成");
					continue;
				}
				int no = checkCountPrivilegeReturn(send);
				nums.put(i, no);
				setLog(string + "读数完成");
			}
			view.setNumText(nums.get(1), nums.get(2), nums.get(3), nums.get(4), nums.get(5), nums.get(6), nums.get(7), nums.get(8), nums.get(9), nums.get(10));
		} catch (Exception e) {
			setLog(e.toString());
//			e.printStackTrace();
		}

	}

	private int checkCountPrivilegeReturn(String s) {
		String substring = s.substring(25, 27);
		String substring2 = s.substring(28, 30);
		int parseInt = Integer.parseInt(substring, 16);
		int parseInt2 = Integer.parseInt(substring2, 16);
		int i = parseInt2 * 256 + parseInt;
		return i;
	}

	// 统计权限命令
	private String getCountPrivilegeMsg() {
		String search = "01 57 00 01 00 01 E3 02 03";
		search += getCheckByte(search);
		return search;
	}

	public void setView(MainView view) {
		this.view = view;
	}

	public void setCardList() {
		view.setCardList(listc);
		
	}
}
