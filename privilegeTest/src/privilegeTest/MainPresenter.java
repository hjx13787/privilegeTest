package privilegeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import privilegeTest.mina.MainClient;

public class MainPresenter {
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

	MainClient client = new MainClient();

	MainView view;

	public void initCard(int num) {
		for (int i = 0; mapcard.keySet().size() < num;) {
			StringBuilder cardnum = new StringBuilder("00000000");
			Random rm = new Random();
			for (int j = 0; j < 8; j++) {
				cardnum.append(nums[rm.nextInt(16)]);
			}
			mapcard.put(cardnum.toString(), "");
		}
		System.out.println(mapcard.keySet().size());
		saveCard();
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
			listc = cd.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 查找指令
	private String getCardSearch(String string) {
		return "1";
	}

	// 删除指令
	private String getCardDelete(String string) {
		return "1";
	}

	// 上传指令
	private String getCardUpload(String string) {
		return "1";
	}

	public void clearCard() {
		cd.deleteCardAll();

	}

	public void go() {
		new BaseDao().init();
		try {
			listc = cd.findAll();
		} catch (Exception e) {
			e.printStackTrace();
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
			for (; i <= 10; i++) {
				if (runMap.get(i) == null) {
					continue;
				}
				if (runMap.get(i) == 1) {
					uploadCard(deviceMap.get(i), listc);
					continue;
				}
				;
				if (runMap.get(i) == 2) {
					delete(deviceMap.get(i), listc);
					continue;
				}
				;
				if (runMap.get(i) == 3) {
					count(deviceMap.get(i), listc);
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
			e.printStackTrace();
		}

	}

	// 初始化设备
	private void deviceInit(String string, List<Card> listc2) {
		client.send(string, getDeviceInitMsg());
	}

	private String getDeviceInitMsg() {

		return "";
	}

	// 对比
	private void count(String string, List<Card> listc2) {
		
	}

	// 删除
	private void delete(String string, List<Card> listc2) {
		td.deleteTask(string);
		new Thread(new Delete(string)).start();
	}

	// 下载
	protected void uploadCard(String string, List<Card> listc2) {
		for (Card card : listc2) {
			Task t = new Task();
			t.setIp(string);
			t.setCard(card);
			t.setStatustype(privilegeType.waitupload.name());
			td.save(t);
		}
		new Thread(new Upload(string)).start();

	}

	public void setDeviceMap(Map<Integer, String> deviceMap) {
		this.deviceMap = deviceMap;
	}

	public void setRunMap(Map<Integer, Integer> runMap) {
		this.runMap = runMap;
	}

	public class Upload implements Runnable {
		String ip;

		Upload(String ip) {
			this.ip = ip;
		}

		@Override
		public void run() {
			List<Task> findTaskList = td.findTaskList(ip, privilegeType.waitupload);

			for (Task t : findTaskList) {
				byte[] send = client.send(ip, t.getCard().getUploadno());
				boolean flag = checkUploadMsg(send);
				if (flag) {
					t.setStatustype(privilegeType.uploaded.name());
				} else {
					t.setStatustype(privilegeType.unupload.name());
				}
				td.attachDirty(t);
			}
		}

		private boolean checkUploadMsg(byte[] send) {
			// TODO 自动生成的方法存根
			return false;
		}

	}

	public class Delete implements Runnable {
		String ip;

		Delete(String ip) {
			this.ip = ip;
		}

		@Override
		public void run() {
			List<Task> findTaskList = td.findTaskList(ip, privilegeType.waitdelete);
			for (Task t : findTaskList) {
				byte[] send = client.send(ip, t.getCard().getDeleteno());
				boolean flag = checkDeleteMsg(send);
				if (flag) {
					t.setStatustype(privilegeType.deleteed.name());
				} else {
					t.setStatustype(privilegeType.undelete.name());
				}
				td.attachDirty(t);
			}
		}

		// 判断是否成功
		private boolean checkDeleteMsg(byte[] send) {

			return false;
		}

	}

	public class Count implements Runnable {
		String ip;
		List<Card> list;
		List<Card> noList = new ArrayList<Card>();

		Count(String ip, List<Card> list) {
			this.ip = ip;
			this.list = list;
		}

		@Override
		public void run() {
			for (Card c : list) {
				byte[] send = client.send(ip, c.getSearchno());
				boolean flag = checkSearchMsg(send);
				if (!flag) {
					noList.add(c);
				}
			}

		}

		private boolean checkSearchMsg(byte[] send) {

			return false;
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
		Map<Integer, Integer> nums = new HashMap<Integer, Integer>();
		for (int i = 1; i < 11; i++) {
			String string = deviceMap.get(i);
			byte[] send = client.send(string, getCountPrivilegeMsg());
			int no = checkCountPrivilegeReturn(send);
			nums.put(i, no);
		}
		view.setNumText(nums.get(1), nums.get(2), nums.get(3), nums.get(4), nums.get(5), nums.get(6), nums.get(7), nums.get(8), nums.get(9), nums.get(10));

	}

	private int checkCountPrivilegeReturn(byte[] send) {
		return i;
	}

	// 统计权限命令
	private String getCountPrivilegeMsg() {

		return null;
	}

	public void setView(MainView view) {
		this.view = view;
	}
}
