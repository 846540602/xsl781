package org.xsl781.ui;

import java.util.Stack;

import android.app.Activity;
import android.content.Context;

/**
 * 应用程序Activity管理类：用于Activity管理和应用程序退出<br>
 */
public class ActivityStack {
	private static Stack<Activity> activityStack;
	private static ActivityStack instance;

	private ActivityStack() {
	}

	public static ActivityStack getInstance() {
		if (instance == null) {
			instance = new ActivityStack();
		}
		return instance;
	}

	/**
	 * 获取当前Activity栈中元素个数
	 */
	public int getCount() {
		if (activityStack == null)
			return 0;
		return activityStack.size();
	}

	/**
	 * 添加Activity到栈
	 */
	public void addActivity(Activity activity) {
		if (activityStack == null) {
			activityStack = new Stack<Activity>();
		}
		activityStack.add(activity);
		//	System.out.println("==ActivityStack addActivity" + activity.getLocalClassName());
	}

	/**
	 * 获取当前Activity（栈顶Activity）
	 */
	public Activity topActivity() {
		if (activityStack == null) {
			throw new NullPointerException(
					"Activity stack is Null,your Activity must extend KJActivity");
		}
		if (activityStack.isEmpty()) {
			return null;
		}
		Activity activity = activityStack.lastElement();
		return (Activity) activity;
	}

	/**
	 * 获取当前Activity（栈顶Activity） 没有找到则返回null
	 */
	public Activity findActivity(Class<?> cls) {
		Activity activity = null;
		for (Activity aty : activityStack) {
			if (aty.getClass().equals(cls)) {
				activity = aty;
				break;
			}
		}
		return (Activity) activity;
	}

	/**
	 * 结束当前Activity（栈顶Activity）
	 */
	public void finishActivity() {
		Activity activity = activityStack.lastElement();
		finishActivity((Activity) activity);
	}

	/**
	 * 结束指定的Activity(重载)
	 */
	public void finishActivity(Activity activity) {
		if (activity != null) {
			//	System.out.println("==ActivityStack finishActivity" + activity.getLocalClassName());
			activityStack.remove(activity);
			//	activity.finish();//此处不用finish
			activity = null;
		}
	}

	/**
	 * 结束指定的Activity(重载)
	 */
	public void finishActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (activity.getClass().equals(cls)) {
				finishActivity((Activity) activity);
			}
		}
	}

	/**
	 * 关闭除了指定activity以外的全部activity 如果cls不存在于栈中，则栈全部清空
	 * 
	 * @param cls
	 */
	public void finishOthersActivity(Class<?> cls) {
		for (Activity activity : activityStack) {
			if (!(activity.getClass().equals(cls))) {
				finishActivity((Activity) activity);
			}
		}
	}

	/**
	 * 结束所有Activity
	 */
	public void finishAllActivity() {
		for (int i = 0, size = activityStack.size(); i < size; i++) {
			if (null != activityStack.get(i)) {
				((Activity) activityStack.get(i)).finish();
			}
		}
		activityStack.clear();
	}

	/**
	 * 应用程序退出
	 * 
	 */
	public void AppExit(Context context) {
		try {
			finishAllActivity();
			Runtime.getRuntime().exit(0);
		} catch (Exception e) {
			Runtime.getRuntime().exit(-1);
		}
	}
}