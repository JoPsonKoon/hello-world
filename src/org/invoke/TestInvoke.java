package org.invoke;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author jopson
 * @Description TODO ()
 */
public class TestInvoke {
	public static void main(String[] args) {
		RealSubject realSubject = new RealSubject();
		// 生成代理类的对象
		Subject subject = (Subject) Proxy.newProxyInstance(
				realSubject.getClass().getClassLoader(), 
				realSubject.getClass().getInterfaces(), 
				new SubjectHandler(realSubject));
		subject.rent(); // 调用代理类的方法
	}
}

interface Subject {
	public void rent();
}

class RealSubject implements Subject {
	@Override
	public void rent() {
		System.out.println("I want to rent my house");
	}
}

class SubjectHandler implements InvocationHandler {
	private Subject subject;

	public SubjectHandler(Subject subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before rent house");
		method.invoke(subject, args);
		System.out.println("after rent house");
		return null;
	}
	/**
	 *      ┌─┐       ┌─┐ + +
	 *   ┌──┘ ┴───────┘ ┴──┐++
	 *   │                 │
	 *   │       ───       │++ + + +
	 *   ███████───███████ │+
	 *   │                 │+
	 *   │       ─┴─       │
	 *   │                 │
	 *   └───┐         ┌───┘
	 *       │         │
	 *       │         │   + +
	 *       │         │
	 *       │         └──────────────┐
	 *       │                        │
	 *       │                        ├─┐
	 *       │                        ┌─┘
	 *       │                        │
	 *       └─┐  ┐  ┌───────┬──┐  ┌──┘  + + + +
	 *         │ ─┤ ─┤       │ ─┤ ─┤
	 *         └──┴──┘       └──┴──┘  + + + +
	 *                神兽保佑
	 *               代码无BUG!
	 */
	

}